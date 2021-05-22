
/**
 * Written by Renfred Mok for COMP268 at Athabasca University
 * January 18, 2021
 * Assignment 1, Question 6
 * This program uses loops and branches to create a menu for the user to choose between
 * calculating the remaining side length of a right angle triangle given two side lengths
 * or determining whether it is a right angle triangle given 3 side lengths.
 * It uses a scanner and while loops to determine valid menu input so that the program 
 * does not have to be reinitiated if false options are entered.
 */
import java.util.Scanner; // Import the Scanner class

public class Triangle { // This class contains the operations Triangle, getA, getB, getC and
    // isRightTriangle
    private double a; // These 3 variables store the lengths of each side of a triangle
    private double b;
    private double c;

    public void triangle(double a, double b, double c) { // Takes input from main method and assigns them to variables
                                                         // in the Triangle class
        this.a = a; // this. is necessary to avoid issues with duplicate local variables
        this.b = b; // Assigns input variable to the private variable of the class
        this.c = c;
    }

    public double getA() { // Finds A if user has B and C
        a = Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2)); // A = square root of ((c^2) - (b^2))
        return a; // Send A back to main method
    }

    public double getB() { // Finds B if user has A and C
        b = Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2)); // B = square root of ((c^2) - (a^2))
        return b; // Send B back to main method
    }

    public double getC() { // Finds C if user has A and B
        c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)); // C = square root of ((a^2) + (b^2))
        return c; // Send C back to main method
    }

    private boolean rightTriangle; // variable to store true or false

    public boolean isRightTriangle() { // Determines if the triangle is a right angle triangle
        double hypotenuse = Math.pow(a, 2) + Math.pow(b, 2); // a^2 + b^2 stored into variable hypotenuse
        if (hypotenuse == Math.pow(c, 2)) { // Hypotenuse variable is compared with c^2
            rightTriangle = true; // Evaluates as true if hypotenuse and c^2 are equal
        } else {
            rightTriangle = false; // Evaluates as false if hypotenuse is not equal to c^2
        }
        return rightTriangle; // returns boolean to main method
    }
}

class Question6 {
    public static void main(String... args) {
        char option; // Used to select menu options
        double a; // Stores user input for length of side a
        double b; // Stores user input for length of side b
        double c; // Stores user input for length of side c
        boolean rightTriangle; // Used to receive boolean from isRightTriangle method

        Triangle calculation = new Triangle(); // Create an object of class Triangle called calculation
        Scanner scan = new Scanner(System.in); // Create a scanner object to accept input
        // Prints welcome message and menu options
        System.out.println("Welcome to the Pythagorean theorum calculator.");
        System.out.println("Please select an option below:");
        System.out.println(
                "a) I have 2 measurements. Calculate the length of the remaining side of a right angle triangle.");
        System.out.println("b) I have all 3 measurements. Tell me if this is a right angle triangle.");

        while (!scan.hasNext("[abAB]")) { // Checks for valid input, loops until valid input is entered
            // Prints an error message if invalid option selected
            System.out.println("You have entered an invalid option, please enter 'a' or 'b'");
            scan.next(); // Asks for input again if it fails conditions
        }
        option = scan.next().trim().charAt(0); // Removes blank space and turns string into type char.
        // The character is stored in variable option

        if (option == 'a' || option == 'A') { // First menu option, calculate remaining side
            // Prints instructions
            System.out.println("You have selected to find the remaining side length.");
            System.out.println("Sides A and B are adjacent to the right angle.");
            System.out.println("Side C is the hypotenuse, the longest side and opposite to the right angle.");
            System.out.println("Which side would you like to find? A, B or C?");
            // Asks user to enter which side they are trying to calculate
            while (!scan.hasNext("[abcABC]")) { // Checks for valid input
                System.out.println("You have entered an invalid option, please enter 'a','b' or 'c'"); // Error message
                                                                                                       // for invalid
                                                                                                       // input
                scan.next(); // Asks for input again if it fails conditions
            }
            option = scan.next().trim().charAt(0); // Stores user input as appropriate type

            if (option == 'a' || option == 'A') { // Menu option to calculate side a
                System.out.println("You have chosen to calculate side A.");
                a = 0; // set side a to 0
                System.out.println("Please enter the length of side B: ");
                b = scan.nextDouble(); // Accept input for side b
                System.out.println("Please enter the length of the hypotenuse (side C):");
                c = scan.nextDouble(); // Accept input for side c
                calculation.triangle(a, b, c); // Sends side lengths to Triangle class
                a = calculation.getA(); // Stores the value returned by method getA()
                System.out.println("The length of side A is " + a + " ."); // Prints the answer
            } else if (option == 'b' || option == 'B') { // Menu option to calculate side b
                System.out.println("You have chosen to calculate side B.");
                b = 0; // Set side b to 0
                System.out.println("Please enter the length of side A: ");
                a = scan.nextDouble(); // Accepts input for side a
                System.out.println("Please enter the length of the hypotenuse (side C):");
                c = scan.nextDouble(); // Accepts input for side b
                calculation.triangle(a, b, c); // Sends side lengths to Triangle class
                b = calculation.getB(); // Stores value returned by method getB()
                System.out.println("The length of side B is " + b + " ."); // Prints the answer
            } else { // Menu option to calculate the length of side c
                System.out.println("You have chosen to calculate side C (the hypotenuse).");
                c = 0; // Set side c to 0
                System.out.println("Please enter the length of side A: ");
                a = scan.nextDouble(); // Accept user input for side c
                System.out.println("Please enter the length of side B:");
                b = scan.nextDouble(); // Accept user input for side c
                calculation.triangle(a, b, c); // Sends side lengths to Triangle class
                c = calculation.getC(); // Stores value returned by method getC()
                System.out.println("The length of side C is " + c + " ."); // Prints the answer
            }
        } else { // 2nd option from the 1st menu, determine if a triangle is a right angle
                 // triangle
            System.out.println("You have selected option B. I will determine if your triangle has a right angle.");
            System.out.println("Please enter the length of side A: ");
            a = scan.nextDouble(); // Accept input for side A
            System.out.println("Please enter the length of side B:");
            b = scan.nextDouble(); // Accept input for side B
            System.out.println("Please enter the length of side C:");
            c = scan.nextDouble(); // Accept input for side C
            calculation.triangle(a, b, c); // Sends side lengths to Triangle class
            rightTriangle = calculation.isRightTriangle(); // Stores boolean returned by isRightTriangle()

            if (rightTriangle) { // Branch if it is a right angle triangle
                System.out.println("You've got a right angle triangle on your hands!"); // Print answer
            } else { // Branch if it is not a right angle triangle
                System.out.println("Sorry! This is not a right angle triangle."); // Print answer
            }
        }
        scan.close(); // Closes the scanner to prevent resource leak
    }

}
