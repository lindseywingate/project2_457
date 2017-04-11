import java.util.*;

public class testMilk
{
	public static void main(String[] args) 
	{
		GlassOfMilk yum;
		try
		{
			yum = new GlassOfMilk();
			GlassOfMilk.fillGlass(true);
		}			
		catch(SpilledMilkException y)
		{
			System.out.println(y.message());
		}
	}
}
