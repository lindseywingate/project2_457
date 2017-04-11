/** Fish creates a fish object with associated characteristics. Extends pet
*@param poison (is fish poisonous?)
*/
import java.util.*;

public class Fish extends Pet
{
     private boolean poison;
/* default constructor
*/  
     public Fish()
     {
          setPoisonous(rand.nextBoolean());
     }
/* constructor to use with predefined variables
*/  
     public Fish(String n, double h, double c, double s, double r, boolean p)
     {
          super(n,h,c,s,r);
          setPoisonous(p);
     }
/* sets if fish is poisonous or not
*/
     public void setPoisonous(boolean input)
     {
          poison = input;
     }
/* gets if fish is poisonous
*/
     public boolean getPoisonous()
     {
          return poison;
     }
/* easily printable format of fish and associated characteristics
*/ 
     public String toString()
     {
          return "The Fish: " + super.toString() + "\n\tIs Poisonous:\t" + getPoisonous();
     }
     
}
