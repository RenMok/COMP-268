/**
 * Written by Renfred Mok for COMP268 at Athabasca University January 30, 2021
 * Assignment 2, Question 8 This program creates a 2D array to form the
 * scoreboard for 2 players. It can process this information and find the
 * maximum points scored by each player and the maximum number of consecutive
 * wins for each player.
 */
public class BadmintonScoring {
    // Initialize a 2D array of type int with all the data entered
    int[][] scores = { { 0, 1, 2, 0, 0, 0, 0, 0, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 2, 3, 4, 5, 0, 0, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0, 16, 17, 18, 19, 20, 21 } };
    static final int PLAYER1 = 1; // Variable that makes it easier to refer to player 1
    static final int PLAYER2 = 2; // Variable that makes it easier to refer to player 2

    public int getContinuousPointsPlayer1() { // Method that finds the greatest consecutive score for player 1
        int continuousScore = 0; // Holds the current continuous score
        int maxContinuousScore = 0; // Holds the maximum continuous score
        for (int i = 0; i < scores[0].length; i++) { // 'for' loop checks each entry for a score
            if (scores[0][i] != 0) { // If the score is not a 0, it is a win
                continuousScore++; // The current continuous score increments
            } else { // If a 0 appears, that is the end of a continuous streak
                if (continuousScore > maxContinuousScore) {
                    maxContinuousScore = continuousScore; // the current score is assigned to the maximum score if it is
                                                          // bigger
                }
                continuousScore = 0; // continousScore is reset to 0 this still runs even if maxContinuousScore is
                                     // not reassigned
            }
        }
        if (continuousScore > maxContinuousScore) { // At the end of the for loop, check if the current continuous score
                                                    // is greater than the stored maximum continuous score.
            maxContinuousScore = continuousScore; // If so, replace the value in maxContinuousScore
        }
        return maxContinuousScore; // Returns the greatest continuous score for player 1
    }

    // This method works the exact same as the one above, except the variables are
    // pointed at the 2nd row of the array
    public int getContinuousPointsPlayer2() {
        int continuousScore = 0;
        int maxContinuousScore = 0;
        for (int i = 0; i < scores[1].length; i++) {
            if (scores[1][i] != 0) {
                continuousScore++;
            } else {
                if (continuousScore > maxContinuousScore) {
                    maxContinuousScore = continuousScore;
                }
                continuousScore = 0;
            }
        }
        return maxContinuousScore;
    }

    // This method finds max score for player 1, since the score already increments,
    // this finds the greatest number in the 1st row of the array
    public int getPlayer1Points() {
        int maxScore = 0; // Holds the max score
        for (int i = 1; i < scores[0].length; i++) { // Checks each item in array row 1
            if (maxScore < scores[0][i]) { // If the item is bigger than maxScore, its value
                maxScore = scores[0][i]; // is assigned to maxScore
            }
        }
        return maxScore; // Returns the greatest number in row 1 of the array
    }
// This method finds max score for player 2, since the score already increments,
    // this finds the greatest number in the 2nd row of the array
    public int getPlayer2Points() {
        int maxScore = 0; // Holds the max score
        for (int i = 1; i < scores[1].length; i++) { // Check each item in array row 2
            if (maxScore < scores[1][i]) { // If the item is bigger than maxScore, its value
                maxScore = scores[1][i]; // is assigned to maxScore
            }
        }
        return maxScore; // Returns the greatest number in row 2 of the array
    }
}