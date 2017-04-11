import java.util.*;
import java.io.*;
import java.text.*;
/*
 * The PetFinder class is used to read in the input of the user to determine what method should be called upon to return the specific information the user requested.
 * pet type, pet name, hours of care, cost of care, and satifaction rating.  The segments are delimited with "!" characters.
 * <br><br>
 * @author Lindsey M. Wingate
 * @version 2.0
 * @since 2/9/2015
 */

public class PetFinder
{
/*
* main calls the methods needed to run the program depending upon the user input. It is divided into two parts:
*<br>
*--Getting user input<br>
*--Calling upon the necessary method<br>
*--<br><br>This program requires java.util.* and java.io.* and java.text.*
*<br> the data file is assumed to be named "Pets.txt" and locatd in the directory where the program will run
*@param args is required for main methods, but not used by this program
*/

  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner keyboard = new Scanner(System.in);
    int userInput;
    System.out.println("Please pick a number between 1-5. Press 6 to exit.");
    userInput = keyboard.nextInt();
    
    while (userInput!=6)
    {
    if (userInput<1 || userInput>6)
    {
     System.out.println("Please pick a valid number between 1-5. Press 6 to exit.");
     userInput = keyboard.nextInt();
    }
    if (userInput == 1)
    {
    fishNames();
    System.out.println("");
    System.out.println("Please pick a number between 1-5. Press 6 to exit.");
    userInput = keyboard.nextInt();
    }
    if (userInput == 2)
    {
    averageCatCare();
    System.out.println("");
    System.out.println("Please pick a number between 1-5. Press 6 to exit.");
    userInput = keyboard.nextInt();
    }
    if (userInput == 3)
    {
    averageBirdCost();
    System.out.println("");
    System.out.println("Please pick a number between 1-5. Press 6 to exit.");
    userInput = keyboard.nextInt();
    }
    if (userInput == 4)
    {
    satisfaction();
    System.out.println("");
    System.out.println("Please pick a number between 1-5. Press 6 to exit.");
    userInput = keyboard.nextInt();
    }
    if (userInput == 5)
    {
    numberOfPets();
    System.out.println("");
    System.out.println("Please pick a number between 1-5. Press 6 to exit.");
    userInput = keyboard.nextInt();
    }
    }
  }

  /*
*fishNames prints all the names of the fish in the file
*/

  public static void fishNames() throws FileNotFoundException
  {
    //prepare to read data
    File file = new File("Pets.txt");
    Scanner inputFile = new Scanner(file);
    
    System.out.println("The fish names are: ");
    
    //read data from file
    while (inputFile.hasNext())
    {
    String line = " ";
    line = inputFile.nextLine();
    
    //split data by seperator (!) and assign to data
    String[] data = line.split("!");//split line at spaces and create an array
    
    //print names of fish
    if(data[0].equals("Fish"))
      {
      System.out.println(data[1]);
      }
    }
  inputFile.close();
  }

  /*
*averageCatCare reads each line in the file, extracts the care number for each "cat" type, adds them together, and then divides them by the number of cats. It prints the average care care cost
*/

  public static void averageCatCare()throws FileNotFoundException
  {//prepare to read data
    File file = new File("Pets.txt");
    Scanner inputFile = new Scanner(file);
    
    //setup formatting for final average
    DecimalFormat formatter = new DecimalFormat("#0.00");
    double d = 4.0;
    
    //define variables needed in if loop
    double totalCare = 0;
    int counter = 1;
    double averageCare=0.0;
    
    //read data from file
    while (inputFile.hasNext())
    {
    String line = " ";
    line = inputFile.nextLine();
    
    //split data by seperator (!) and assign to data
    String[] data = line.split("!");//split line at spaces and create an array
        
    //calculates average cat care costs
    if(data[0].equals("Cat"))
    {    
    double indiCare = Double.parseDouble(data[2]);
    
    totalCare = totalCare + indiCare;
    averageCare = totalCare/counter;
    counter = counter + 1;
    }
    }
  inputFile.close(); 
  System.out.printf("The average cat care time is %.2f%n hours.",averageCare); 
}

