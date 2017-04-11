/** creates object with characteristics of a cat. Extends Pet
* @param declawed
* @param dogs
* @param birds
* @param rabbits
* @param fish
*/
import java.util.*;

public class Cat extends Pet
{
     private boolean declawed;
     private boolean dogs;
     private boolean birds;
     private boolean rabbits;
     private boolean fish;

/* default constructor
*/
     public Cat()
     {
          setDeclawed(rand.nextBoolean());
          setToleratesDogs(rand.nextBoolean());
          setEatBirds(rand.nextBoolean());
          setEatRabbits(rand.nextBoolean());
          setEatFish(rand.nextBoolean());
     }

/* constructor passing in specified variables
*/
     public Cat(String n, double h, double c, double s, double r, boolean d, boolean dog, boolean b, boolean ra, boolean fi)
     {
          super(n,h,c,s,r);
          setDeclawed(d);
          setToleratesDogs(dog);
          setEatBirds(b);
          setEatRabbits(ra);
          setEatFish(fi);
     }
/* sets if cat is declawed
*/
     public void setDeclawed(boolean input)
     {
          declawed = input;
     }
/* sets if cat tolerates dogs
*/
     public void setToleratesDogs(boolean input)
     {
          dogs = input;
     }
/* sets if cat eats birds
*/   
     public void setEatBirds(boolean input)
     {
          birds = input;
     }
/* sets if cat eats rabbits
*/  
     public void setEatRabbits(boolean input)
     {
          rabbits = input;
     }
/* sets if cat eats fish
*/
     public void setEatFish(boolean input)
     {
          fish = input;
     }
/* gets if cat is declawed variables
*/
     public boolean getDeclawed()
     {
          return declawed;
     }
/* gets if cat tolerates dogs variable
*/
     public boolean getToleratesDogs()
     {
          return dogs;
     }
/* gets if cat eats birds variable
*/   
     public boolean getEatBirds()
     {
          return birds;
     }
/* gets if cat eats rabbits variable
*/   
     public boolean getEatRabbits()
     {
          return rabbits;
     }
/* gets if cat eats fish variable
*/   
     public boolean getEatFish()
     {
          return fish;
     }
/* easily printable version of object with all characteristics
*/
     public String toString()
     {
          return "The Cat: " + super.toString() + "\n\tIs Declawed:\t" + getDeclawed() + "\n\tTolerates Dogs:\t" + getToleratesDogs() + "\n\tCan Eat Birds:\t" + getEatBirds() + "\n\tCan Eat Rabbits:\t" + getEatRabbits() + "\n\tCan Eat Fish:\t" + getEatFish();
     }
     
}
