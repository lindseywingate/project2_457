public class Dog extends Pet
{
	boolean catTolerance;
	boolean eatsRabbits;
	boolean barkFreq;
	
	public Dog(String name, double caret, double carec, int sat, int ref)
	{
		super(name, caret, carec, sat, ref);
		catTolerance = setCatTolerance();
		eatsRabbits = setEatsRabbits();
		barkFreq = setBarkFreq();
	}
	
	public boolean setCatTolerance()
	{
		catTolerance = getCatTolerance();
		return catTolerance;
	}

	public boolean getCatTolerance()
	{
		Random rand = new Random();		
		catTol = rand.nextBoolean();
		return catTol;
	}

	public boolean setEatsRabbits()
	{
		eatsRabbits = getEatsRabbits();
		return eatsRabbits;
	}

	public boolean getEatsRabbits()
	{
		Random rand = new Random();		
		rab = rand.nextBoolean();
		return rab;
	}

	public double setBarkFreq()
	{
		barkFreq = getBarkFreq();
		return barkFreq;	
	}

	public double getBarkFreq()
	{
		Random rand2 = new Random();
		double rangeMin = 0.0;
		double rangeMax = 5.0;
		barkFreq = rangeMin +(rangeMax - rangeMin)*rand2.nextDouble();
		return barkFreq;
	}
		
	public toString()
	{
		
	}
	
	public equals();
	{

	}
}