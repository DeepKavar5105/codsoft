package com.codsoft;

import java.util.Random;
import java.util.Scanner;

public class Task_1 {
	public static void main(String[] args) {
		
		 int maxAttempts = 10;
	     boolean playAgain = true;
	     int score = 0;
	        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
       
        
        while (playAgain) {
            int  Guess_number = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasWon = false;

            System.out.println("Guess a number between 1 and 100 : ");

            while (attempts < maxAttempts) {
                attempts++;
                System.out.print(" Attempt " + attempts + " : ");
                int userGuess = scanner.nextInt();

                if (userGuess == Guess_number) {
                    System.out.println("Congratulations! You guessed the number correctly...");
                    hasWon = true;
                    score++;
                    break;
                } else if (userGuess <  Guess_number) {
                    System.out.println("Too low! Try again...");
                } else {
                    System.out.println("Too high! Try again...");
                }
            }

            if (!hasWon) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + Guess_number );
            }

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine(); // Consume the newline character
            String respond = scanner.nextLine();
            playAgain = respond.equalsIgnoreCase("yes");

            if (!playAgain) {
                System.out.println("Thank you for playing! Your score is: " + score);
            }
        }

        scanner.close();
    }
}


