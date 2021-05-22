/**
 * Written by Renfred Mok for COMP268 at Athabasca University January 11, 2021
 * Assignment 1, Question 2 This program prompts the user to input their monthly
 * savings commitment followed by their savings for each of 4 quarters for the
 * year. It the computes the bonus Space Inc. will offer at 3% for each quarter
 * that the user exceeds the commitment, and an additional 8% if the annual
 * savings exceeds the annual minimum. Additionally, the program will add to the
 * savings 1:1 for the portion of savings exceeding 125% of the annual minimum.
 * This program will crash for any input that is not suitable for type double.
 */

public class BonusOnSavings { // This class contains computeBonus
   // This method receives 5 values of type double and assigns them to variables
   public double computeBonus(double commitment, double q1, double q2, double q3, double q4) {
      double quarterlyMinimum = commitment * 3; // the quarterly minimum is 3 months of commitment
      double annualMinimum = commitment * 12; // the annual minimum is 12 months of commitment
      double annualSavings = q1 + q2 + q3 + q4; // the annual savings are the sum of the quarterly savings

      double q1Bonus; // variable for first quarter bonus
      double q2Bonus; // variable for 2nd quarter bonus
      double q3Bonus; // variable for 3rd quarter bonus
      double q4Bonus; // variable for 4th quarter bonus
      double annualBonus; // variable for annual bonus
      double additionalBonus; // variable for additional bonus if annual savings exceeds annual commitment by
                              // 25%

      if (q1 < quarterlyMinimum) { // If q1 is greater than the quarterly minimum, it is eligible for bonus
         q1Bonus = 0; // No bonus eligible if q1 is ineligible
      } else {
         q1Bonus = q1 * 0.03; // If q1 is eligible, a 3% bonus is calculated
      }
      if (q2 < quarterlyMinimum) { // Quarterly bonus calculation for quarter 2
         q2Bonus = 0;
      } else {
         q2Bonus = q2 * 0.03;
      }
      if (q3 < quarterlyMinimum) { // Quarterly bonus calculation for quarter 3
         q3Bonus = 0;
      } else {
         q3Bonus = q3 * 0.03;
      }
      if (q4 < quarterlyMinimum) { // Quarterly bonus calculation for quarter 4
         q4Bonus = 0;
      } else {
         q4Bonus = q4 * 0.03;
      }
      if (annualSavings < annualMinimum) { // Annual savings must exceed annual minimum to be eligible
         annualBonus = 0; // No bonus if ineligible
      } else {
         annualBonus = annualSavings * 0.08; // If eligible, the bonus is 8% of annualSavings
      }
      if (annualSavings < (annualMinimum * 1.25)) { // Test eligibility for additional bonus
         additionalBonus = 0; // No bonus if ineligible
      } else {
         additionalBonus = annualSavings - (annualMinimum * 0.25); // additional bonus is equal to the portion of
                                                                   // savings above 125% of annualMinimum
      }
      return q1Bonus + q2Bonus + q3Bonus + q4Bonus + annualBonus + additionalBonus; // All bonuses are added up and
                                                                                    // returned to the main method

   }
}

class Question2 extends BonusOnSavings{
   public static void main(String... args) {

      double commitment; // Variable to hold monthly savings commitment
      double q1; // Variable to hold savings for the first quarter
      double q2; // Variable for saving for 2nd quarter
      double q3; // Quarter 3 variable
      double q4; // Quarter 4 variable
      BonusOnSavings myBonus = new BonusOnSavings(); // Create an instance to call methods

      System.out.print(
            "Welcome to Space Inc.'s employee savings bonus calculator. Please enter your monthly savings commitment:  $");
      commitment = TextIO.getlnDouble(); // Receives user input for monthly commitment
      System.out.print("Please enter your savings for the 1st quarter:  $");
      q1 = TextIO.getlnDouble(); // Receives input for quarter 1
      System.out.print("Please enter your savings for the 2nd quarter:  $");
      q2 = TextIO.getlnDouble(); // Receives input for quarter 2
      System.out.print("Please enter your savings for the 3rd quarter:  $");
      q3 = TextIO.getlnDouble(); // Receives input for quarter 3
      System.out.print("Please enter your savings for the 4th quarter:  $");
      q4 = TextIO.getlnDouble(); // Receives input for quarter 4
      // Calls the computeBonus class, sending variables collected from user input and
      // Stores the returned value in variable bonus
      double bonus = myBonus.computeBonus(commitment, q1, q2, q3, q4);
      // Prints the final message including the calculated bonus
      System.out.print("Space Inc. will contribute a total bonus of $" + bonus + " to your savings this year.");

   }
}
