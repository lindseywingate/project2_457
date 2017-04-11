public class GlassOfMilk
{
     private boolean full = false;
     
     public GlassOfMilk () throws SpilledMilkException
     {
	fillGlass(full);
	toString();
     }
     
     public static boolean fillGlass (boolean full) throws SpilledMilkException
    {
	if(full == true)
	throw new SpilledMilkException();    

	else
	return true;
    }
	    
     public String toString()
     {
          if (full)
               return "Your Glass of Milk is full";
          return "Your Glass of Milk is empty";
     }
}
