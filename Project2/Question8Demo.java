/**
 * Written by Renfred Mok for COMP268 at Athabasca University 
 * January 31, 2021 - Assignment 2, Question 8 
 * This program demonstrates the functionality of BadmintonScoring and its extended class BadmintonScoringWithStroke.
 * The data is all hardcoded in the classes, so there are no user inputs.
 */
public class Question8Demo {
    public static void main(String... args) {
        System.out.println("Welcome to the test of the BadmintonScoring class and its subclasses");
        BadmintonScoringWithStroke score = new BadmintonScoringWithStroke(); // Create instance to initialize the class
        System.out.println("In this match, player 1 scored " + score.getPlayer1Points() + " points.");
        System.out.println("player 2 scored " + score.getPlayer2Points() + " points.");
        System.out.println("Player 1 had a maximum win streak of " + score.getContinuousPointsPlayer1() + " points.");
        System.out.println("Player 2 had a maximum win streak of " + score.getContinuousPointsPlayer2() + " points.");
        System.out.println("Player 1 won the most using a " + score.getMostUsedStrokePlayer1() + ".");
        System.out.println("Player 1 won the most using a " + score.getMostUsedStrokePlayer1() + ".");
    }
}