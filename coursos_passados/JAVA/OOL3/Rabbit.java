/** Rabbit creates an object with rabbit characteristics. Extends Pet
*@param panic (frequency of panic attacks)
*/
import java.util.*;

public class Rabbit extends Pet
{
     private double panic;
/* default constructor
*/
     public Rabbit()
     {
          setPanic(100);
     }
/* constructor for predefined variables
*/   
      public Rabbit(String n, double h, double c, double s, double r, double p)
     {
          super(n,h,c,s,r);
          setPanic(p);
     }
/*sets frequency of panic attacks
*/  
       public void setPanic(double input)
     {
          panic = input;
          while (panic < 0.0 || panic > 10.0)
               panic = (rand.nextDouble() * 10);
     }
/* retrieves panic attack frequency
*/
     public double getPanic()
     {
          return panic;
     }
/* easily readable version of object Rabbit
*/  
     public String toString()
     {
          return "The Rabbit: " + super.toString() + "\n\tPanic Attack Frequency:\t" + getPanic();
     }
     
}
