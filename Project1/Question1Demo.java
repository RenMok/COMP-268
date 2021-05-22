
/** Written by Renfred Mok for COMP268 at Athabasca University January 11, 2021
 * Assignment 1, Question 1: This is a demo class that allows users to input information
 * for each of the variable fields from the AddressBook class. It then prints out all of
 * the entire contents of the AddressBook instance including blank fields. It then
 * requests the user for input of 2 names to test the compareNames method
*/
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question1Demo extends AddressBook {
    public Question1Demo(String fn, String mn, String ln, String homeAddress, String businessPhone, String homePhone,
            String cellPhone, String skypeId, String facebookId, String personalWebsite) { // Allows access to the
                                                                                           // AddressBook constructor
    // This super statement allows access to the variables in from the superclass constructor
        super(fn, mn, ln, homeAddress, businessPhone, homePhone, cellPhone, skypeId, facebookId, personalWebsite);
    }

    public static void main(String... args) {
        String name1; // Holds first name for compareNames
        String name2; // Holds second name for compareNames
        Scanner scan = new Scanner(System.in); // Creates scanner object for user input
        String input = ""; // Used to fill in the parameters in the instance creation below
// Creates a new, empty AddressBook instance
        AddressBook contact = new AddressBook(input, input, input, input, input, input, input, input, input, input);
// The lines below prompts the user for inputs for each of the AddressBook fields and sends them to the set methods
        System.out.println("Please enter your first name: ");
        contact.setFirstName(scan.nextLine());
        System.out.println("Please enter your middle name: ");
        contact.setMiddleName(scan.nextLine());
        System.out.println("Please enter your last name: ");
        contact.setLastName(scan.nextLine());
        System.out.println("Please enter your home address: ");
        contact.setHomeAddress(scan.nextLine());
        System.out.println("Please enter your business phone number: ");
        contact.setBusinessPhone(scan.nextLine());
        System.out.println("Please enter your home phone number: ");
        contact.setHomePhone(scan.nextLine());
        System.out.println("Please enter your cell phone number: ");
        contact.setCellPhone(scan.nextLine());
        System.out.println("Please enter your Skype ID: ");
        contact.setSkypeId(scan.nextLine());
        System.out.println("Please enter your Facebook ID: ");
        contact.setFacebookId(scan.nextLine());
        System.out.println("Please enter the URL for your personal website: ");
        contact.setPersonalWebsite(scan.nextLine());
        System.out.println("Your address book entry is complete. Here is your information as follows:");
        // The first, middle and last names are concatenated using a stream and printed
        System.out.println("Name: " + Stream.of(contact.getFirstName(), contact.getMiddleName(), contact.getLastName())
                .collect(Collectors.joining(" "))); // Each name is joined with a space separating them
        // The rest of the AddressBook fields are printed
        System.out.println("Home Address: " + contact.getHomeAddress());
        System.out.println("Business Phone: " + contact.getBusinessPhone());
        System.out.println("Home Phone: " + contact.getHomePhone());
        System.out.println("Cell Phone: " + contact.getCellPhone());
        System.out.println("Skype ID: " + contact.getSkypeId());
        System.out.println("Facebook ID: " + contact.getFacebookId());
        System.out.println("Personal Website: " + contact.getPersonalWebsite());
        // The part below tests the compareNames method
        System.out.println(
                "Finally we will compare two names. Please enter two names in the following format: Alexander L. Higgins");
        System.out.println("Please enter the name of the first person: ");
        name1 = scan.nextLine(); // Input for first name
        System.out.println("Please enter the name of the second person: ");
        name2 = scan.nextLine(); // Input for 2nd name
        System.out.println(AddressBook.compareNames(name1, name2)); // Prints the result from compareNames method
        scan.close(); // Close scanner to prevent leak of resources
    }

}