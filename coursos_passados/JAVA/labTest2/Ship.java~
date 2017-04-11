/**
 * The Ship class contains constructors for Ship objects and methods that can be used on Ship objects.
 * @author Scott Kerlin
 * @version Feb 24, 2014
 */
public class Ship 
{
  
  //Create instance variables
  private String name;
  private int year;
  private static int ships = 0;
  
  /**
   * This constructor takes in two parameters and creates a ship object.
   * @param name The parameter for the name of the ship.
   * @param year The parameter for the year the ship was built.
   * @return A ship object.
   */
  public Ship(String inName, int inYear) 
  {
    name = inName;
    //I didn't validate year, because I treat negaive numbers as BCE years
    year = inYear;
    ships++; // Increment number of ships
  }
  
  /**
   * This accessor method gets the name of the ship and returns it.
   * @return The name of the ship in string form.
   */
  public String GetName() 
  {
    return name;
  }
  
   /**
   * This accessor method retuns the number of ships currently in existance.
   * @return Number of Ships currently out at sea
   */
  public static int GetShips() 
  {
    return ships;
  }
  
  /**
   * This method sets the name of the ship.
   * @parameter inName The name to set the ship to.
   */
  public void SetName(String inName) 
  {
    name = inName;
  }
  
  /**
   * This accessor method gets the year the ship was built and returns it.
   * @return The year the ship was built in long form.
   */
  public int GetYear() 
  {
    return year;
  }
  
  /**
   * This accessor method sets the year the ship was built.
   * @parameter inYear The year to set the year built to.
   */
  public void SetYear(int inYear) 
  {
      year = inYear;
  }
  
  /**
   * This method returns information about the ship in a string.
   * @return A string, containing the information about the ship.
   */
  public String ToString() 
  {
      String suffix;
      int modYear;
      if (year < 0)
      {
        modYear = year * -1;
        suffix = "BCE";
      }
      else
      {
        suffix = "CE";
        modYear = year;
      }


    return "The ship "+name+" was built in "+modYear+" " +suffix+ ".";
  }
  
}
