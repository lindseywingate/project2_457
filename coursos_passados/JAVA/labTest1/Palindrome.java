import java.util.*;

/**
 * The Palindrome class is used to check if a given number is a palindrome or not.
 * A Palindrome is a number that has the same value when written forwards as it does when written backwards.
 * <br><br>
 * @author Scott Kerlin
 * @version 1.0
 * @since 2/17/2015
 */
 
public class Palindrome 
{
 
     /**
      * main accepts user input for processing.
      * <br><br>
      * main prompts the user to enter a number to check or a -1 or zero to exit.
      * <br><br>This method requires java.util.Scanner
      * @param args is required for main methods, but not used by this method
      */  
      public static void main(String[] args) 
      {
           boolean keepGoing = true;
           Scanner keyboard = new Scanner(System.in);
	   System.out.println("Please enter a number. Press -1 or 0 to exit.");

           while (keepGoing = true)
           {
                int value = keyboard.nextInt();
                if (value < 0 )
                {
                     keepGoing = false;
                }
                else
                {
		     
                     String forwards = String.valueOf(value);
                     String backwards = "";
                     for (int x = forwards.length()-1; x>=0; x--)
                     {
                          backwards = backwards + forwards.charAt(x);
			  System.out.println(backwards);
                     }

                     if (backwards.equals(forwards))
                     {
                          System.out.println("Input is a PALINDROME");
                     }
                     else
                     {
                          System.out.println("Input IS NOT a palindrome");
                     }
		}
            }
      }   
}
 
