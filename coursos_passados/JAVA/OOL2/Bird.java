/**The Bird class is an extension of Pet. It references the parent class variables and creates it's own characteristics.
*@author Lindsey Wingate
*/
public class Bird extends Pet
{
	protected double tweeting;
	protected boolean fly;
	protected boolean eatsRabbits;
	protected boolean eatsFish;
	protected String[] birdData;

/**Default constructor
*/
	public Bird()
	{
		super();
	}

/**Bird 
*gathers information from parent class and get methods to create a unique birdy.
*@param name
*@param caret
*@param carec
*@param sat
*@param ref
*/
	public Bird(String name, double caret, double carec, int sat, int ref)
	{
		super(name, caret, carec, sat, ref);

		tweeting = setTweeting();
		fly = setFly();
		eatsRabbits = setEatsRabbits();
		eatsFish = setEatsFish();

		String[] birdData = toString(String name, double caret, double carec, int sat, int ref, boolean tweeting, boolean fly, boolean eatsRabbits, boolean eatsFish);
		//create array to store unique bird data
		
	}

/**setTweeting
*sets variable to name
*/
	public double setTweeting()
	{
		tweeting = getTweeting();
		return double;
	}

/**getTweeting
*chooses a random variable for tweeting frequency
*/
	public double getTweeting()
	{
		Random tweet = new Random();
		double rangeMin = 0.0;
		double rangeMax = 5.0;
		tweeting = rangeMin+(rangeMax-rangeMin)*tweet.nextDouble();
		return tweeting;
	}
	
/**setFly
*sets variable to name
*/
	public boolean setFly()
	{
		fly = getFly();
		return fly;
	}

/**getFly
*chooses random boolean value- can the bird fly?
*/
	public boolean getFly()
	{
		Random flyAway = new Random();
		fly = flyAway.nextBoolean();
		return fly;
	}

/**setEatsRabbits
*assigns boolean variable to eatsRabbits
*/
	public boolean setEatsRabbits()
	{
		eatsRabbits = getEatsRabbits();
		return eatsRabbits;
	}

/**getEatsRabbits
*assigns random boolean variable to whether or not the bird can eat a rabbit
*/
	public boolean getEatsRabbits()
	{
		Random yum = new Random();
		eatsRabbits = yum.nextBoolean();
		return eatsRabbits;
	}

/**setEatsFish
*assigns eatsFish to variable
*/
	public boolean setEatsFish()
	{
		eatsFish = getEatsFish();
		return eatsFish;
	}

/**getEatsFish
*chooses random boolean variable to whether or not the bird eats fish
*/
	public boolean getEatsFish()
	{
		Random fishies = new Random();
		boolean eatsFish = fishies.nextBoolean();
		return eatsFish;
	}

/**toString
*converts all variables to strings and creates an array
*/
	public String[] toString(String name, String name, double caret, double carec, int sat, int ref, boolean tweeting, boolean fly, boolean eatsRabbits, boolean eatsFish)
	{
		String[] bird = new String[9]
		bird[0] = name;
		bird[1] = careTime;
		bird[2] = careCost;
		bird[3] = satisfaction;
		bird[4] = reflex;
		bird[5] = Double.toString(tweeting);
		bird[6] = String.valueOf(fly);
		bird[7] = String.valueOf(eatsRabbits);
		bird[8] = String.valueOf(eatsFish);
		return bird;	
	}

}
