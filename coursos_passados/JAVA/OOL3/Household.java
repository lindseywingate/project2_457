/** Creates a household object with associated characteristics. Parent class. 
*@param ID (unique house number)
*@param name (unique house name) 
*@param children (number of children in home)
*@param time (time house has to care for pets)
*@param budget (budget house has to care for pets)
*@param Arraylist <Pet> pets (arraylist to hold pets in household)
*@param noise (noise limit for the household)
*@param happiness (happiness level in household)
*/
import java.util.*;

public class Household
{
     private static int ID = 0;
     protected Random rand = new Random();
     private String name;
     private int children = 0;
     private double time = 0.0;
     private double budget = 0.0;
     public ArrayList <Pet> pets = new ArrayList<Pet>();
     public final int REG_ID = ID;
     private double noise = 0.0;
     public double happiness = 0;
/* default constructor
*/
     public Household()
     {
          setName("");
          setTime(0);
          setBudget(0);
          ID++;
     }
/* constructor for predefined variables
*/   
     public Household(String n, double t, double b)
     {
          setName(n);
          setTime(t);
          setBudget(b);
          ID++;
     }
     
/* sets household name
*/
     public void setName(String input)
     {
          if (input.length() < 2)
               name = "Home " + ID;
          else
               name = input;
     }
/* sets time house has to care for pets
*/
     public void setTime(double input)
     {
          time = input;
          while (time <= 0.0 || time > 100.0)
               time = (rand.nextDouble() * 100);
     }
/*sets money house has to care for pets
*/
     public void setBudget(double input)
     {
          budget = input;
          while (budget <= 0.0 || budget > 1000.0)
               budget = (rand.nextDouble() * 1000);
     }
/* gets household name
*/          
     public String getName()
     {
          return name;
     }
/* gets time house has to care for pets
*/   
     public double getTime()
     {
          return time;
     }
/* gets budget house has to care for pets
*/   
     public double getBudget()
     {
          return budget;
     }
/* prints list of pets household has
*/   
     public String pets()
     {
          String output = "";
          for (int x = 0; x < pets.size(); x++)
               output += "\n" + pets.get(x);
          return output;
     }
/* prints household variables and list of pets in house
*/   
     public String toString()
     {
          return getName() + "\n\tTime Available:\t" + getTime() + "\n\tBudget Available:\t" + getBudget() + pets();
     }
/*compares this household to another
*/
     public boolean equals(Household otherHousehold)
     {
          if (REG_ID == otherHousehold.REG_ID)
               return true;
          return false;
     }
/* addPet allows a pet to be added to the pet arrayList. If the pet does not fulfill the requirements, it will not be added and an exception will be thrown.
*/
     public void addPet(Pet newPet) throws NoiseException, FedUpOwnerException, BudgetBrokenException, OwnerExhaustionException, DeadPetException
     {
          double newNoise = 0;
          //Check noise
          if (newPet instanceof Dog)
          {
               newNoise = ((Dog) newPet).getBark();
          }
          else if (newPet instanceof Bird)
          {
               newNoise = ((Bird) newPet).getTweet();
          }
          if (noise + newNoise > 20)
          {
               throw new NoiseException();
          }
               
          //Check Satisfaction
          if (happiness + newPet.getOwnerSatisfaction() < -20)
               throw new FedUpOwnerException();
          
          //Check Budget
          if (budget - newPet.getCostOfCare() < 0)
               throw new BudgetBrokenException();
          
          //Check Time
          if (time - newPet.getHoursOfCare() < 0)
               throw new OwnerExhaustionException();
          
          //Check for dead pets
          pets.add(newPet);
          if (!Pet.playsNice(pets))
          {
               pets.remove(newPet);
               throw new DeadPetException();
          }
               
          //Able to add
          noise += newNoise;
          happiness += newPet.getOwnerSatisfaction();
          budget -= newPet.getCostOfCare();
          time -= newPet.getHoursOfCare();
          
          
          
     }
     


}

