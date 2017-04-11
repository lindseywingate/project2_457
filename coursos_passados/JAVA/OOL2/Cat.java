/**
*The Cat class is an extention of Pet. 
*@author Lindsey Wingate
*/
public class Cat extends Pet
{
	protected boolean declawed;
	protected boolean dogTolerance;
	protected boolean eatsBirds;
	protected boolean eatsRabbits;
	protected boolean eatsFish;

/**Default constructor
*/
	public Cat()
	{
		super();
	}
/**Cat
*Default parameter constructor calls the methods required to create the unique characteristics of Cat.
*/
	public Cat()
	{
		super();
		declawed = setDeclawed(claw);
		dogTolerance = setDogTolerance(dog);
		eatsBirds = setEatsBirds(eatbird);
		eatsRabbit = setEatsRabbit(eatrabbit);
		eatsFish = setEatsFish(eatfish);
	}
/**Cat
*Full parameter constructor accepts standard characteristics from parent class (Pet)
*/
	public Cat(String name, double caret, double carec, int sat, int ref)
	{
		super(name, caret, carec, sat, ref);
	}

/**setDeclawed
*sets boolean variable to declawed
*/
	public boolean setDeclawed()
	{
		declawed = getDeclawed();
		return declawed;
	}
/**getDeclawed
*chooses random boolean - is the cat declawed?
*/	
	public boolean getDeclawed()
	{
		Random rand = new Random();		
		declawed = rand.nextBoolean();
		return declawed;
	}

/**setDogTolerance
*assigns boolean variable to dogTolerance variable
*/
	public setDogTolerance()
	{
		dogTolerance = getDogTolerance();
		return dogTolerance;
	}

/**getDogTolerance
*assigns random boolean variable to decide if cat tolerates dogs or not
*/
	public boolean getDogTolerance()
	{
		Random rand = new Random();		
		dogTolerance = rand.nextBoolean();
		return dogTolerance;
	}

/**setEatsBirds
*assigns randomly decided boolean variable to eatsBirds
*/
	public setEatsBirds()
	{
		eatsBirds = getEatsBirds();
		return eatsBirds;
	}

/**getEatsBirds
*chooses random boolean - whether or not tolerates birds
*/
	public boolean getEatsBirds()
	{
		Random rand = new Random();		
		eatsBirds = rand.nextBoolean();
		return eatsBirds;
	}

/**setEatsRabbits
*assigns boolean to eatsRabbits
*/
	public setEatsRabbits()
	{
		eatsRabbits = getEatsRabbits();
		return eatsRabbits;
	}

/**getEatsRabbits
*assigns random boolean - does cat eat rabbits?
*/
	public boolean getEatsRabbits()
	{
		Random rand = new Random();		
		eatsRabbits = rand.nextBoolean();
		return eatsRabbits;	
	}

/**setEatsFish
*assigns boolean to eatsFish
*/
	public setEatsFish()
	{
		eatsFish = getEatsFish();
		return eatsFish;
	}

/**getEatsFish
*assigns random boolean - does cat eat fish?
*/
	public getEatsFish()
	{
		Random rand = new Random();		
		eatsFish = rand.nextBoolean();
		return eatsFish;
	}
	public toString()
	{
	}
	
	public equals()
	{
	}
}

