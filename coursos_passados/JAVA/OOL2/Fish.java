public class Fish extends Pet
{
	boolean poisonous;

/**Default constructor
*/
	Fish()
	{
		super();
	}

/**Default parameter constructor
*fetches basic characteristics 
*/	
	Fish(String name, double caret, double carec, int sat, int ref)
	{
		super(name, caret, carec, sat, ref);
		poisonous = setPoisonous();
	}

/**setPoisonous
*calls getPoisonous to assign variable
*/
	public boolean setPoisonous()
	{
		poisonous = getPoisonous();
		return poisonous;
	}

/**getPoisonous
*chooses random boolean variable for poisonous
*/
	public boolean getPoisonous()
	{
		Random poo = new Random();
		p = poo.nextBoolean();
		return p;
	}
		
	public toString();
	{
		
	}
	
	public equals();
	{

	}
}
