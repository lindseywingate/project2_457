/**
*The invalidMoneyException throws an error whenever the base salar, gross scale, or commission rates drop below a certain level.
*@author Lindsey Wingate
*/
public class invalidMoneyException extends Exception
{
	public String message()
	{
		return "You should really pay your employees more. Invalid entry for Base salary, Gross scale, and/or Commission";
	}
}