/*
*averageBirdCost reads each line in the file, extracts the cost for each "bird" type, adds them together, and then divides them by the number of birds. It prints the average bird cost.
*/ 

  public static void averageBirdCost()throws FileNotFoundException
  {
     File file = new File("Pets.txt");
    Scanner inputFile = new Scanner(file);
    
    //setup formatting for final average
    DecimalFormat formatter = new DecimalFormat("#0.00");
    double d = 4.0;
    
    //define variables needed in if loop
    double totalCost = 0;
    int counter = 1;
    double averageCost = 0.0;
    
    //read data from file
    while (inputFile.hasNext())
    {
    String line = " ";
    line = inputFile.nextLine();
    
    //split data by seperator (!) and assign to data
    String[] data = line.split("!");//split line at spaces and create an array
        
    //calculates average cat care costs
    if(data[0].equals("Bird"))
    {    
    double indiCost = Double.parseDouble(data[3]);
    
    totalCost = totalCost + indiCost;
    averageCost = totalCost/counter;
    counter = counter + 1;
    }
    }
  inputFile.close();  
  System.out.printf("The average cost of bird care is %.2f%n dollars.",averageCost);
  }

/*
satisfaction reads through the lines to extract the highest and lowest satisfaction number. It returns the highest satisfaction number and the pet name along with the lowest satisfaction number and the pet name.
*/

  public static void satisfaction() throws FileNotFoundException
  { 
    File file = new File("Pets.txt");
    Scanner inputFile = new Scanner(file);
    
    //setup formatting for final average
    DecimalFormat formatter = new DecimalFormat("#0.00");
    double d = 4.0;
    
    //define variables needed in if loop
   int counter = 1;
   double petSat = 0;
   double greatestSat = -11.0;
   double lowestSat = 11.0;
   String bestPet = "";
   String worstPet = "";
   
   //read data from file
    while (inputFile.hasNext())
    {
      String line = " ";
      line = inputFile.nextLine();
    
      //split data by seperator (!) and assign to data
      String[] data = line.split("!");//split line at spaces and create an array
        
      //calculates average cat care costs
      petSat = Double.parseDouble(data[4]);
      if (petSat>=greatestSat)
      {
        greatestSat = petSat;
        bestPet = data[1];
      }
      if (petSat<=lowestSat)
      {
        lowestSat = petSat;
        worstPet = data[1];
      } 
    } 
    inputFile.close();
    System.out.printf("The pet to bring the greatest satisfaction is "+bestPet+" with a score of %.2f."+ " The pet to bring the least satisfaction is "+ worstPet+" with a score of %.2f",greatestSat,lowestSat);
  } 

/*
numberOfPets iterates through the loop and counts (with an individual counter for each pet) how many of each type of pet there are. It prints the total amount of each type at the end of the file iterations.
*/

  public static void numberOfPets() throws FileNotFoundException
  {//prepare to read data
    File file = new File("Pets.txt");
    Scanner inputFile = new Scanner(file);
    
    //define variables needed in if loop
    int cat = 0;
    int dog = 0;
    int rabbit = 0;
    int fish = 0;
    int bird = 0;
    
    //read data from file
    while (inputFile.hasNext())
    {
    String line = " ";
    line = inputFile.nextLine();
    
    //split data by seperator (!) and assign to data
    String[] data = line.split("!");//split line at spaces and create an array
    if(data[0].equals("Cat"))
    {
      cat = cat +1;
    }
    if (data[0].equals("Dog"))
    {
      dog = dog + 1;
    }
    if (data[0].equals("Fish"))
    {
      fish = fish + 1;
    }
    if (data[0].equals("Rabbit"))
    {
      rabbit = rabbit + 1;
    }
    if (data[0].equals("Bird"))
    {
      bird = bird + 1;
    }
    }   
  inputFile.close();
  System.out.println("There are "+cat+" cat(s), "+dog+" dog(s), "+fish+" fish, "+rabbit+" rabbits, and "+bird+" bird(s)."); 
  }
  
}
