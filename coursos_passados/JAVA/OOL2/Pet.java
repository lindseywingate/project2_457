import java.util.*;
/**
*The Pet class creates the parent object with the basic pet characteristics.
*@author Lindsey Wingate
*/
public class Pet
{
	protected String name;
	protected double careTime;
	protected double careCost;
	protected int satisfaction;
	protected int reflex;

/** Default constructor
*/
	public Pet()
	{
	}	
	
/**
*Calls the methods to create the basic characteristics of any pet
*@param name
*@param careTime
*@param careCost
*@param satisfaction
*@param reflex
*/
	public Pet(String n, double t, double c, int s, int r)
	{
		name = setName(n);
		careTime = setCareTime(t);
		careCost = setCareCost(c);
		satisfaction = setSatisfaction(s);
		reflex = setReflex(r);
	}

/**getName()
randomly select name of pet - select random size of name, for each number select character, add character to name (string), returns petName
*/
	public String getName()
	{
		
		int size = 0;
		String petName = "";
		size = rand.nextInt(5)+5;
		
		for (int letters = 0; letters<size; letters++)
		{
			int value = rand.nextInt(25) + 97;
			char letter = Character.toChars(value)[0];
			petName = petName + letter;
		}
		return petName;
	}

/**setName
assigns incoming driver variable to name
*/
	public String setName(String n)
	{
		name = getName(n);
		return name;
	}
	
/**getCareTime
randomly select double for careTime between 0.0 and 5.0
*/
	public double getCareTime()
	{
		Random rand2 = new Random();
		double hoursOfCare = 0;
		double rangeMin = 0.0;
		double rangeMax = 5.0;
		careTime = rangeMin +(rangeMax - rangeMin)*rand2.nextDouble();		
		return careTime;
	}

/**setCareTime
assign incoming driver variable to careTime
*/
	setCareTime(double t)
	{
		careTime = getCareTime(t);
		return careTime;
	}
	
/** getCareCost
randomly select double for careCost between 0.0 and 5.0
*/
	public double getCareCost()
	{
		Random rand3 = new Random();
		double careForPet = 0;
		double rangeMin2 = 0.0;
		double rangeMax2 = 5.0;
		careCost = rangeMin2 + (rangeMax2 - rangeMin2)*rand3.nextDouble();		
		return careCost;
	}

/**setCareCost
assign incoming driver variable to careCost
*/
	public double setCareCost(double c)
	{
		careCost = getCareCost(c);
		return careCost;
	}

/**getSatisfaction
create owner satisfaction rating, int, -10 to 10
*/
	public int getSatisfaction()
	{
		Random rand4 = new Random();
		int satRating = 0;
		satRating = rand.nextInt(20)-10;
		
		return satRating;
	}

/**getSatisfaction
assign incoming variable to satisfaction
*/
	public int setSatisfaction(int s)
	{
		satisfaction = getSatisfaction(s);
		return satisfaction;
	}

/**getReflex
create pet reflex, int, -5 to 10
*/
	public boolean getReflex()
	{
		Random rand5 = new Random();
		int reflex = 0;
		reflex = rand.nextInt(15)-5;
		
		return reflex;	
	}
/** setReflex
assign incoming variable to reflex
*/	
	public boolean setReflex(int r)
	{
		reflex = getReflex(r);
		return reflex;
	}
	
	public toString()
	{
	}

	public equals()
	{
	}
	
	public playNice()
	{
	}
}

