import java.util.Scanner;
/**
 * The TowersOfHanoi class utilizes 3 Tower Objects to solve the Towers of Hanoi Problem.
 * The user is able to enter a value which determines the number of disks to use.
 * @author Scott Kerlin
 * @version Oct 4, 2013
 */
public class TowersOfHanoi
{
  
     //All Towers of Hanoi problems require 3 towers
     static Tower towerA;
     static Tower towerB;
     static Tower towerC;
     
     /**
      The main method prompts the user for a number of disks to use, builds 3 Tower Objects, and solves the problem.
      divisor of the arguments passed into x and y.
      */
     public static void main(String[] args)
     {
          //Variable to store number of disks
          int numDisks;
          // Create a Scanner object for keyboard input.
          Scanner keyboard = new Scanner(System.in);
          
          //Get problem size
          do
          {
               System.out.println("How many disks do you want to use in your Demo?");
               numDisks = keyboard.nextInt();
          } while(numDisks <= 0);

          System.out.println("You wanted a demo with " + numDisks + " disks.\nGenerating your demo");
          
          //Build tower objects.
          towerA = new Tower(numDisks,true);
          towerB = new Tower(numDisks,false);
          towerC = new Tower(numDisks,false);
          
          //Print starting position
          System.out.println("\n\n------------------\n------------------\n" + towerA + "Tower A\n\n" + towerB + "Tower B\n\n" + towerC + "Tower C\n\n------------------\n------------------\n");
          
         //Call solve() to solve the problem.
          solve(numDisks, towerA, towerC, towerB);
          
          System.out.println("Demo is now complete, I hope you enjoyed your demo!");
          
     }

     
     /**solve takes in the 4 parameters needed to solve the Towers of Hanoi problem, then solves the problem.
      * @param problemSize indicates the number of disks in the current problem size
      * @param source indicates the tower housing the disks we need to move
      * @param dest indicates the tower we want the disks to be on after we finish moving
      * @param temp indicates the tower which is available assiting in the move
      * @return true if problem could be solved, returns false otherwise.
      */
     public static boolean solve(int problemSize, Tower source, Tower dest, Tower temp) 
    {
	if (problemSize == 0)
	{
		return true;
	}
	else if(problemSize<0)
	{
		return false;
	}
	else
	{
		solve(problemSize-1, source, temp, dest);
		try
		{
			dest.addDisk(source.removeDisk());
		}
		catch(TowerEmptyException i)
		{		
			System.out.println(i.getMessage());
		}
		catch(TowerFullException l)
		{
			System.out.println(l.getMessage());
		}
		catch(BadStackingException m)
		{	
			System.out.println(m.getMessage());
		}
		System.out.println("\n\n------------------\n------------------\n" + towerA + "Tower A\n\n" + towerB + "Tower B\n\n" + towerC + "Tower C\n\n------------------\n------------------\n");
		solve(problemSize-1, temp, dest, source);
		return false;
	}	
     }
}
