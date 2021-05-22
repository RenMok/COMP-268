
/**Written by Renfred Mok for COMP268 at Athabasca University
 * January 22, 2021
 * Assignment 1, Question 7
 * This program prompts the user to input a number and sends it to
 * and ArrayList operation. If the number is even, the operation halves
 * it. If the number is even, the function multiples it by 3, the adds 1.
 * This loops until the number reaches 1. At each step, the new  number is
 * added to the ArrayList which becomes a Hailstone Sequence. The sequence
 * is then returned to the main method where its size is determined.
 * The program then prints the sequence and the number of steps it took
 * to reach 1.
 * */

import java.util.ArrayList; // Allows use of ArrayList, which allows the creation of arrays with variable length
import java.util.Scanner; // Allows use of scanner for input

public class HailstoneSequence { // Contains the instructions for creating the Hailstone sequence
private HailstoneSequence(){ // This private constructor hides the implicit public one

}
    public static ArrayList<Integer> getHailstoneSequence(int n) { // operation that creates an ArrayList of integers
                                                                   // and receives 1 integer from the main method
        ArrayList<Integer> hailstoneSequence = new ArrayList<>(); // Creates an ArrayList where each sequence integer
                                                                  // can be stored
        while (n != 1) { // Loops the sequence until n = 1
            if (n % 2 == 0) { // if n is even
                n = n / 2; // The new n is half of the old n
                hailstoneSequence.add(n); // New n is added to the ArrayList
            } else { // if n is odd
                n = (n * 3) + 1; // n is multiplied by 3 and then add one, this becomes new n
                hailstoneSequence.add(n); // new n is added to the ArrayList
            }
        } // Loops back to the "while statement", where the condition of n is checked
          // again
        return hailstoneSequence; // returns the entire sequence to main method
    }
}
// Holds the main class which displays the functionallity of HailStoneSequence class
class Question7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Creates scanner object to accept input
        System.out.println("Enter a Number:  ");
        int n = scan.nextInt(); // Asks user for starting number
        scan.close(); // close scanner
        ArrayList<Integer> list = HailstoneSequence.getHailstoneSequence(n); // Assigns the ArrayList returned by the
                                                                             // getHailstoneSequence local variable
// Prints the starting number entered by the user
        System.out.println("The Hailstone Sequence starting with " + n + " is : ");
        System.out.println(HailstoneSequence.getHailstoneSequence(n)); // Prints the sequence of the ArrayList
        System.out.println("The process took " + list.size() + " steps to reach 1"); // Prints the size of the sequence
    }
}