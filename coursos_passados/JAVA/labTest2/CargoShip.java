/**
 * The CargoShip class is a child of the Ship class and contains constructors and methods for a Ship with properties exclusive to cargo ships.
 * @author Scott Kerlin
 * @version Feb 24, 2014
 */
public class CargoShip extends Ship {
  
  /* Create instance variables */
  private static double maxCargo; // The maximum payload for the ship.
  private static double curCargo; // The current payload the ship is carrying.
  
  /**
   * This constructor takes in 4 parameters and creates a CargoShip object using the parameters.
   * @param inShipName The inputted name of the ship as a string
   * @param inYearBuilt The inputted year the ship was built as a long
   * @param inMax The inputted maximum tonnage of cargo the CargoShip can hold as a double
   * @param inCargo The inputted current tonnage the CargoShip is holding as a double
   * @return A CargoShip object
   */
  public CargoShip(String inShipName, int inYearBuilt, double inMax, double inCargo) 
  {
    super(inShipName, inYearBuilt);
    //Set Max first, then current
    SetMaxCargo(inMax);
    if (inCargo <= maxCargo && inCargo >= 0)
 {
     curCargo = inCargo;
 }
    else if (inCargo > maxCargo)
 {
     curCargo = maxCargo;
 }
    else
 {
     curCargo = 0;
 }
  }
  
  /**
   * This accessor method gets the maximum tonnage of cargo the CargoShip can hold.
   * @return The maximum tonnage of cargo the CargoShip can hold as a double.
   */
  public static double GetMaxCargo() 
  {
    return maxCargo;
  }
  
  /**
   * This accessor method gets the current tonnage the CargoShip is carrying.
   * @return The current tonnage the CargoShip is carrying as a double.
   */
  public static double GetCurrentCargo() 
  {
    return curCargo;
  }

  /**
   * This method adds cargo to the ship
   * @param inCargo The amount of cargo to add as a double
   * @return returns the amount of excess cargo OR -1 if input was negative
   */
  public static double AddCargo(double inCargo) 
    {
    if (inCargo < 0) 
 {
     return -1;
 }
    else if (inCargo + curCargo > maxCargo)
 {
     double surplus = inCargo + curCargo - maxCargo;
     curCargo = maxCargo;
     return surplus;
 } 
    else 
 {
     curCargo += inCargo;
     return 0;
 }

    }
  
  /**
   * This method removes cargo from the ship
   * @param inCargo The amount of cargo to remove as a double
   * @return returns amount of cargo unable to be unloaded OR -1 if input was negative
   */
  public static double RemoveCargo(double inCargo) 
    {
    if (inCargo < 0) 
 {
     return -1;
 }
    else if (curCargo - inCargo < 0)
 {
     double surplus = inCargo - curCargo;
     curCargo = 0;
     return surplus;
 } 
    else
 {
    curCargo -= inCargo;
    return 0;
 }
 
    }

  
  /**
   * This method returns a string giving information about the CargoShip.
   * @return A string containing information about the ship.
   */
  public String toString() 
  {
    return "The cargo ship \""+GetName()+"\" was built in "+GetYear()+". It has a maximum payload of "+maxCargo+" tons and is currently carrying "+curCargo+" tons of cargo.";
  }
  
  /**
   * This accessor method sets the cargo limit for the CargoShip.
   * @param inLimit The limit of cargo allowed on the CargoShip
   */
  public static void SetMaxCargo(double inLimit) 
  {
    if (inLimit > 0) 
    {
      maxCargo = inLimit;
    } 
    else 
    {
      maxCargo = 0;
    }
  }
  
}
