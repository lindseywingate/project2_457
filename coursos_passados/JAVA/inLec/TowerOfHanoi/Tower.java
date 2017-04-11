
/**
 * The Tower class contains constructors for Tower objects and methods that can be used on Tower objects.
 * @author Scott Kerlin
 * @version Oct 4, 2013
 */
public class Tower
{
     //Towers hold between zero an N disks on a peg...This makes them basically arrays.
     private int[] peg;       //Array of numbers...Tracks what disks are on the tower, and in what order
     private int number = 0;  //Indicates how many disks are currently on the peg.
     
       
     /**
      * This constructor takes in two parameters and creates a Tower object.
      * @param size The max number of disks that can be stored on the tower's peg.
      * @param isStart A boolean to indicate if this is the starting peg or not.  If true, disks are placed on this peg.
      * @return A Tower object.
      */
     public Tower(int size, boolean isStart)
     {
          //Create peg
          if (size > 0)
          {
               peg = new int[size];
          }
          else
          {
               peg = new int[0];
          }
          
          //Populate peg with disks if starting peg
          if (isStart)
          {
               for (int index = 0; index < peg.length; index++)
               {
                    //Add pegs from largest (size N) to smallest, (size 1)
                    try
                    {
                         addDisk(peg.length - index);
                    }
                    catch (TowerFullException e)
                    {
                         System.out.println(e.getMessage());
                    }
                    catch (BadStackingException e)
                    {
                         System.out.println(e.getMessage());
                    }
               }
          }
          
     }
     
     /**
      * addDisk adds the indicated disk to the top of the tower's peg.  Returns true if successfull, returns false otherwise
      * @param disk The disk to add to the top of the tower
      * @return a boolean indicating success with adding the disk to the tower.
      */
     public boolean addDisk(int disk) throws TowerFullException, BadStackingException
     {
          //Check if peg is empty OR new disk is smaller than topmost disk AND peg isn't full, add disk
          if ( (number == 0 || disk < peg[number - 1]) && (number != peg.length) )
          {
               //Add disk to top of peg
               peg[number] = disk;
               number++;
               //return true
               return true;
          }
          //If full, throw TowerFullException
          else if (number == peg.length)
          {
               throw new TowerFullException();
          }
          else if (disk >= peg[number - 1])
          {
               throw new BadStackingException();
          }
          else 
          {
               return false;
          }
     }
     
     /**
      * removeDisk removes the disk at the top of the tower's peg.  
      * @return the int representing the disk at the top of the peg.  Throws TowerEmptyException if tower is empty.
      */
     public int removeDisk() throws TowerEmptyException
     {
          //Check if peg is empty
          if (number > 0)
          {
               //Remove disk to top of peg
               number--;
               return peg[number];
          }
          else
          {
               //Unable to remove disk
               //Also going to print an error message, just so you know something bad happened...
               //If this was a real program, I'd be throwning an exception instead.
               throw new TowerEmptyException();
          }
     }

     /**
      * toString creates a bit of ascii art that shows the current state of the Tower
      * @return a String with ascii art of the tower.  Returns "[empty]" if tower is empty.
      */
     public String toString()
     {
          //Check if peg is empty
          if (number != 0)
          {
               //ASCII art string creation
               String ascii = "";
               
               //Loop through each disk on the peg, from top to bottom.
               for (int index = number - 1; index >= 0; index--)
               {
                    //Make a row of X's that matches the value of each disk
                    for (int x = 0; x < peg[index]; x++)
                    {
                         ascii += "X";
                    }
                    
                    //Add a new line after each row
                    ascii += "\n";
               }
               
               return ascii;
          }
          else
          {
               //Empty
               return "[empty]\n";
          }
     }

     /**
      * getMaxSize returns the maximum number of disks that can be held by this tower
      * @return int maxSize.
      */
     public int getMaxSize()
     {
          return peg.length;
     }

}
