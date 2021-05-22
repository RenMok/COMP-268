public class snakeEyesSim {
public static void main(String[] args) {
    int counter = 1;
    int die1 = (int)(Math.random()*6) + 1 ;
    int die2 = (int)(Math.random()*6) + 1 ;
    while (die1 != 1 || die2 != 1) {
    die1 = (int)(Math.random()*6) + 1 ;
    die2 = (int)(Math.random()*6) + 1 ;
    counter ++;
    }
    System.out.println("Snake Eyes!! This took " + counter + " rolls!");
    System.out.println();
  
    }
}
