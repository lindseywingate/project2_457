/** Dog creates an object with characteristics of a dog. Extends pet
* @param cats (eats cats?)
* @param rabbits (eats rabbits?)
* @param freq (frequency of barking)
*/
import java.util.*;

public class Dog extends Pet
{
     private boolean cats;
     private boolean rabbits;
     private double freq;
/* default constructor
*/
     public Dog()
     {
          setToleratesCats(rand.nextBoolean());
          setEatRabbits(rand.nextBoolean());
          setBark(100);
     }
/* constructor with specified characteristics
*/     
     public Dog(String n, double h, double c, double s, double r, boolean t, boolean ra, double b)
     {
          super(n,h,c,s,r);
          setToleratesCats(t);
          setEatRabbits(ra);
          setBark(b);
     }
/* sets whether dog tolerates cats
*/
     public void setToleratesCats(boolean input)
     {
          cats = input;
     }
/* sets whether dog eats rabbits
*/   
     public void setEatRabbits(boolean input)
     {
          rabbits = input;
     }
/* sets how often dog barks
*/
     public void setBark(double input)
     {
          freq = input;
          while (freq < 0.0 || freq > 5.0)
               freq = (rand.nextDouble() * 10) / 2;
     }
/* gets if dog barks or not
*/   
     public double getBark()
     {
          return freq;
     }
/* gets if dog tolerates cats or not
*/
     public boolean getToleratesCats()
     {
          return cats;
     }
/* gets if dog eats rabbits
*/   
     public boolean getEatRabbits()
     {
          return rabbits;
     }
/*prints easily readable version of dog and all characteristics
*/   
    
     public String toString()
     {
          return "The Dog: " + super.toString() + "\n\tBarking Frequency:\t" + getBark() + "\n\tTolerates Cats:\t" + getToleratesCats() + "\n\tCan Eat Rabbits:\t" + getEatRabbits();
     }
     
}
