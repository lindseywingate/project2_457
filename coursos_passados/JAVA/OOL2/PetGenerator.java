import java.util.*;//can use * to import all, not just Scanner
import java.io.*;
import java.text.*;
/*
* The PetGenerator class is used to create a file where each line contains information about one pet and is divided into five segments for:<br>
* type, name, hours of care, cost of care, and owner satisfaction rating. The segments are delimited with "!" characters.
* <br><br>
*@author Lindsey M. Wingate
*@version 2.0
*@since 2/9/2015
*/

public class PetGenerator
{
/* main contains the code required to necessary data for each pet, which is devided into 3 main parts:
*<br>
*--Reading from the data file<br>
*--Processing the data based on user input<br>
*--<br><br> This program requires java.util.* and java.io.*
*--<br> The data file is named "Pets.txt" and located in the directory where the program will run.
*@param args is required for main methods, but not used by this program.
*/

  public static void main(String[] args)throws java.io.IOException
  {
    //format double numbers
    DecimalFormat formatter = new DecimalFormat("#0.00");
    double d = 4.0;
    
    //create new file for data to be recorded
    FileWriter fwriter = new FileWriter("Pets.txt", true); 
    PrintWriter outputFile = new PrintWriter(fwriter);
    
    //Get the number of pets to create
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter the number of pets to create");
    int numPets;
    numPets = keyboard.nextInt();
    
    //verify user input
  if (numPets < 0)
    {System.out.println("Please enter a valid number of pets(greater than 0)");
     System.out.println("Enter the number of pets to create:"); 
     numPets = keyboard.nextInt();}
  if (numPets > 0)
    {System.out.println("You have entered " + numPets + " pets.");}
    
  //initiate string animal type
  String cat = "Cat";
  String dog = "Dog";
  String bird = "Bird";
  String fish = "Fish";
  String rabbit = "Rabbit";
  
  //generate data for number of pets input
  String petType = " ";
  int counter = 0;
  while(counter<numPets)
   {
   Random rand = new Random();
   int randomNum = 0;
   randomNum = rand.nextInt(5)+1;
   
   switch(randomNum)
  {   
     case 1:
     petType = cat;
     break;
     case 2:
     petType = dog;
     break;
     case 3:
     petType = bird;
     break;
     case 4:
     petType = fish;
     break;
     case 5:
     petType = rabbit;
     break;
  }
    
    //randomly selected name of pet, string
      int size = 0;
      String petName = "";
      size = rand.nextInt(5)+4;
      
      for (int letters = 0; letters < size; letters++)
      {int value = rand.nextInt(25) + 97;
      //Step 2: Use the integer value to create the matching unicode character
      char letter = Character.toChars(value)[0];
      //Step 3: Add new letter to end of name
      petName = petName + letter;
      }
           
      //create hours of care required for pet, double, not more than 5.0
      Random rand2 = new Random();
      double hoursOfCare = 0;
      double rangeMin = 0.0;
      double rangeMax = 5.0;
      hoursOfCare = rangeMin + (rangeMax - rangeMin)*rand2.nextDouble();
    
      //create cost of care for pet, double, not more than 10.0
      Random rand3 = new Random();
      double careForPet = 0;
      double rangeMin2 = 0.0;
      double rangeMax2 = 5.0;
      careForPet = rangeMin2 + (rangeMax2 - rangeMin2)*rand3.nextDouble();
      
      //create owner satisfaction rating, int, -10 to 10
      Random rand4 = new Random();
      int satRating = 0;
      satRating = rand.nextInt(20)-10;
            
      //write data to file! :) 
    outputFile.printf(petType+"!"+petName+"!%.2f!%.2f!"+satRating+"%n",hoursOfCare,careForPet);
    counter = counter + 1;

  }
      outputFile.close();
  }
}
