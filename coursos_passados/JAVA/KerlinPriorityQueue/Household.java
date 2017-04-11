/*Kerlin's code, not java doc'd since that's part of YOUR grade*/
import java.util.*;

public class Household implements Comparable
{
     private static int ID = 0;
     protected Random rand = new Random();
     private String name;
     private int children = 0;
     private double time = 0.0;
     private double budget = 0.0;
     private ArrayList <Pet> pets = new ArrayList<Pet>();
     public final int REG_ID = ID;
     private double noise = 0.0;
     private double happiness = 0;
     
     public int compareTo(Object other)
     {
          return ((Household) other).getName().compareTo(getName());
     }
     
     public Household()
     {
          setName("");
          setTime(0);
          setBudget(0);
          ID++;
     }
     
     public Household(String n, double t, double b)
     {
          setName(n);
          setTime(t);
          setBudget(b);
          ID++;
     }
     

     public void setName(String input)
     {
          if (input.length() < 2)
               name = "Home " + ID;
          else
               name = input;
     }
     
     public void setTime(double input)
     {
          time = input;
          while (time <= 0.0 || time > 100.0)
               time = (rand.nextDouble() * 100);
     }

     public void setBudget(double input)
     {
          budget = input;
          while (budget <= 0.0 || budget > 1000.0)
               budget = (rand.nextDouble() * 1000);
     }
     
       
     public String getName()
     {
          return name;
     }
     
     public double getTime()
     {
          return time;
     }
     
     public double getBudget()
     {
          return budget;
     }
     
     private String pets()
     {
          String output = "";
          for (int x = 0; x < pets.size(); x++)
               output += "\n" + pets.get(x);
          return output;
     }
     
     public String toString()
     {
          return getName() + "\n\tTime Available:\t" + getTime() + "\n\tBudget Available:\t" + getBudget() + pets();
     }
     
     public boolean equals(Household otherHousehold)
     {
          if (REG_ID == otherHousehold.REG_ID)
               return true;
          return false;
     }
     
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

