import java.util.Random;
import java.util.Scanner;

public class Craps {
    public static void main(String[] args)
    {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        int die1 = rnd.nextInt(6) + 1;
        int die2 = rnd.nextInt(6) + 1;
        int crapsRoll = die1 + die2;

        boolean playAgain = true;

        while (playAgain) {

            System.out.println("Die 1: " + die1 + " Die 2: " + die2 + " Sum: " + crapsRoll);
            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.println("Craps! You lose.");
                playAgain = false;
            } else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("Natural! You win.");
                playAgain = false;
            } else {
                int point = crapsRoll;
                System.out.println("Point is set to: " + point);
                boolean pointMade = false;
                while (!pointMade) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    crapsRoll = die1 + die2;
                    System.out.println("Die 1: " + die1 + " Die 2: " + die2 + " Sum: " + crapsRoll);
                    if (crapsRoll == point) {
                        System.out.println("Made point! You win.");
                        pointMade = true;
                    } else if (crapsRoll == 7) {
                        System.out.println("Got a seven! You lose.");
                        pointMade = true;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
                playAgain = false;
            }
            System.out.print("Do you want to play again? (y/n): ");
            String answer = in.nextLine();

            if (answer.equalsIgnoreCase("y")) {
                playAgain = true;
                die1 = rnd.nextInt(6) + 1;
                die2 = rnd.nextInt(6) + 1;
                crapsRoll = die1 + die2;
            } else {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
        }
    }
}