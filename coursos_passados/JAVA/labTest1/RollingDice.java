import java.util.*;

/**
 * The RollingDice class takes in 2 numbers from the terminal.
 * The first number indicates the number of sides each die will have.
 * The second number indicates the number of dices to use.
 * The values of each die will be generated and displayed to the terminal along with the lowest, highest and average.
 * If either input is a negative, the program will terminate
 * <br><br>
 * @author Scott Kerlin
 * @version 1.0
 * @since 2/17/2015
 */
 
public class RollingDice {
 
     /**
      * main accepts user input for processing.
      * <br><br>
      * main prompts the user, rolls dice and displays info to user
      * <br><br>This method requires java.util.Scanner
      * <br><br>This method requires java.util.Random
      * @param args is required for main methods, but not used by this method
      */  
      public static void main(String[] args) {
		int []data = getUserInput();
		int []rolls = rollDice(data[0], data[1]);

		String display = displayDice(rolls);
		System.out.println("The rolls for the dice were: "+ display);

		int largest = maxValue(rolls);
		System.out.println("The largest roll was: " +largest);

		int smallest = minValue(rolls);
		System.out.println("The smallest rolls was: "+smallest);

		double average = averageValue(rolls);
		System.out.println("The average roll was: "+average);
		
     }
      
      /**
      * getUserInput asks terminal for 2 values and returns those 2 values in an int array.
      * <br><br>
      * @return an array containing the 2 ints that were read in from terminal
      */  
      public static int[] getUserInput()
      {
           int[] data = new int[2];
           Scanner keyboard = new Scanner(System.in);
           System.out.println("Number sides for each die:");
           data[0] = keyboard.nextInt();
           System.out.println("Number of dice to roll:");
           data[1] = keyboard.nextInt();
           return data;
      }
      
      /**
      * rollDice rolls dice
      * <br><br>
      * @param sides is the number of sides for each die
      * @param amount is the amount of dice to roll
      * @return an array containing the resulting values of the rolled dice
      */  
      public static int[] rollDice(int sides, int amount)
      {
           Random rand = new Random();
           int[] rolls = new int[amount];
           for (int x = 0; x < amount; x++)
           {
                rolls[x] = rand.nextInt(sides) + 1;
           }
           return rolls;
      }

      /**
      * displayDice shows the output of the dice rolling
      * <br><br>
      * @param rollOutput is an int array of a set of the roll values
      * @return a String with the roll value information
      */  
      public static String displayDice(int[] rollOutput)
      {
           String output = "";
           for (int x = 0; x < rollOutput.length; x++)
           {
                output = rollOutput[x] + " " + output;
           }
           return output;
      }

      /**
      * maxValue finds the biggest roll value
      * <br><br>
      * @param rollOutput is an int array of a set of the roll values
      * @return an int with the largest roll value
      */  
      public static int maxValue(int[] rollOutput)
      {
           int max = 0;
           for (int x = 0; x < rollOutput.length; x++)
           {
                if (max < rollOutput[x])
                     max = rollOutput[x];
           }
           return max;
      }


      /**
      * minValue finds the smallest roll value
      * <br><br>
      * @param rollOutput is an int array of a set of the roll values
      * @return an int with the smallest roll value
      */  
      public static int minValue(int[] rollOutput)
      {
           int min = Integer.MAX_VALUE;
           for (int x = 0; x < rollOutput.length; x++)
           {
                if (min > rollOutput[x])
                     min = rollOutput[x];
           }
           return min;
      }
      
      /**
      * averageValue shows the average of all dice rolled
      * <br><br>
      * @param rollOutput is an int array of a set of the roll values
      * @return a double with the average of all of the dice rolled
      */  
      public static double averageValue(int[] rollOutput)
      {
           double average = 0;
           for (int x = 0; x < rollOutput.length; x++)
           {
                average += rollOutput[x];
           }
           average = average / rollOutput.length;
           return average;
      }      
}
 
