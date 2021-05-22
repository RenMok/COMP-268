
/**
 * Written by Renfred Mok for COMP268 at Athabasca University 
 * January 27, 2021 - Assignment 2, Question 2: 
 * This program plays the game rock, paper, scissors, lizard, spock for the user.
 * No user input is in this program, both players of this game are computer generated.
 * The program stops when either player wins 4 consecutive times. Each move is printed
 * for users to see.
 */
import java.util.Random;

public class RockPaperScissorsLizardSpock {
    private int consecutiveWins; // Counts the current number of consecutive wins
    private int lastWinner; // Stores the last winner
    // Below are final variable declarations that allow the use of names to
    // permanently refer to integers representing either a move or a play
    public static final int LIZARD = 1;
    public static final int PAPER = 2;
    public static final int PLAYER1 = 8;
    public static final int PLAYER2 = 9;
    public static final int ROCK = 3;
    public static final int SCISSORS = 4;
    public static final int SPOCK = 5;

    public void play(int player1, int player2) { // Accepts ints as moves
        int currentWinner = 0; // Initialize the round with no current winner
        // Only 1 of the below if-else branches will execute based on the value of
        // player1
        if (player1 == SCISSORS) { // Scissors beats paper and lizard
            if (player2 == PAPER || player2 == LIZARD) {
                currentWinner = PLAYER1; // Declare winner as player 1
            } else if (player2 == ROCK || player2 == SPOCK) { // Scissors loses to rock and spock
                currentWinner = PLAYER2; // Declare winner as player 2
            } else {
                currentWinner = 0; // This is a tie
            }
        } else if (player1 == PAPER) {
            if (player2 == ROCK || player2 == SPOCK) { // Paper beats rock and spock
                currentWinner = PLAYER1;
            } else if (player2 == LIZARD || player2 == SCISSORS) { // Paper loses to lizard and scissors
                currentWinner = PLAYER2;
            } else {
                currentWinner = 0; // This is a tie
            }
        } else if (player1 == ROCK) { // Rock beats lizard and scissors
            if (player2 == LIZARD || player2 == SCISSORS) {
                currentWinner = PLAYER1;
            } else if (player2 == PAPER || player2 == SPOCK) { // Rock loses to paper and spock
                currentWinner = PLAYER2;
            } else {
                currentWinner = 0; // This is a tie
            }
        } else if (player1 == LIZARD) {
            if (player2 == SPOCK || player2 == PAPER) { // Lizard beats spock and paper
                currentWinner = PLAYER1;
            } else if (player2 == SCISSORS || player2 == ROCK) { // Lizard loses to scissors and rock
                currentWinner = PLAYER2;
            } else {
                currentWinner = 0; // This is a tie
            }
        } else if (player1 == SPOCK) { // Spock beats rock and scissors
            if (player2 == ROCK || player2 == SCISSORS) {
                currentWinner = PLAYER1;
            } else if (player2 == PAPER || player2 == LIZARD) { // Spock loses to paper and lizard
                currentWinner = PLAYER2;
            } else {
                currentWinner = 0; // This is a tie
            }
            // This is the end of all possible game path options
        }
        if (currentWinner == 0) { // This prevents ties from becoming the consecutive winner
            consecutiveWins = 0; // If there is a tie, the consecutive win counter resets
        } else if (lastWinner == currentWinner) {
            consecutiveWins++; // Consecutive win counter increments if the last winner and current winner are
                               // the same
        } else {
            consecutiveWins = 0; // All other conditions resets the consecutive win counter
        }
        lastWinner = currentWinner; // The winner of this round is always assigned to the lastWinner variable at the
                                    // end of the method
    }

    public int getConsecutiveWins() {
        return consecutiveWins; // Sends consecutiveWins to caller
    }

    public int getLastWinner() {
        return lastWinner; // Sends lastWinner to caller
    }

    public int random() {
        return new Random().nextInt(5) + 1; // Generates a random integer between 1 and 5 which will represent a move
    }

    public static String convert(int i) { // Converts the integer to it's associated move or player
        if (i == SCISSORS) {
            return "SCISSORS";
        } else if (i == PAPER) {
            return "PAPER";
        } else if (i == ROCK) {
            return "ROCK";
        } else if (i == LIZARD) {
            return "LIZARD";
        } else if (i == SPOCK) {
            return "SPOCK";
        } else if (i == PLAYER1) {
            return "Player 1";
        } else if (i == PLAYER2) {
            return "Player 2";
        } else if (i == 0) {
            return "Nobody";
        } else
            return "Ooops"; // Returns an error message if it is not an integers 0-5,8,9
    }
    public static void main(String... args) {
        int player1; // Holds the move for player 1
        int player2; // Holds the move for player 2
        int rounds = 1; // Holds the round number, initialized at 1
        RockPaperScissorsLizardSpock game = new RockPaperScissorsLizardSpock(); // Instance of the above class that
                                                                                // allows access to it
        while (game.getConsecutiveWins() < 4) { // Keeps looping until there are 4 consecutive wins
            player1 = game.random(); // Calls random method to assign random integer to player 1
            player2 = game.random(); // Calls random method to assign random integer to player 2
            game.play(player1, player2); // Sends the moves to the play method
            // Prints the results of the round
            System.out.println(rounds + ". Player 1 plays " + convert(player1) + " and player 2 plays " + convert(player2) + ".");
            System.out.println(convert(game.getLastWinner()) + " wins this round!");
            rounds++; // Increment the number of rounds
        }
        // Final message declaring the winner after x amount of rounds
        System.out.println("After " + (rounds - 1) + " rounds, " + convert(game.getLastWinner())
                + " wins the game with 4 consecutive wins!");
    }
}