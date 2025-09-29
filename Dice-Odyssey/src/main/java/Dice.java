import java.util.Random;

/**
 * Makes a Dice (with 6 sides)
 * */

public class Dice
{
    private int sides;
    private Random raNum = new Random();;

    public Dice()
    {
        this.sides = 6;                             // sides one a normal dice
    }

    /**
     * Sets the sides of the dice
     * @param sides is the sides of the dice
     */
    public void setDiceSides(int sides)
    {
        this.sides = sides;
    }

    /*
    /**
     * Throws the dice
     * @param numThrows how many throws of the dice
     * @param name Who throws the dice
     * @return the total sum of dice thrown

    public int throwDice(int numThrows, String name) //d6.throwDice(2)
    {
        int counter = 1;
        int toss;                                                           //toss is the number the dice lands on
        int sum = 0;                                                        //sum is the total value of dice thrown
        do
        {
            toss = raNum.nextInt(sides) + 1;
            System.out.printf("%s's Dice lands on %d \n",name ,toss);

            sum += toss;
            counter++;
        }while(counter <= numThrows);

        return sum;
    }
    */

    /**
     * Throws a dice
     * @return a random number of the dice
     */
    public int throwDice()
    {
        return raNum.nextInt(sides) + 1;
    }



}
