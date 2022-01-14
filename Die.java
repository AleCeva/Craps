public class Die
{
    
    private int roll;

   
    public Die()
    {
       
        roll = 1;
    }


    public int rollDice()
    {
       
        int roll1 = (int) (Math.random() * 6) + 1;
        int roll2 = (int) (Math.random() * 6) + 1;
        int total = roll1 + roll2;
        return total;
    }
}