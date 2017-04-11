import java.util.*;
import java.io.*;
/**
 * The InLec7 class is used to read in a file of users where each line contains information about one (1) user and is divided into three (3) segments for:<br>
 * username, password and group.  The segments are delimited with "!" characters.
 * <br><br>
 * @author Scott D. Kerlin
 * @version 1.0
 * @since 2/2/15
 */
public class InLec7
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
          
          //Step one, determine the size of the data file
          final int LINES_IN_FILE = getFileSize(FILENAME);
	  final int DATA_ELEMENTS = 3;          

          //Step two, read the data into parallel arrays
          //create parallel arrays
	  String[][] userdata = new String[DATA_ELEMENTS][LINES_IN_FILE];
          //String[] usernames = new String[LINES_IN_FILE];
          //String[] passwords = new String[LINES_IN_FILE];
          //int[] usergroups = new int[LINES_IN_FILE];
          
          //read data into parallel arrays
          File datafile = new File(FILENAME);
          Scanner inputfile = new Scanner(datafile);
          int pos = 0;  //Position in arrays
          
          while (inputfile.hasNext())
          {
               String line = inputfile.nextLine();
               String[] data = line.split("!"); //0: Username, 1: Password, 2: Usergroup
               userdata[0][pos] = data[0];
               userdata[1][pos] = data[1];
               userdata[2][pos] = data[2];
               pos++;
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
                         System.out.println(arrayData(userdata[0]));
                         break;
                    case 2:
                         System.out.println(specificArrayData(userdata[0], userdata[1], 1));
                         break;
                    case 3:
                         System.out.println(specificArrayData(userdata[0], userdata[1], 2));
                         break;
                    case 4:
                         System.out.println(specificArrayData(userdata[0], userdata[1], 3));
                         break;
                    case 5:
			 keyboard.nextLine(); //gets rid of extra newline
			 System.out.println("Enter your Username: ");
			 String username = keyboard.nextLine();
			 System.out.println("Enter your password: ");
			 String password = keyboard.nextLine();
			 if (validUser(userdata, username, password))
			{
				System.out.println("Validated.");
			}
			else
			{
				System.out.println("Not validated.");
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
     public static String specificArrayData(String[] dataArray, String[] values, int target)
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
     public static String arrayData(String[] array)
     {
          String output = "";
          for (int x = 0; x < array.length; x++)
          {
               output += array[x] + "\n";
          }
          
          return output;
     }

/*
	*validUser will return a boolean indicating if a given username and password are in the input data
	*@param userstuff is the 2D array of user data. [columns][userline]
	*@param username is the entered username
	*@param password is the entered password
	*@return returns a true if the input username and password are a valid pairing, returns false otherwise
*/
	public static boolean validUser(String[][] userstuff, String username, String password)
	{
	boolean validation=true;

		for (int count = 0; count<userstuff[0].length; count++)
		{
			if(userstuff[0][count].equals(username)||userstuff[1][count].equals(password))
			{
				validation = true;
				break;
			}
			else
			{
				validation = false;
			}
		}
	return validation;
	}
}




     
