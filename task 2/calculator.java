package com.codsoft;
import java.util.Scanner;
public class Task_2 {
	public static void main(String[] args) 
	  {
		  
	        Scanner scanner = new Scanner(System.in);

	        // Get the number of subjects
	        System.out.print("Enter the number of subjects: ");
	        int Subjects = scanner.nextInt();
	        
	        // Array to store marks
	        int[] marks = new int[Subjects];
	        int totalMarks = 0;
	        
	        // Input marks for each subject
	        for (int i = 0; i <  Subjects; i++) {
	            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
	            marks[i] = scanner.nextInt();
	            totalMarks += marks[i];
	        }
	        
	        // Calculate average percentage
	        double averagePercentage = (double) totalMarks /  Subjects;

	        // Calculate grade
	        char grade;
	        if (averagePercentage >= 90) {
	            grade = 'A';
	        } else if (averagePercentage >= 80) {
	            grade = 'B';
	        } else if (averagePercentage >= 70) {
	            grade = 'C';
	        } else if (averagePercentage >= 60) {
	            grade = 'D';
	        } else {
	            grade = 'F';
	        }
	        
	        // Display results
	        System.out.println("Total Marks: " + totalMarks);
	        System.out.println("Average Percentage: " + averagePercentage + "%");
	        System.out.println("Grade: " + grade);
	        
	        scanner.close();
	    }
}

