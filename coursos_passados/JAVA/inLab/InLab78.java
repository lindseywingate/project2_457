import java.util.*;
import java.io.*;
/**
 * The InLec7 class is used to read in a file of users where each line contains information about one (1) user and is divided into three (3) segments for:<br>
 * username, password and group.  The segments are delimited with "!" characters.
 * <br><br>
 * @author Scott D. Kerlin
 * @version 2.0
 * @since 2/2/15
 */
public class InLec78
{
     
     /**
      * main calls the methods need to run the program, which is divided into 3 main parts:
      * <br>
      * --Reading from the data file <br>
      * --Processing the data based on user input <br>
      * --Saving data on exit (if needed)
      * <br><br>This program requires java.util.* and java.io.*
      * <br>  The data file is assumed to be named "usergroups.txt" and located in the directory where the program will run.
      * @param args is required for main methods, but not used by this program
      */ 
     public static void main(String[] args) throws FileNotFoundException
     {
          final String FILENAME = "usergroups.txt";  //Constant variable with filename stored in it.
          
          
          //read the data into arrayLists

	  ArrayList<String> usernames = new ArrayList<String>();
	  ArrayList<String> passwords = new ArrayList<String>();
	  ArrayList<Integer> usergroups = new ArrayList<Integer>();


          //read data into arrayLists
          File datafile = new File(FILENAME);
          Scanner inputfile = new Scanner(datafile);
          
          while (inputfile.hasNext())
          {
                String line = inputfile.nextLine();
                String[] data = line.split("!"); 
	        usernames.add(data[0]);
		passwords.add(data[1]);
		usergroups.add(Integer.parseInt(data[2]));
          }
          
          //Allow processing of data
          Scanner keyboard = new Scanner(System.in);
          final String mainMessage = "Enter the number of the option you wish to perform:\n\t1)Display all usernames\n\t2)Display the usernames in Usergroup #1\n\t3)Display the usernames in Usergroup #2\n\t4)Display the usernames in Usergroup #3\n\t5)Change Your password\n\t6)Move someone to a higher usergroup\n\t7)Move someone to a lower usergroup\n\t8)Exit\n\n";
          final String badInputMessage = "You did not select a valid option, please try again\n\n";
          final String notImplimentedMessage = "Sorry, this option is not yet implimented.\n\n";
          
          int input = 0;
          do
          {
               System.out.println(mainMessage);
               input = keyboard.nextInt();
               
               //Proccessing
               switch (input)
               {
                    case 1:
                         System.out.println(arrayData(usernames));
                         break;
                    case 2:
                         System.out.println(specificArrayData(usernames, passwords, 1));
                         break;
                    case 3:
                         System.out.println(specificArrayData(usernames, passwords, 2));
                         break;
                    case 4:
                         System.out.println(specificArrayData(usernames, passwords, 3));
                         break;
                    case 5:
                         keyboard.nextLine();  //Get rid of extra newline
                         System.out.println("Enter your username:");
                         String username = keyboard.nextLine();
                         System.out.println("Enter your password:");
                         String password = keyboard.nextLine();
                         if (validUser(usergroups, username, password))
                         {
                              System.out.println("You ARE who you say you are");
                         }
                         else
                         {
                              System.out.println("You ARE NOT who you say you are");
                         }
                         //System.out.println(notImplimentedMessage);
                         break;
                    case 6:
                         System.out.println(notImplimentedMessage);
                         break;
                    case 7:
                         System.out.println(notImplimentedMessage);
                         break;
                    case 8:
                         //Save code needs to go here, but we aren't doing that right now.
                         break;
                    default:
                         System.out.println(badInputMessage);
                         break;
               }
          }
          while (input != 8);
     }
     
     /**
      * getFileSize returns the size (in number lines) of file
      * @param filename is a String containing the name of the file to count the lines of
      * @return returns the number of lines in the file
      */ 
     public static int getFileSize(String filename) throws FileNotFoundException
     {
          File datafile = new File(filename);
          Scanner file = new Scanner(datafile);
          int lines = 0;
          
          //read file line-by-line, counting as we go
          while (file.hasNext())
          {
               //Just reading to go the file, so not keeping what I read
               file.nextLine();
               lines++;
          }
          
          file.close();
          return lines;  
     }

     /**
      * specificArrayData will return a String containing all of the Strings in an array of data, where the corresponding array contains values which match the input search value.
      * @param dataArray is the String[] to extract data from.
      * @param values is the int[] which has the values we want to check to determine what to extract
      * @param target is the value we want to match with the data from values
      * @return returns a String with a newline character between each String from the data array that we wanted to extract
      */ 
     public static String specificArrayData(ArrayList usernames, ArrayList passwords, int target)
     {
          String output = "";
          for (int x = 0; x < values.length; x++)
          {
               if (target == Integer.parseInt(values[x]))
               {
                    output += dataArray[x] + "\n";
               }
          }
          
          return output;
     }
     
     /**
      * arrayData will return a String containing all of the Strings in a given array, one String per line
      * @param array is the String[] to extract data from.
      * @return returns a String with a newline character between each String from the input array
      */ 
     public static String arrayData(ArrayList usernames)
     {
          String output = "";
          for (int x = 0; x < array.size(); x++)
          {
               output += array.get(x) + "\n";
          }
          
          return output;
     }

          /**
      * validUser will return a boolean indicating if a given username and password are in the input data
      * @param userdata is the 2D array of input data
      * @param username is the entered username
      * @param password is the entered password
      * @return returns a true if the input username and password are a valid pairing, returns false otherwise
      */ 
     public static boolean validUser(ArrayList usergroups, ArrayList username, ArrayList password)
     {
          for (int i = 0; i < usergroups[0].size; i++)
          {
               {
                    if (password.equals(password[i]))
                    {
                         return true;
                    }
                    else
                    {
                         return false;
                    }
               }
          }
          return false;
     }
}
