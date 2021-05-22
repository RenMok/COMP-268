public class nameCounter {
     public static void main(String[] args) {
        String input;
        int space;
        String firstName;
        String lastName;
        
         System.out.print("Please enter your first and last name separated by a space. ");
            input = TextIO.getln();
            space = input.indexOf(' ');
            firstName = input.substring(0,space);
            lastName = input.substring(space+1); 

            System.out.printf("Your first name is %s, which has %d characters %n", firstName, firstName.length());
            System.out.printf("Your last name is %s, which has %d characters %n", lastName, lastName.length());
            System.out.printf("Your initials are %s%s%n", firstName.charAt(0), lastName.charAt(0));
        
     }       
}
