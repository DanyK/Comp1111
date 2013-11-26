package q2;

import java.util.Random;
import java.util.Scanner;

/**
 * <p>This is a guessing game program. It ask the user to guess a randomly
 * generated number and prompts if it is too high or too low. It records the
 * the amount of tries and reports that number when the answer is correct or if
 * they quit.</p>
 *
 * @author Dany Marquez SetC
 * @version 1.0
 */
public class Guess {
    /**
     * The random number to guess. 
     */
    private static int numToGuess;
    /**
     *  The user entered guess.
     */
    private static int guess;
    /**
     *  The count of guesses.
     */
    private static int guesses; 
    /**
     * <p>Scans the user guess and compares it to a randomly generated 
     *  number between 1 and 100.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        
        String tryAgain = new String("Y"); //The continue value
        final int quit = 0;                //The quit value
        final int max = 100;               //The max number to generate 
        
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
        
        while (tryAgain.equalsIgnoreCase("Y")) {
            guesses = 0;
            numToGuess = generator.nextInt(max) + 1;
            
            System.out.println("Guess a number between 1 and 100 [0 to quit]:");
            guess = scan.nextInt();
            guesses++;
                                    
            while (guess != numToGuess && guess != quit) {
                guessing();
            }
            if (guess == numToGuess) {
                System.out.println("That is correct! You took " + guesses
                        + " guesses");
            } else if (guess == 0) { //Game ends
                System.out.println("You have ended your game. Goodbye.");
            }
                                  
            System.out.println("Would you like to try again Y/N?");
            tryAgain = scan.next();
        }
        
        if (guess != numToGuess) {
            System.out.println("You quit after " + guesses + " guesses and "
                    + " the number was " + numToGuess);
        }
    }
            
    /**
     * <p> This method compares the guess to the generated number and lets
     * the user know if they are guessing higher or lower than the number.
     * It prompts for another guess and counts the amount of tries.</p>
     */
    private static void guessing() {
        Scanner scan = new Scanner(System.in);
        if (guess < numToGuess) {
            System.out.println("The number is too low, try again");
        }
        if (guess > numToGuess) {
            System.out.println("The number is too high, try again");
        }
        guess = scan.nextInt();
        guesses++;
    }
}
