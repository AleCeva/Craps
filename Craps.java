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
        //Basic introcutions to the game
        System.out.println("Welcome to the Craps game!");
        System.out.println("Would you like to play? (Y/N)");
       
        //Creats new dice for craps game
        Die dice = new Die();
       
       //Creates a scanner that takes imput from user
        Scanner scan1 = new Scanner(System.in);
        String gamestart = scan1.nextLine();
        
        //Checks input to see if instructions are needed to play the game
        System.out.println("Do you need the instructions for craps? (Y/N)");
        String instructions = scan1.nextLine();
        
        //If the user inputs a "Y" for rules, basic intructions are given
        if (instructions.equalsIgnoreCase("Y"))
        {
            System.out.println("1: Roll two six-sided dice and add the numbers rolled together.");
            System.out.println("2: On the first roll, a 7 or an 11 automatically wins, and a 2, 3, or 12 automatically loses, and the game is over.");
            System.out.println("If a 4, 5, 6, 8, 9, or 10 are rolled on this first roll, that number becomes the point.");
            System.out.println("3: Continue to roll the two dice again until one of two things happens: either you roll the point from that first roll again, in which case you win; or you roll a 7, in which case you lose.");
        }
        
        
        //If the user inputs a "Y" for gamestart, a new game begins
        while (gamestart.equalsIgnoreCase("Y"))
        {
            //Scanner takes imput from [Enter] key before rolling the dice
            System.out.println("Press [Enter] to roll");
            Scanner scan2 = new Scanner(System.in);
            String placehold1 = scan2.nextLine(); 

            //Rolls the first dice
            int result = dice.rollDice();
           
            if (result == 7 || result == 11) //If 7 or 11 are rolled user immediately wins
            {
                System.out.println("You rolled a " + result);
                System.out.println("YOU WIN!");
            }
            else if (result == 2 || result == 3 || result == 12) //If 2, 3, or 12 are rolled user immediately loses
            {
                System.out.println("You rolled a " + result);
                System.out.println("You lost :(");
            }
            
            else //Other instances in which game must continue
            {
                int count = 0; //starts a counter
                int point = result; //saves the result as your point value
                while ((result != 7 && point != result) || count == 0) //If the result is not a 7(instant win) and result does not equal point value(instant win)
                {
                    count ++; //ads to counter
                    
                    
                    System.out.println("You rolled a " + result);
                    System.out.println("Your point is " + point);
                    
                    //Input for a second dice roll
                    System.out.println("Press [Enter] to keep rolling!");
                    Scanner scan3 = new Scanner(System.in);
                    String placehold = scan3.nextLine();
                    result = dice.rollDice(); //changes the result to new roll 
                    
                    
                    if (result == point) //If result equals point it is an instant win
                    {
                        System.out.println("You rolled a " + result);
                        System.out.println("Congratulations, you win!");
                    }
                    else if (result == 7) //If results equals a 7 it is an instant win
                    {
                        System.out.println("You rolled a " + result);
                        System.out.println("You lose");
                    }
                    
                }
               
            }
            //If user inputs a "Y" a new round will be started
            System.out.println("Would you like to play again (Y/N)");
            gamestart = scan1.nextLine();

            
           
        }
        
        
        

    }
    
}
