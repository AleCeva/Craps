public class Die
{
  //Declare Variables  
    private int roll;

  //Constructor 
    public Die()
    {
       
        roll = 1;
    }

    //Method
    public int rollDice()
    {
       //Creats two dice rolls and ads them to produce the craps total for that round
        int roll1 = (int) (Math.random() * 6) + 1;
        int roll2 = (int) (Math.random() * 6) + 1;
        int total = roll1 + roll2;
       
        return total;

    }
}