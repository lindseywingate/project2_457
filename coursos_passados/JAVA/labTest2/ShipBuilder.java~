//Test program for building and using ships
public class ShipBuilder
{
  public static void main(String[] args)
  {
    //Create some Ships
    Ship[] ships = new Ship[2];
    ships[0] = new CargoShip("Stuff Mover", 1989, 12.4, 12.3);
    ships[1] = new CruiseShip("People Mover", 1989, 20.0, 18.0);
    System.out.println("--Just created " + Ship.GetShips() + " ships---\n" + ships[0] + "\n" + ships[1]);
    
    
    //Test over filling the ships
    for (int x = 0; x < ships.length; x++)
    {
	if(ships[x] instanceof CargoShip)
	{
            CargoShip.AddCargo(2.0);
	}
	if(ships[x] instanceof CruiseShip)
	{
            CruiseShip.AddPassengers(4.0);
	}
         System.out.println("--After OverFilling---\n" + ships[x]);
    }

    //Test removing from ships
    for(int x=0; x<ships.length; x++)
    {
	if(ships[x] instanceof CargoShip)
	{
	    CargoShip.RemoveCargo(2.0);
	}
	if(ships[x] instanceof CruiseShip)
	{	
	    CruiseShip.RemovePassengers(5.0);
	}	
	System.out.println("--After Removing---\n" + ships[x]);
    }
    
   
  }
}
