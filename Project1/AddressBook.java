/**
 * Written by Renfred Mok for COMP268 at Athabasca University January 11, 2021
 * Assignment 1, Question 1: This is a class with no main method which can be
 * used to store contact data. It uses private variables so that they cannot be
 * tampered with outside of the set and get methods. It also includes a method
 * that can compare 2 names formatted as FirstName MiddleInitial LastName
 * (ie.John M Smith). There is an accompanying Question1Demo class that allows
 * users to interact and test cases.
 */
public class AddressBook {
    private String businessPhone; // holds business phone number
    private String cellPhone; // holds cellphone number
    private String facebookId; // holds Facebook ID
    private String firstName; // holds contact's first name
    private String homeAddress; // holds home address
    private String homePhone; // holds home phone number
    private String lastName; // holds contact's first name
    private String middleName; // holds contact's middle name
    private String personalWebsite; // holds personal website
    private String skypeId; // holds Skype ID

    public void setBusinessPhone(String businessPhone) { // Receives a string when called
        this.businessPhone = businessPhone; // Copies received input to private variable businessPhone
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone; // Copies received input to private variable cellPhone
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId; // Copies received input to private variable facebookId
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName; // Copies received input to private variable firstName
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress; // Copies received input to private variable homeAddress
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone; // Copies received input to private variable homePhone
    }

    public void setLastName(String lastName) {
        this.lastName = lastName; // Copies received input to private variable lastName
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName; // Copies received input to private variable middleName
    }

    public void setPersonalWebsite(String personalWebsite) {
        this.personalWebsite = personalWebsite; // Copies received input to private variable personalWebsite
    }

    public void setSkypeId(String skypeId) {
        this.skypeId = skypeId; // Copies received input to private variable skypeId
    }

    // This is a constructor with parameters to receive input for each of the
    // private variables stated above
    public AddressBook(String fn, String mn, String ln, String homeAddress, String businessPhone, String homePhone,
            String cellPhone, String skypeId, String facebookId, String personalWebsite) {
        // Each received input is assigned to the corresponding private variable
        firstName = fn;
        lastName = ln;
        middleName = mn;
        this.homeAddress = homeAddress;
        this.businessPhone = businessPhone;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
        this.skypeId = skypeId;
        this.facebookId = facebookId;
        this.personalWebsite = personalWebsite;
    }

    public AddressBook(String fn) { // This is a constructor that only receives a first name
        firstName = fn; // The input is assigned to firstName private variable
    }

    public AddressBook(String fn, String mn) { // This constructor receives first name and middle name
        // Received inputs are assigned to corresponding first and middle name variables
        firstName = fn;
        middleName = mn;
    }

    public AddressBook(String fn, String mn, String ln) { // This constructor receives first, middle and last names
        // Received inputs are assigned to corresponding first, middle and last name
        // variables
        firstName = fn;
        middleName = mn;
        lastName = ln;
    }

