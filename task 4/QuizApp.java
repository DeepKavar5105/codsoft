package com.codsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private List<Question> questions;
    private int score;
    private List<String> results;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
        this.results = new ArrayList<>();
        loadQuestions();
    }

    public void loadQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"A) Paris", "B) London", "C) Rome", "D) Berlin"}, 'A'));
        questions.add(new Question("Who wrote 'Hamlet'?", new String[]{"A) Charles Dickens", "B) William Shakespeare", "C) Mark Twain", "D) J.K. Rowling"}, 'B'));
        questions.add(new Question("What is the square root of 64?", new String[]{"A) 6", "B) 7", "C) 8", "D) 9"}, 'C'));
        // Add more questions as needed
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            displayQuestion(question);
            boolean answered = false;
            long startTime = System.currentTimeMillis();
            long endTime = startTime + 10 * 1000; // 10 seconds for each question

            while (System.currentTimeMillis() < endTime && !answered) {
                if (scanner.hasNext()) {
                    char answer = scanner.next().toUpperCase().charAt(0);
                    if (question.isCorrect(answer)) {
                        score++;
                        results.add(question.getQuestion() + " - Correct");
                    } else {
                        results.add(question.getQuestion() + " - Incorrect");
                    }
                    answered = true;
                }
            }

            if (!answered) {
                results.add(question.getQuestion() + " - No Answer");
                System.out.println("Time's up! Moving to the next question.");
            }
        }

        scanner.close();
        displayResults();
    }

    private void displayQuestion(Question question) {
        System.out.println(question.getQuestion());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }
        System.out.print("Enter your answer (A, B, C, or D): ");
    }

    private void displayResults() {
        System.out.println("\nQuiz Over! Your Score: " + score + "/" + questions.size());
        System.out.println("Summary of your answers:");
        for (String result : results) {
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.start();
    }
}

