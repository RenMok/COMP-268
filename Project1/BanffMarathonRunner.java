
/**
 * Written by Renfred Mok for COMP268 at Athabasca University January 11, 2021
 * Assignment 1, Question 4: The class BanffMarathonRunner is a subclass of AddressBook.
 * It allows the creation of BanffMarathonRunner objects that accept a first name, last name, 
 * marathon completion time and years participated in marathon. It also includes methods to 
 * compute the fastest runner, the second fastest runner, the average completion time and 
 * can create a list of all runners with above average completion times.
*/
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BanffMarathonRunner extends AddressBook {
    private int time; // Variable that stores time of completion (minutes) for a marathon runner
    private int years; // Variable that stores years participated in marathon
    // This constructor accepts a name, time of completion and years participated

    public BanffMarathonRunner(String fn, String ln, int min, int yr) {
        super(fn, ln); // Allows access to AddressBook variables fn and ln
        setFirstName(fn); // Sets the firstName variable in AddressBook
        setLastName(ln); // Sets the lastName variable in AddressBook
        time = min; // Sets the variable time in this class
        years = yr; // Sets the variable years in this class
    }

    public int getTime() { // A method for getting the time of completion from outside this class
        return time; // Returns private variable time to caller
    }

    public int getYears() { // A method for getting the years of participation from outside this class
        return years; // Returns private variable years to caller
    }

    // Method to find the fastest runner from an array of BanffMarathonRunner
    // instances, returns a single BanffMarathonRunner
    public static BanffMarathonRunner getFastestRunner(BanffMarathonRunner[] runners) {
        int fastestRun = 500; // Variable that holds fastest run, initial value is set to be a long run
        int fastestRunner = 0; // Stores the array position of the fastest runner
        for (int i = 0; i < runners.length; i++) { // 'for' loop to check the entire length of runners array
            if (fastestRun > runners[i].getTime()) {
                fastestRun = runners[i].getTime(); // Replaces the fastest run if it is faster than the current fastest
                fastestRunner = i; // Stores the array position of the fastest run
            }
        }
        return runners[fastestRunner]; // Returns the BanffMarathonRunner instance in the array position of
                                       // fastestRunner
    }

    // Method to find the second fastest runner from an array of BanffMarathonRunner
    // instances, returns a single BanffMarathonRunner
    public static BanffMarathonRunner getSecondFastestRunner(BanffMarathonRunner[] runners) {
        int secondFastestRun = 500; // Variable that holds 2nd fastest run, initial value is set to be a long run
        int secondFastestRunner = 0; // Stores the array position of the 2nd fastest runner
        for (int i = 0; i < runners.length; i++) { // 'for' loop checks each item in the array for the 2nd fastest
                                                   // runner
            // secondFastestRun will only be reassigned when the loop finds a quicker time
            // that is not equal to the fastest runner's time
            if (secondFastestRun > runners[i].getTime()
                    && runners[i].getTime() != getFastestRunner(runners).getTime()) {
                secondFastestRun = runners[i].getTime();
                secondFastestRunner = i; // Stores the array position for the 2nd fastest runner
            }
        }
        return runners[secondFastestRunner];// Returns the BanffMarathonRunner instance in the array position of
                                            // secondFastestRunner
    }
// This method takes an array of BanffMarathonRunner instances and averages their completion times, returns a double
    public static double getAverageTime(BanffMarathonRunner[] runners) {
        double totalTime = 0; // Variable that stores the sum of the runners' times, initialized at 0
        for (int i = 0; i < runners.length; i++) { // Adds the completion time of each runner to totalTime
            totalTime = totalTime + runners[i].getTime();
        }
        return totalTime / runners.length; // returns totalTime divided by the number of instance in the array
    }
// This method finds all runners who did better than average and appends them to a String
    public static String getAboveAverageRunners(BanffMarathonRunner[] runners) {
        List<String> aboveAverageRunners = new ArrayList<>(); // Create an arraylist to store the above average runners
        for (int i = 0; i < runners.length; i++) { // Checks each item in the runners array
        // If above average, first name, last name and years participated are retrieved and concatenated into 1 String
        // Using stream.of to join them with spaces between. This String is added as an arraylist entry to aboveAverageRunners   
            if (runners[i].getTime() <= getAverageTime(runners)) {
                aboveAverageRunners.add(
                        Stream.of(runners[i].getFirstName(), runners[i].getLastName()).collect(Collectors.joining(" "))
                                + ": years of participation - " + runners[i].getYears());
            }
        } // Stream is used to concatenate all the items in the arraylist with a comma and space between
        return aboveAverageRunners.stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    public void setTime(int time) { // Method for setting the time in BanffMarathonRunner
        this.time = time; // Assigns input variable to private variable time
    }

    public void setYears(int years) { // Method for setting the years in BanffMarathon Runner
        this.years = years; // Assigns input variable to private variable years
    }
}

class Question4 extends BanffMarathonRunner { // This class shows the capabilites of BanffMarathonRunner
    public Question4(String fn, String ln, int min, int yr) {
        super(fn, ln, min, yr);
    }

    public static void main(String... args) {
        // A new array of length 15 is created to hold BanffMarathonRunner instances
        BanffMarathonRunner[] runners = new BanffMarathonRunner[15];
        // 15 instances of BanffMarathonRunner are created and stored in the array 'runners' with the appropriate data inputs
        runners[0] = new BanffMarathonRunner("Elena", "Brandon", 341, 1);
        runners[0].setHomeAddress("2788 Michael Street, Houston, USA");
        runners[1] = new BanffMarathonRunner("Thomas", "Molson", 273, 2);
        runners[1].setHomeAddress("777 Maikfake Way, Molson, Canada");
        runners[2] = new BanffMarathonRunner("Hamilton", "Winn", 278, 5);
        runners[2].setHomeAddress("98 Windows Way, Hamilton, Ontario");
        runners[3] = new BanffMarathonRunner("Suzie", "Sarandin", 329, 7);
        runners[3].setHomeAddress("67 Taierdofis Parkway, Noodle, Santorini");
        runners[4] = new BanffMarathonRunner("Philip", "Winne", 445, 9);
        runners[4].setHomeAddress("9-53, Stahp Street, Vancouver, Canada");
        runners[5] = new BanffMarathonRunner("Alex", "Trebok", 275, 3);
        runners[5].setHomeAddress("22 Stoop Ed Drive, North Bay, Canada");
        runners[6] = new BanffMarathonRunner("Emma", "Pivoto", 275, 4);
        runners[6].setHomeAddress("67 Ronron Street, Manitoba, Canada");
        runners[7] = new BanffMarathonRunner("John", "Lenthen", 243, 1);
        runners[7].setHomeAddress("1364 M'eidup Rd, Nevada, Dubai");
        runners[8] = new BanffMarathonRunner("James", "Lean", 334, 1);
        runners[8].setHomeAddress("98 Jondeez Lees, North Bay, Canada");
        runners[9] = new BanffMarathonRunner("Jane", "Ostin", 412, 1);
        runners[9].setHomeAddress("73 Breaking Lane, Pocahontas, Canada");
        runners[10] = new BanffMarathonRunner("Emily", "Car", 393, 4);
        runners[10].setHomeAddress("33 Emily Carr Drive, Squahamish, Canada");
        runners[11] = new BanffMarathonRunner("Daniel", "Hamshire", 299, 4);
        runners[11].setHomeAddress("7457 Trebekky Way, New Hampshire, USA");
        runners[12] = new BanffMarathonRunner("Neda", "Bazdar", 343, 3);
        runners[12].setHomeAddress("2345 Nandos Chicken Alley, Toronto, Canada");
        runners[13] = new BanffMarathonRunner("Aaron", "Smith", 317, 6);
        runners[13].setHomeAddress("4167 University Avenue, Athabasca, Canada");
        runners[14] = new BanffMarathonRunner("Kate", "Hen", 265, 8);
        runners[14].setHomeAddress("2 Rue de la Blah, Paris, Canada");
        // Prints the fastest runner's first and last name
        System.out.println("The fastest runner this year is " + getFastestRunner(runners).getFirstName() + " "
                + getFastestRunner(runners).getLastName() + ".");
        //Prints the address of the fastest runner
        System.out.println("This person lives at " + getFastestRunner(runners).getHomeAddress() + ".");
        // Prints the time of completion for the fastest runner
        System.out.println("This person finished the marathon in " + getFastestRunner(runners).getTime() + " minutes.");
        // Prints the first and last name of the 2nd fastest runner
        System.out.println("The second fastest runner this year is " + getSecondFastestRunner(runners).getFirstName()
                + " " + getSecondFastestRunner(runners).getLastName() + ".");
        // Prints the address of the 2nd fastest runner
        System.out.println("This person lives at " + getSecondFastestRunner(runners).getHomeAddress() + ".");
        // Prints the time of completion for the 2nd fastest runner
        System.out.println(
                "This person finished the marathon in " + getSecondFastestRunner(runners).getTime() + " minutes.");
        // Prints the difference in time between the fastest and 2nd fastest runners
        System.out
                .println("This was " + (getSecondFastestRunner(runners).getTime() - getFastestRunner(runners).getTime())
                        + " minutes slower than first place.");
        // Prints the average time of completion formatted to 2 decimal places
        System.out.printf("The average time of completion in this group is %1.2f minutes. %n", getAverageTime(runners));
        // Prints the first and last names, and the years participated of all above average runners as 1 String
        System.out.println("The following individuals are as fast or faster than the average time : ");
        System.out.println(getAboveAverageRunners(runners) + ".");
    }
}
