package project01pm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class mastermind {

    public static void main(String[] args) {

        int n = 12;

        // generate a random number as the correct ans
        Random rand = new Random();
        int number1 = rand.nextInt(1, 7);
        int number2 = rand.nextInt(1, 7);
        int number3 = rand.nextInt(1, 7);
        int number4 = rand.nextInt(1, 7);

        String answerStr = Integer.toString(number1) + Integer.toString(number2) + Integer.toString(number3)
                + Integer.toString(number4);

        System.out.println("Random generated number: " + answerStr);

        while (n != 0) {
            // scanner object to take in input of a 4 digit number (1-6)
            System.out.print("Enter a 4 digit number using digits 1 to 6: ");
            Scanner scanner = new Scanner(System.in);
            String numberStr = scanner.nextLine();
            n--;

            int number = Integer.parseInt(numberStr);

            // Validate user input
            if (!numberStr.matches("[1-6]{4}")) {
                System.out.println("Invalid guess! Please enter a 4-digit number with digits between 1 and 6.");
                continue;
            }

            int colourPosition = 0;
            int colour = 0;

            boolean[] checkedAnswer = new boolean[4]; // Tracks checked digits in the answer
            boolean[] checkedGuess = new boolean[4]; // Tracks checked digits in the guess

            // First pass: Check for correct number in the correct position
            for (int i = 0; i < 4; i++) {
                if (numberStr.charAt(i) == answerStr.charAt(i)) {
                    colourPosition++;
                    checkedAnswer[i] = true; // Mark as checked in the answer
                    checkedGuess[i] = true; // Mark as checked in the guess
                }
            }

            // Second pass: Check for correct number in the wrong position
            for (int i = 0; i < 4; i++) {
                if (!checkedGuess[i]) { // If this digit hasn't already been matched
                    for (int j = 0; j < 4; j++) {
                        if (!checkedAnswer[j] && numberStr.charAt(i) == answerStr.charAt(j)) {
                            colour++;
                            checkedAnswer[j] = true; // Mark as checked in the answer
                            break;
                        }
                    }
                }
            }

            //add in a guess history to check what number permutation was guessed

            // String[] guessHistory = new String[n - 1];
            // for (int i = 0; i < n - 1; i++) {
            //     guessHistory[i] = "Number input: " + numberStr + "\n" + "CP: " + colourPosition + "\n" + "C: " + colour;
            // }

            // System.out.println("Number input: " + numberStr + "\n" + "CP: " + colourPosition + "\n" + "C: " + colour
            //         + "\n Number of tries left: " + n);

            if (numberStr.equals(answerStr)) {
                System.out.println("You guessed the answer!");
                // for (String s : guessHistory) {
                //     System.out.println(s);
                // }
                scanner.close();
                break;
            }

            if (n < 1) {
                System.out.println("No more tries left. You lose!");
                break;
            }

        }

    }

}
