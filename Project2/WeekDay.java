
/**
 * Written by Renfred Mok for COMP268 at Athabasca University 
 * January 27, 2021 - Assignment 2, Question 6: 
 * This program calculates the day of the week for any given day between March 1, 1900 and February 1, 2100.
 * The main method checks for valid input that is in the correct format, is a legal date and is within the date range.
 * When successful, the days are added together from 1/1/1900 to the input date and divided by 7 to find the corresponding weekday
 */
import java.util.Scanner;

public class WeekDay {
    private int numberOfDays = 0; // Variable that will hold the number of days between 1/1/1900 to the input date
    // Below are final variables that allow the use of month and day names rather
    // than integers
    public static final int APRIL = 4;
    public static final int AUGUST = 8;
    public static final int DECEMBER = 12;
    public static final int FEBRUARY = 2;
    public static final int FRIDAY = 5;
    public static final int JANUARY = 1;
    public static final int JULY = 7;
    public static final int JUNE = 6;
    public static final int MARCH = 3;
    public static final int MAY = 5;
    public static final int MONDAY = 1;
    public static final int NOVEMBER = 11;
    public static final int OCTOBER = 10;
    public static final int SATURDAY = 6;
    public static final int SEPTEMBER = 9;
    public static final int SUNDAY = 0;
    public static final int THURSDAY = 4;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;

    public String getWeekDay(int day, int month, int year) { // Calculates the day of the week and returns a string
        int yearsPlusLeapDays; // Stores the number of days in the years leading up to the input year, includes
                               // leap year days
        int givenYearDays = 0; // Stores the number of days in the input year before the input date
        int dayOfTheWeek; // Stores the calculated integer for day of the week which will be converted to
                          // a string
        boolean leapYear = false; // Used to determine if the current year is a leap year, initializes as false

        if (year % 4 == 0) { // if branch determines if the current year is a leap year
            if ((year % 100 == 0) && (year % 400 != 0)) { // A leap year must be divisible by 4
                leapYear = false; // If it is also divisible by 100, it is not a leap year, unless it is divisible
                                  // by 400
            } else
                leapYear = true; // All other cases divisible by 4 are leap years
        } // If not divisible by 4, leapYear remains as default false
        yearsPlusLeapDays = ((year - 1900) * 365) + ((year - 1900) / 4); // Add all the days for the years leading to
                                                                         // the current year, plus applicable leap days
        if (leapYear && (month == JANUARY || month == FEBRUARY)) { // If the current year is a leap year, but it is Jan
                                                                   // or Feb
            yearsPlusLeapDays = yearsPlusLeapDays - 1; // The leap day has not passed, so it is removed
        }
        // Since each the months are assigned to integers, they can be compared as such
        // and so days are added by 'if' branches
        // for each month consecutively, until it reaches it's own month, then it jumps
        // to the end of the if statements
        if (month >= JANUARY) { // The first month is simply the number of the day
            givenYearDays = givenYearDays + day;
        }
        if (month >= FEBRUARY) {
            givenYearDays = givenYearDays + 31; // The month of January is added, the day number was already added in
                                                // January
        }
        if (month >= MARCH) {
            givenYearDays = givenYearDays + 28; // March adds February's days
        }
        if (month >= APRIL) {
            givenYearDays = givenYearDays + 31; // March's days are added
        }
        if (month >= MAY) {
            givenYearDays = givenYearDays + 30; // April's days are added
        }
        if (month >= JUNE) {
            givenYearDays = givenYearDays + 31; // May's days are added
        }
        if (month >= JULY) {
            givenYearDays = givenYearDays + 30; // June's days are added
        }
        if (month >= AUGUST) {
            givenYearDays = givenYearDays + 31; // July's days are added
        }
        if (month >= SEPTEMBER) {
            givenYearDays = givenYearDays + 31; // August's days are added
        }
        if (month >= OCTOBER) {
            givenYearDays = givenYearDays + 30; // September's days are added
        }
        if (month >= NOVEMBER) {
            givenYearDays = givenYearDays + 31; // October's days are added
        }
        if (month == DECEMBER) {
            givenYearDays = givenYearDays + 30; // November's days are added
        } // December's days are never added because that would take us into January of
          // the next year
        numberOfDays = yearsPlusLeapDays + givenYearDays; // The total days are added together
        dayOfTheWeek = numberOfDays % 7; // The remainder is found after dividing by 7
        // The if-else branches below translate the dayOfTheWeek integer to its String
        // representation and then returns it to the caller.
        if (dayOfTheWeek == SUNDAY) {
            return "Sunday";
        } else if (dayOfTheWeek == MONDAY) {
            return "Monday";
        } else if (dayOfTheWeek == TUESDAY) {
            return "Tuesday";
        } else if (dayOfTheWeek == WEDNESDAY) {
            return "Wednesday";
        } else if (dayOfTheWeek == THURSDAY) {
            return "Thursday";
        } else if (dayOfTheWeek == FRIDAY) {
            return "Friday";
        } else
            return "Saturday";

    }

    public static void main(String[] args) {
        int day = 0; // Variable for storing the day
        int month = 0; // Variable for storing the month
        int year = 0; // Variable for storing the year
        String input = ""; // Variable for user to input the date
        boolean prompt = true; // Variable that enables while loop to validate input

        WeekDay weekDay = new WeekDay(); // New instance of WeekDay created to call methods
        Scanner scan = new Scanner(System.in); // Scanner object created for user input
        // Introductory text explains the function of the program and the valid date
        // range
        System.out.println(
                "Welcome! I can tell you the day of the week for any given day between March 1, 1900 and February 1, 2100.");
        while (prompt) { // While loop that enforces valid input values
            System.out.println("Please enter your date in the following format: YYYY/MM/DD");
            input = scan.nextLine().trim(); // Accepts input removing blank spaces
            if (input.length() != 10) { // Checks if input is exactly 10 characters
                System.out.println("This is an invalid input."); // Error message
                continue; // Loops back to input prompt
            } else // 10 character inputs pass the first stage of validation
                try { // try block handles non-integer character except where the slashes are
                    year = Integer.parseInt(input.substring(0, 4)); // Finds the substring representing year
                    month = Integer.parseInt(input.substring(5, 7)); // Finds the substring representing month
                    day = Integer.parseInt(input.substring(8)); // Finds the substring representing day
                } catch (Exception e) { // Catches any exceptions
                    System.out.println("Something went wrong, try again."); // Error message
                    continue; // Loops back to input prompt
                }
            // This if branch checks if the numbers are valid months and days
            if (month < 1 || month > 12 || day < 1 || day > 31 || (month == 2 && day > 29)
                    || ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30)) {
                System.out.println("There are invalid numbers in this date");
                // This branch checks if the date is within the specified range
            } else if (year < 1900 || year > 2100 || (year == 1900 && month < 3) || (year == 2100 && month >= 2)) {
                System.out.println("This date is not between March 1, 1900 and February 1, 2100.");
            } else {
                break; // If all checks are passed, then the date is valid and the while loop is broken
            }
        }
        // Prints the day of the week that the date falls on
        System.out.println("The date, " + input + ", falls on a " + weekDay.getWeekDay(day, month, year));
        scan.close(); // Closes the scanner to prevent leak of resources
    }
}
