/**
 * @author Alejandro Ceva
 * @version Jan 2022
 */
import
 java.util.Scanner;

public class Craps
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Craps game!");
        System.out.println("Would you like to play? (Y/N)");
        Scanner scan1 = new Scanner(System.in);
        String start = scan1.nextLine();
        Die dice = new Die();
        System.out.println("Do you need the instructions for craps? (Y/N)");
        String rules = scan1.nextLine();
        if (rules.equalsIgnoreCase("Y"))
        {
            System.out.println("1: Roll two six-sided dice and add the numbers rolled together.");
            System.out.println("2: On the first roll, a 7 or an 11 automatically wins, and a 2, 3, or 12 automatically loses, and the game is over.");
            System.out.println("If a 4, 5, 6, 8, 9, or 10 are rolled on this first roll, that number becomes the point.");
            System.out.println("3: Continue to roll the two dice again until one of two things happens: either you roll the point from that first roll again, in which case you win; or you roll a 7, in which case you lose.");
        }
        while (start.equalsIgnoreCase("Y"))
        {
            System.out.println("Press [Enter] to roll");
            Scanner scan2 = new Scanner(System.in);
            String waiting = scan2.nextLine();
            int result = dice.rollDice();
            if (result == 7 || result == 11)
            {
                System.out.println("You rolled a " + result);
                System.out.println("You win!");
            }
            else if (result == 2 || result == 3 || result == 12)
            {
                System.out.println("You rolled a " + result);
                System.out.println("You lost :(");
            }
            else
            {
                int count = 0;
                int point = result;
                while ((result != 7 && point != result) || count == 0)
                {
                    count ++;
                    System.out.println("You rolled a " + result);
                    System.out.println("Your point is " + point);
                    System.out.println("Press [Enter] to keep rolling!");
                    Scanner in4 = new Scanner(System.in);
                    String pause = in4.nextLine();
                    result = dice.rollDice();
                    if (result == point)
                    {
                        System.out.println("You rolled a " + result);
                        System.out.println("Congratulations, you win!");
                    }
                    else if (result == 7)
                    {
                        System.out.println("You rolled a " + result);
                        System.out.println("You lose");
                    }
                }
            }
            System.out.println("Would you like to play again (Y/N)");
            start = scan1.nextLine();
        }

    }
}
