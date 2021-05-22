
/**
 * Written by Renfred Mok for COMP268 at Athabasca University 
 * January 28, 2021 - Assignment 2, Question 4: 
 * This program plays 3 games of craps with for the user. It prints
 * out every roll and then prints out the number of wins and losses. 
 * I decided to implement a simple branch to allow a user to activate 
 * the program. The program ends after playing 1 game or the user 
 * types anything that does not start with a y when prompted.
 */
import java.util.Random;
import java.util.Scanner;

public class RandomSumGame {
    boolean start = true; // Boolean to start the play loop
    int d1; // Holds the value of die 1
    int d2; // Holds the value of die 2
    int sum; // Holds the sum of the 2 dice
    int valuePoint; // Holds the sum of dice if a 2, 3, 7, 11, or 12 are not initially rolled
    String status = ""; // Holds the win or lose status
    int win = 0; // Holds the number of wins
    int lose = 0; // Holds the number of losses
    int playCount = 0; // Counts the number of plays

    public void play(int d1, int d2) {// This receives 2 dice rolls and plays out the options
        sum = d1 + d2; // Find the sum of dice
        if (sum == 2 || sum == 3 || sum == 12) { // Automatic loss if roll is 2, 3 or 12
            status = "lose";
            System.out.println("You rolled " + d1 + " + " + d2 + " = " + sum + "; you lose.");
        } else if (sum == 7 || sum == 11) { // Natural win if roll is 7 or 11
            status = "win";
            System.out.println("You rolled " + d1 + " + " + d2 + " = " + sum + "; you win.");
        } else { // Any other roll prompts more rolls
            System.out.println(
                    "You rolled " + d1 + " + " + d2 + " = " + sum + "; you establish the value point " + sum + ".");
            valuePoint = sum; // The original roll becomes the value point
            sum = 0; // The dice are reset
            while (status.equals("")) { // Keep rolling until a win or loss condition
                rollDice(); // Calls the roll dice method which stores to class variables
                sum = this.d1 + this.d2; // Sums the dice from class variables
                if (sum == 7) { // 7 is the only loss condition at this point
                    System.out.println("    Roll again " + this.d1 + " + " + this.d2 + " = " + sum + "; you lose.");
                    status = "lose";
                    break; // A loss occurred, leave the loop
                } else if (sum == valuePoint) { // The value point is the only win condition at this point
                    System.out.println("    Roll again " + this.d1 + " + " + this.d2 + " = " + sum + "; you win.");
                    status = "win";
                    break; // A win occurred, leave the loop
                } else { // All other rolls loop back to the dice roll
                    System.out.println("    Roll again " + this.d1 + " + " + this.d2 + " = " + sum + "; roll.");
                }
            }
        }

    }

    public void play() { // Initiates the play sequence and loops until 3 games are played
        while (start) { // Keeps looping through the play sequence until playCount reaches 3
            rollDice(); // Call rollDice method
            play(d1, d2); // Send the rolled variables to the play method with parameters
            if (status.equals("win")) { // Checks the win status from a completed game
                win++; // Increments win counter
            } else if (status.equals("lose")) {
                lose++; // Increments lose count
            }
            status = ""; // Resets the status to empty
            playCount++; // Increment the play count
            if (playCount >= 3) {
                break; // Complete the loop once playCount has reached 3
            }
        }
    }
// Acts as a dice roll, assigning random integers between 1 and 6 to d1 and d2 class variables.
    public void rollDice() {
        d1 = new Random().nextInt(6) + 1; // Assign random roll to die 1 variable
        d2 = new Random().nextInt(6) + 1; // Assign random roll to die 2 variable
    }
}
// Class for testing the functionality of the program
class Question4 {
    public static void main(String... args) {
        RandomSumGame craps = new RandomSumGame(); // Create instance of RandomSumGame
        Scanner scan = new Scanner(System.in); // Create scanner object to accept user input

        System.out.println("Would you like to play craps? If so, please enter 'Y'.");
        char input = scan.next().toLowerCase().charAt(0); // Checks the first character for a 'y'
        if (input == 'y') {
            craps.play(); // Initiates full play sequence of craps game
            System.out.println("You played craps 3 times.");
            System.out.println("Wins: " + craps.win); // Print the number of wins
            System.out.println("Losses: " + craps.lose); // Print the number of losses
        } else {
            System.out.println("Okay, see ya next time!"); // Farewell message for those choosing not to play
        }
        scan.close(); // Close scanner to prevent resource leak
    }
}
