package com.codsoft;

import java.util.*;

class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    String schedule;
    List<Student> registeredStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    public boolean addStudent(Student student) {
        if (registeredStudents.size() < capacity) {
            registeredStudents.add(student);
            return true;
        }
        return false;
    }

    public boolean removeStudent(Student student) {
        return registeredStudents.remove(student);
    }

    public int availableSlots() {
        return capacity - registeredStudents.size();
    }

    @Override
    public String toString() {
        return courseCode + ": " + title + " - " + description + " (Capacity: " + capacity + ", Schedule: " + schedule + ", Available slots: " + availableSlots() + ")";
    }
}


class Student {
    String studentID;
    String name;
    List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public boolean registerCourse(Course course) {
        if (!registeredCourses.contains(course) && course.addStudent(this)) {
            registeredCourses.add(course);
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course) && course.removeStudent(this)) {
            registeredCourses.remove(course);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return studentID + ": " + name;
    }
}


public class CourseRegistrationSystem {
    static Map<String, Course> courses = new HashMap<>();
    static Map<String, Student> students = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Course");
            System.out.println("2. Add Student");
            System.out.println("3. List Courses");
            System.out.println("4. Register Course");
            System.out.println("5. Drop Course");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline
            switch (choice) {
                case 1:
                    addCourse(scanner);
                    break;
                case 2:
                    addStudent(scanner);
                    break;
                case 3:
                    listCourses();
                    break;
                case 4:
                    registerCourse(scanner);
                    break;
                case 5:
                    dropCourse(scanner);
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    
    public static void addCourse(Scanner scanner) {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Enter schedule: ");
        String schedule = scanner.nextLine();
        Course course = new Course(courseCode, title, description, capacity, schedule);
        courses.put(courseCode, course);
        System.out.println("Course added successfully.");
    }

    public static void addStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Student student = new Student(studentID, name);
        students.put(studentID, student);
        System.out.println("Student added successfully.");
    }

    public static void listCourses() {
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }

    public static void registerCourse(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        Student student = students.get(studentID);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        if (student.registerCourse(course)) {
            System.out.println("Course registered successfully.");
        } else {
            System.out.println("Failed to register course. It might be full or already registered.");
        }
    }

    public static void dropCourse(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        Student student = students.get(studentID);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        if (student.dropCourse(course)) {
            System.out.println("Course dropped successfully.");
        } else {
            System.out.println("Failed to drop course. It might not be registered.");
        }
    }
}

