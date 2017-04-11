/** Pet is the parent class to all pets (Cat, Dog, Rabbit, Fish, Bird). It creates or allows the basic pet characteristics to be set.
*@param ID (unique pet ID)
*@param name (unique pet name)
*@param hours (hours required for pet care)
*@param cost (cost for pet)
*@param happy (happiness the pet brings to a household)
*@param reflex (reflex of pet)
*/
import java.util.*;

public class Pet
{
     private static int ID = 0;
     protected Random rand = new Random();
     private String name;
     private double hours = 0.0;
     private double cost = 0.0;
     private double happy;
     private double reflex;
     public final int REG_ID = ID;
/* default constructor
*/
     public Pet()
     {
          setName("");
          setHoursOfCare(0);
          setCostOfCare(0);
          setOwnerSatisfaction(100);
          setReflex(100);
          ID++;
     }
/* constructor to use for predefined variables
*/
     public Pet(String n, double h, double c, double s, double r)
     {
          setName(n);
          setHoursOfCare(h);
          setCostOfCare(c);
          setOwnerSatisfaction(s);
          setReflex(r);
          ID++;
     }
/*sets name of pet
*/
     public void setName(String input)
     {
          if (input.length() < 2)
               name = "Pet " + ID;
          else
               name = input;
     }
/* sets hours of care required for the pet
*/   
     public void setHoursOfCare(double input)
     {
          hours = input;
          while (hours <= 0.0 || hours > 5.0)
               hours = (rand.nextDouble() * 10) / 2;
     }
/* sets cost of care for pet
*/
     public void setCostOfCare(double input)
     {
          cost = input;
          while (cost <= 0.0 || cost > 10.0)
               cost = (rand.nextDouble() * 10);
     }
/* sets owner satisfaction rating (happy) for pet
*/  
     public void setOwnerSatisfaction(double input)
     {
          happy = input;
          while (happy < -10.0 || happy > 10.0)
               happy = (rand.nextDouble() * 20) - 10;     
     }
/* sets reflex of pet
*/
     public void setReflex(double input)
     {
          reflex = input;
          while (reflex < -5.0 || reflex > 10.0)
               reflex = (rand.nextDouble() * 15) - 5;     
     }
/*gets pet name
*/   
     public String getName()
     {
          return name;
     }
/* retrieves hours of care required for the pet
*/   
     public double getHoursOfCare()
     {
          return hours;
     }
/* retrieves cost of care for pet
*/   
     public double getCostOfCare()
     {
          return cost;
     }
/* retrieves owner satisfaction rating with pte
*/ 
     public double getOwnerSatisfaction()
     {
          return happy;
     }
/* retrieves reflex of pet
*/   
     public double getReflex()
     {
          return reflex;
     }
/* easily readable version of pet and all characteristics set above
*/   
     public String toString()
     {
          return getName() + "\n\tCare in Hours:\t" + getHoursOfCare() + "\n\tCost of Care:\t" + getCostOfCare() + "\n\tOwner Satisfaction:\t" + getOwnerSatisfaction() + "\n\tReflexes:\t" + getReflex();
     }
/* compares of pet is the same to another
*/   
     public boolean equals(Pet otherPet)
     {
          if (REG_ID == otherPet.REG_ID)
               return true;
          return false;
     }
/*indicates of the pet will or will not kill another pet (based on different pet qualifications)
*/
     public static boolean playsNice(ArrayList <Pet> pets)
     {
          if (pets.size() <= 1)
               return true;

          double noise = 0;
          double lowPanic = Double.MAX_VALUE;
          for (int x = 0; x < pets.size(); x++)
          {
               if (pets.get(x) instanceof Dog)
                    noise = ((Dog) pets.get(x)).getBark();
               else if (pets.get(x) instanceof Bird)
                    noise = ((Bird) pets.get(x)).getTweet();
               else if (pets.get(x) instanceof Rabbit && ((Rabbit) pets.get(x)).getPanic() < lowPanic)
                    lowPanic = ((Rabbit) pets.get(x)).getPanic();
               
               for (int y = x + 1; y < pets.size(); y++)
               {
                    if (pets.get(x) instanceof Cat)
                    {
                         int bonus = 0;
                         if ( !((Cat) pets.get(x)).getDeclawed())
                              bonus = 5;

                         if (pets.get(y) instanceof Bird)
                         {
                              if ( ((Cat) pets.get(x)).getEatBirds() && !((Bird) pets.get(y)).getFlight() &&  pets.get(x).getReflex() + bonus > pets.get(y).getReflex())
                                   return false;
                         }
                         else if (pets.get(y) instanceof Rabbit)
                         {
                              if ( ((Cat) pets.get(x)).getEatRabbits() && pets.get(x).getReflex() + bonus > pets.get(y).getReflex() - ((Rabbit) pets.get(y)).getPanic())
                                   return false;
                         }
                         else if (pets.get(y) instanceof Fish)
                         {
                              if ( ((Cat) pets.get(x)).getEatFish() && pets.get(x).getReflex() + bonus > pets.get(y).getReflex())
                                   return false;
                         }
                         else if (pets.get(y) instanceof Dog)
                         {
                              if ( ( !((Cat) pets.get(x)).getToleratesDogs() && pets.get(x).getReflex() + bonus > pets.get(y).getReflex()) || ( !((Dog) pets.get(y)).getToleratesCats() && pets.get(x).getReflex() + bonus < pets.get(y).getReflex()))
                                   return false;
                         }
                    }
                    else if (pets.get(x) instanceof Bird)
                    {
                         int bonus = 0;
                         if ( ((Bird) pets.get(x)).getFlight())
                              bonus = 2;
                         
                         if (pets.get(y) instanceof Rabbit)
                         {
                              if ( ((Bird) pets.get(x)).getEatRabbits() && pets.get(x).getReflex() + bonus > pets.get(y).getReflex() - ((Rabbit) pets.get(y)).getPanic())
                                   return false;
                         }
                         else if (pets.get(y) instanceof Fish)
                         {
                              if ( ((Bird) pets.get(x)).getEatFish() && pets.get(x).getReflex() + bonus > pets.get(y).getReflex())
                              return false;
                         }
                         else if (pets.get(y) instanceof Cat)
                         {
                              if ( !((Cat) pets.get(y)).getDeclawed())
                                   bonus = 5;
                              if ( ((Cat) pets.get(y)).getEatBirds() && !((Bird) pets.get(x)).getFlight() &&  pets.get(y).getReflex() + bonus > pets.get(x).getReflex())
                                   return false;
                         }
                    }
                    else if (pets.get(x) instanceof Dog)
                    {
                         if (pets.get(y) instanceof Rabbit)
                         {
                              if ( ((Dog) pets.get(x)).getEatRabbits() && pets.get(x).getReflex() > pets.get(y).getReflex() - ((Rabbit) pets.get(y)).getPanic())
                              return false;
                         }
                         else if (pets.get(y) instanceof Cat)
                         {
                              int bonus = 0;
                              if ( !((Cat) pets.get(y)).getDeclawed())
                                   bonus = 5;
                              if ( ( !((Cat) pets.get(y)).getToleratesDogs() && pets.get(y).getReflex() + bonus > pets.get(x).getReflex()) || ( !((Dog) pets.get(x)).getToleratesCats() && pets.get(y).getReflex() + bonus < pets.get(x).getReflex()))
                                   return false;
                         }
                    }
                    else if (pets.get(x) instanceof Fish)
                    {
                         if (pets.get(y) instanceof Bird)
                         {              
                              int bonus = 0;
                              if ( ((Bird) pets.get(y)).getFlight())
                                   bonus = 2;
                              if ( ((Bird) pets.get(y)).getEatFish() && pets.get(y).getReflex() + bonus > pets.get(x).getReflex())
                              return false;
                         } 
                         else if (pets.get(y) instanceof Cat)
                         {
                              int bonus = 0;
                              if ( !((Cat) pets.get(y)).getDeclawed())
                                   bonus = 5;
                              if ( ((Cat) pets.get(y)).getEatFish() && pets.get(y).getReflex() + bonus > pets.get(x).getReflex())
                                   return false;
                         }
                    }
                    else if (pets.get(x) instanceof Rabbit)
                    {
                         if (pets.get(y) instanceof Cat)
                         {
                              int bonus = 0;
                              if ( !((Cat) pets.get(y)).getDeclawed())
                                   bonus = 5;
                              if ( ((Cat) pets.get(y)).getEatRabbits() && pets.get(y).getReflex() + bonus > pets.get(x).getReflex() - ((Rabbit) pets.get(x)).getPanic())
                                   return false;
                         }
                         else if (pets.get(y) instanceof Bird)
                         {        
                              int bonus = 0;
                              if ( ((Bird) pets.get(y)).getFlight())
                                   bonus = 2;
                              if ( ((Bird) pets.get(y)).getEatRabbits() && pets.get(y).getReflex() + bonus > pets.get(x).getReflex() - ((Rabbit) pets.get(x)).getPanic())
                                   return false;
                         }
                         else if (pets.get(y) instanceof Dog)
                         {
                              if ( ((Dog) pets.get(y)).getEatRabbits() && pets.get(y).getReflex() > pets.get(x).getReflex() - ((Rabbit) pets.get(x)).getPanic())
                              return false;
                         }
                    }



               }
          }
          if (noise > 0 && noise >=lowPanic )
               return false;
          return true;
     }

}