    // This method compares 2 names and returns a string.
    public static String compareNames(String name1, String name2) {
        int space1; // Variable to store the position of the space between first and middle names
        int space2; // Variable to store the position of the space between the middle and last names
        String firstName1; // Variable to store first person's first name
        String middleName1; // Variable to store first person's middle name
        String lastName1; // Variable to store first person's last name
        String firstName2; // Variable to store 2nd person's first name
        String middleName2; // Variable to store 2nd person's middle name
        String lastName2; // Variable to store 2nd person's last name
        String compareFirst; // Variable to store the response after comparing first names
        String compareMiddle; // Variable to store the response after comparing middle names
        String compareLast; // Variable to store the response after comparing last names

        space1 = name1.indexOf(' '); // Identify and store the position of the first space in the name of the 1st
                                     // person
        space2 = name1.lastIndexOf(' '); // Identify and store the position of the last space in the name of the 1st
                                         // person
        firstName1 = name1.substring(0, space1); // The 1st person's first name is taken as a substring from the 1st
                                                 // character up to the first space
        /**
         * The 1st person's middle name is taken as a substring from the character
         * following the 1st space up until the last space. Because this is the case, an
         * 'if' branch setting the string to empty is needed to prevent characters from
         * the last name being copied to the middle name in the case that a middle name
         * does not exist. Technically full middle names and even multiple middle names
         * can be accepted despite above comments requesting a middle initial.
         */
        if (space1 == space2) { // This identifies whether a middle name exists
            middleName1 = ""; // If no middle name exists, this declares it as empty, otherwise it may take
                              // the values from the last name as the middle name substring collects from the
                              // position after the first space
        } else {
            middleName1 = name1.substring((space1 + 1), space2);
        }
        lastName1 = name1.substring(space2 + 1); // The 1st person's last name is taken as a substring from the
                                                 // character following the last space to the end of the input variable
        // The next 5 lines repeat the process for name 2
        space1 = name2.indexOf(' ');
        space2 = name2.lastIndexOf(' ');
        firstName2 = name2.substring(0, space1);
        if (space1 == space2) {
            middleName2 = "";
        } else {
            middleName2 = name2.substring((space1 + 1), space2);
        }
        lastName2 = name2.substring(space2 + 1);
        // This compares each of the first, middle and last names, and returns a perfect
        // match message
        if (firstName1.equals(firstName2) && middleName1.equals(middleName2) && lastName1.equals(lastName2)) {
            return ("Congratulations, we found a perfect match for these two names!");
        }
        // If not a perfect match, first, middle and last names are compare to identify
        // which sections do match
        if (firstName1.equals(firstName2)) { // First names are compared
            compareFirst = ("The first names match."); // Part of the output string if first names match
        } else {
            compareFirst = ("The first names do not match. "); // Part of the output string if first names do not match
        }
        /**
         * The middle initials are compared to comply with the formatting of the
         * assignment parameters. All blank spaces are removed and only the first
         * character is compared. This should eliminate errors with user input (full
         * middle names, multiple middle names, odd spacing). If there is no middle
         * name, the first and last space are the same
         */
        if (middleName1.equals("") || middleName2.equals("")) { // This step prevents an error when charAt tries to take
                                                                // a character from an empty string
            compareMiddle = ("A middle name was missing. ");
        } else if (middleName1.trim().charAt(0) == middleName2.trim().charAt(0)) {
            compareMiddle = ("The middle name initials match. "); // Part of the output string if middle initials match
        } else {
            compareMiddle = ("The middle name initials do not match. "); // Part of the output string if middle initials
                                                                         // do not match
        }

        if (lastName1.equals(lastName2)) { // Last names are compared in the same process as the first names
            compareLast = ("The last names match.");
        } else {
            compareLast = ("The last names do not match. ");
        }
        // If a perfect match is not found, all of the comparisons are concatenated to
        // identify which sections of the names do match
        return ("A perfect match was not found. " + compareFirst + compareMiddle + compareLast);
    }

    public String getBusinessPhone() { // Returns value of businessPhone to caller
        return businessPhone;
    }

    public String getCellPhone() { // Returns value of cellPhone to caller
        return cellPhone;
    }

    public String getFacebookId() { // Returns value of facebookId to caller
        return facebookId;
    }

    public String getFirstName() { // Returns value of firstName to caller
        return firstName;
    }

    public String getMiddleName() { // Returns value of middleName to caller
        return middleName;
    }

    public String getHomeAddress() { // Returns value of homeAddress to caller
        return homeAddress;
    }

    public String getHomePhone() { // Returns value of homePhone to caller
        return homePhone;
    }

    public String getLastName() { // Returns value of lastName to caller
        return lastName;
    }

    public String getPersonalWebsite() { // Returns value of personalWebsite to caller
        return personalWebsite;
    }

    public String getSkypeId() { // Returns value of skypeId to caller
        return skypeId;
    }
}
