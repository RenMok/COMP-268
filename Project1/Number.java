/**
 * Written by Renfred Mok for COMP268 at Athabasca University
 * January 13, 2021
 * Assignment 1, Question 9
 * This program requires no user input, once started, it will create an ArrayList which will contain
 * each number from 0 to 130. Each number will evaluate 4 different conditions, which can add descriptors
 * ("is odd", "hi five", "wow" and "prime") to it before it is stored in the array as a string. Once every
 * number from 0 to 130 with its descriptors is stored in the array, the whole array is sent to the main
 * method. A for loop is used to print each entry on its own line.
 */
import java.util.ArrayList; // Allows use of variable length arrays
import java.util.Objects; // Allows operation on objects (used to check for null entries)
import java.util.stream.Collectors; // Allows use of Collectors to format concatenation of strings
import java.util.stream.Stream; // Allows use of Stream which can turn many variables into a sequence

public class Number {
    public static ArrayList<String> iterate() {
        ArrayList<String> nums = new ArrayList<String>(); // Creates an ArrayList called nums of type string
        String odd; // Stores 'is odd' when number is odd
        String div5; // Stores 'hi five' when number is divisible by 5
        String div7; // Stores 'wow' when sum of the number and its subsequent number are divisible by 7
        String prime; // Store 'prime' when the number is prime
        String item; // Used to combine all strings into a single entry in the array
        String number; // Used to convert the number into a string for easy concatenation
        for (int i = 0; i < 131; i++) { // for loop that will repeat from 0 to 130, incrementing by 1 each time
            number = String.valueOf(i); // Turns the integer currently being worked on to a string
            // The current value of i is sent to each method to evaluate
            if (isOdd(i)) { // Is the number odd?
                odd = "is odd"; // If so, a phrase will be appended to the String item
            } else {
                odd = null;
            }
            if (Number.isDivisibleBy5(i)) { // Is the number divisible by 5?
                div5 = "hi five"; // If so, a phrase will be appended to the String item
            } else {
                div5 = null;
            }
            if (Number.isDivisibleBy7(i)) { // Is the sum of this number and the next divisible by 7?
                div7 = "wow"; // If so, a phrase will be appended to the String item
            } else {
                div7 = null;
            }
            if (Number.isPrime(i)) { // Is this a prime number?
                prime = "prime"; // If so, a phrase will be appended to the String item
            } else {
                prime = null;
            }
            item = (number + " " + Stream.of(odd, div5, div7, prime) // Concatenates all the phrases with the number
                    .filter(Objects::nonNull) // Removes all null variables
                    .collect(Collectors.joining(", ")) // All valid variables are joined with a comma and space between
                    + "."); // Add a period at the end of the sentence
            nums.add(item); // Add the final entry into the array
        }
        return nums; // Returns the full array
    }

    public static boolean isDivisibleBy5(int n) { // Only returns true if there is no remainder after n is divided by 5
        if (n % 5 == 0 && n != 0) {
            return true;
        }
        return false;
    }

    public static boolean isDivisibleBy7(int n) { // The sum of n and its subsequent number (n+1) must be divisible by 7
                                                  // to return true
        if ((n + n + 1) % 7 == 0 && n != 0) {
            return true;
        }
        return false;
    }

    public static boolean isOdd(int n) { // Returns true if there is a remainder when n is divided by 2
        if (n % 2 == 0) {
            return false;
        }
        return true;
    }

    public static boolean isPrime(int n) { // Evaluates whether an integer is a prime number
        if (n == 0 || n == 1) {
            return false;
        }
        //Since a prime number can only be divisible by 1 and itself, the for loop must start divisions at 2
        //(i = 2). We know that 0, 1 are not prime numbers, so we automatically return false for these values. 
        for (int i = 2; i <= n / 2; i++) { // a for loop that tries to divide n by every number between 2 and n / 2
            if (n % i == 0) { // If any of the divisors evaluates with no remainder, it is NOT prime
                return false; // The if condition is true, so false is returned, this method halts execution
            }
        }
        return true; // Returns true if the for has not found any divisors between 1 and n
    }
}

class Question9 {
    public static void main(String... args) {
        int length; // Variable used to determine size of ArrayList
        ArrayList<String> list = new ArrayList<String>(); // Create ArrayList object to receive input from iterate()
        list = Number.iterate(); // Stores array from iterate() method into local variable
        length = list.size(); // Stores list size to use a end condition for following for loop
        for (int i = 0; i < length; i++) { // Prints a line for each entry in the array
            System.out.println(list.get(i));
        }

    }
}