public class changeCounter {
     public static void main(String[] args) {
        int quarters;
        int dimes;
        int nickels;
        int pennies;
        double total;
        
         System.out.print("How many quarters do you have? ");
            quarters = TextIO.getlnInt();
         System.out.print("How many dimes do you have? ");
            dimes = TextIO.getlnInt();
         System.out.print("How many nickels do you have? ");
            nickels = TextIO.getlnInt();
         System.out.print("How many pennies do you have? ");
            pennies = TextIO.getlnInt();
      
            total = (quarters*0.25) + (dimes*0.1) + (nickels*0.05) + (pennies*0.01);
        
        System.out.println();   
        System.out.print("Your change adds up to a total of $");   
        System.out.printf("%1.2f", total);
        System.out.println();
     }       
}
