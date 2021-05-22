public class eggBatcher {
     public static void main(String[] args) {
        int eggs;
        int gross;
        int dozen;
        int remainder;
        
         System.out.print("How many eggs do you have? ");
            eggs = TextIO.getlnInt();
        if (eggs < 12) {
            System.out.print("You have fewer than a dozen eggs");
        } else if (eggs >= 12 && eggs < 144) {
            dozen = eggs/12;
            remainder = eggs%12;
            System.out.print("Your number of eggs is " + dozen + " dozen, and " + remainder);
        } else {
            gross = eggs/144;
            dozen = (eggs%144)/12;
            remainder = eggs%12;
            System.out.print("Your number of eggs is " + gross + " gross, " + dozen + " dozen, and " + remainder + ".");
        }
     }       
}
