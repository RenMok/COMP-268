/**
 * Written by Renfred Mok for COMP268 at Athabasca University January 16, 2021
 * Assignment 1, Question 3 This program asks the user to input 2 points on a
 * Cartesian plane and calculates the distance between them. The program breaks
 * down each point to an x and y coordinate and sends them to the method
 * "calculateDistance". The distance is returned to the user formatted to two
 * decimal points. The program accepts coordinates of any length that can fit
 * into type double, but will crash if nonnumerical characters is input, only 1
 * number is input, or separators other than a comma are used between
 * coordinates (space included).
 */

public class CartesianCoordinateSystem { // This class contains calculateDistance

    public double calculateDistance(double x1, double y1, double x2, double y2) { // This method receives the 4
                                                                                  // variables, x1, y1, x2, y2
        return Math.pow((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)), 0.5); // sqrt((x2-x1)^2
                                                                                 // + (y2-y1)^2) is calculated and sent
                                                                                 // back to caller
    }
}
class Question3 extends CartesianCoordinateSystem{
    public static void main(String... args) {
        String input; // Receives user input
        int comma; // Stores location of comma between coordinates
        String x; // Temporary variable to hold substring for coordinate x
        String y; // Temporary variable to hold substring for coordinate y
        // Below are the variables that will be sent to calculateDistance method
        double x1;
        double y1;
        double x2;
        double y2;

        CartesianCoordinateSystem calculation = new CartesianCoordinateSystem(); // Create a calculation instance in
                                                                                 // order to call the non-static method

        System.out.println("This program calculates the distance between two points on a Cartesian plane.");
        System.out.print("Please enter your first point in the following form: x,y \n");
        input = TextIO.getln().trim(); // Receives input of type String, removes any blank spaces
        comma = input.indexOf(','); // Finds the location of the comma that separates the coordinates
        x = input.substring(0, comma); // Stores the values in front of the comma into x variable
        y = input.substring(comma + 1); // Stores the values after the comma into the y variable
        x1 = Double.parseDouble(x); // Type conversion from String to double, stored into x1 variable
        y1 = Double.parseDouble(y); // Type conversion stored into y1 variable
        // Below the same operations occur to receive the 2nd point and break it down to
        // x and y coordinates
        System.out.print("Please enter your second point in the following form: x,y \n");
        input = TextIO.getln();
        comma = input.indexOf(',');
        x = input.substring(0, comma);
        y = input.substring(comma + 1);
        x2 = Double.parseDouble(x);
        y2 = Double.parseDouble(y);
        // Calls the calculateDistance, sending the 4 coordinates to the method and
        // storing the returned value in 'distance'
        double distance = calculation.calculateDistance(x1, y1, x2, y2);

        System.out.print("The distance between these two points is ");
        System.out.printf("%1.2f", distance); // formatted to two decimal points
        System.out.print("."); // Final output, this is all one line.
        System.out.println();

    }
}
