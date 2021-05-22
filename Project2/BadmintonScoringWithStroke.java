
/**
 * Written by Renfred Mok for COMP268 at Athabasca University 
 * January 31, 2021 - Assignment 2, Question 8: 
 * This is the 2nd part of question 8, which creates a class that extends the previous 
 * class to include the winning stroke for each point. This time, each score is 
 * associated with a winning stroke and stored as an item in an ArrayList. 
 * This class can find the stroke that scored the most for each player. 
 * The data is hardcoded into this program.
 */
import java.util.ArrayList;

public class BadmintonScoringWithStroke extends BadmintonScoring {
    // Creates a new ArrayList that stores Point objects, the name differs from the
    // API because it interferes with the function of the int array in
    // BadmintonScoring
    ArrayList<Point> scoreBoard = new ArrayList<>();
    int score1; // This variable is not used, but it is in the API
    int score2; // Variable not used
    static final int PLAYER1 = 1; // Variable for easy identification of player 1
    static final int PLAYER2 = 2; // Variable for easy identification of player 2
    static final String A = "slice"; // Variable for easier data input into array
    static final String C = "smash"; // Variable for easier data input into array
    static final String D = "drop";// Variable for easier data input into array
    static final String E = "net-shot";// Variable for easier data input into array
    static final String N = "0";// Variable for easier data input into array
// This operation creates the Point objects that will go into the ArrayList
    public void setScoreBoard() {
        // A 2D String array is created to hold the winning shots from each round
        String[][] stroke = { { N, A, C, N, N, N, N, N, A, C, N, N, N, N, N, N, N, N, N, N, C, N, N, N, N, N, N },
                { N, N, N, D, E, D, E, E, N, N, E, E, A, D, E, E, E, E, E, E, N, E, E, E, E, E, A } };
        for (int i = 0; i < stroke[0].length; i++) { // Each item in row 1 of the array is processed
            Point p = new Point(1, stroke[0][i], scores[0][i]); // A Point instance is created and assigned a player, stroke and score
            scoreBoard.add(p); // The point is added to the scoreBoard arrayList
        }
        for (int i = 0; i < stroke[1].length; i++) { // Each item in row 2 of the array is processed
            Point p = new Point(2, stroke[1][i], scores[1][i]); // A Point instance is created and assigned a player, a stroke and score
            scoreBoard.add(p); // The point is added to the scoreBoard arrayList
        }

    }
// A method to find the most common winning stroke for player 1
    public String getMostUsedStrokePlayer1() {
        setScoreBoard(); // The scoreboard must be created first when calling from another class
        int[] strokeCount = { 0, 0, 0, 0 }; // Int array is used to count the occurence of each stroke
        for (int i = 0; i < (scoreBoard.size() / 2) - 1; i++) { // Each item in the first half of the arrayList is processed
            if (A.equals(scoreBoard.get(i).getStroke())) {
                strokeCount[0]++; // Increments if slice is found in current instance
            }
            if (C.equals(scoreBoard.get(i).getStroke())) {
                strokeCount[1]++; // Increments if smash is found in current instance
            }
            if (D.equals(scoreBoard.get(i).getStroke())) {
                strokeCount[2]++; // Increments if drop is found in current instance
            }
            if (E.equals(scoreBoard.get(i).getStroke())) {
                strokeCount[3]++; // Increments if net-shot is found in current instance
            }
        }
        int largest = 0; // Holds the position of the largest integer in the int array strokeCount
        for (int i = 1; i < strokeCount.length; i++) { // Examines each item in strokeCount
            if (strokeCount[i] > strokeCount[largest]) {
                largest = i; // Stores the array position when a larger integer is found
            }
        }
        if (largest == 0) {
            return A; // returns slice for array position 0
        }
        if (largest == 1) {
            return C; // returns smash for array position 1
        }
        if (largest == 2) {
            return D; // returns drop for array position 2
        }
        if (largest == 3) {
            return E; // returns net-shot for array position 3
        } else
            return "A most used stroke could not be found"; // Error message if there is no most used stroke
    }
// This is the same method as above but for player 2. It examines the items in the 2nd half of the arrayList scoreBoard
    public String getMostUsedStrokePlayer2() {
        setScoreBoard();
        int[] strokeCount = { 0, 0, 0, 0 };
        for (int i = scoreBoard.size() / 2; i < scoreBoard.size(); i++) {
            if (A.equals(scoreBoard.get(i).getStroke())) {
                strokeCount[0]++;
            }
            if (C.equals(scoreBoard.get(i).getStroke())) {
                strokeCount[1]++;
            }
            if (D.equals(scoreBoard.get(i).getStroke())) {
                strokeCount[2]++;
            }
            if (E.equals(scoreBoard.get(i).getStroke())) {
                strokeCount[3]++;
            }
        }
        int largest = 0;
        for (int i = 1; i < strokeCount.length; i++) {
            if (strokeCount[i] > strokeCount[largest]) {
                largest = i;
            }
        }
        if (largest == 0) {
            return A;
        }
        if (largest == 1) {
            return C;
        }
        if (largest == 2) {
            return D;
        }
        if (largest == 3) {
            return E;
        } else
            return "A most used stroke could not be found";
    }
}
// This is a class for the Point objects stored in the arrayList above
class Point {
    private int player; // Stores the player number
    private int score; // Stores the score
    private static final int PLAYER1 = 1;
    private static final int PLAYER2 = 2;
    private String stroke; // Stores the winning stroke used if applicable

    public int getPlayer() {
        return player; // Sends player to the caller
    }

    public int getScore() {
        return score; // Sends score to the caller
    }
// Receieves the input information for each Point instance
    public Point(int player, String stroke, int value) {
        this.player = player; // Assign input value of player to private variable player
        this.stroke = stroke; // Assign input value of stroke to private variable stroke
        score = value; // Assign value of value to private variable score
    }

    public String getStroke() {
        return stroke; // Sends stroke to the caller
    }

}