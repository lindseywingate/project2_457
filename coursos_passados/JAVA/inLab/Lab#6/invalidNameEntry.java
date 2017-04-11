/**
*The invalidNameEntry exception is thrown anytime the first or last name contains numbers or invalid characters
*@author Lindsey Wingate
*/

public class invalidNameEntry extends Exception
{
	public String message()
	{	
		return "Invalid entry for first name and last name. Must be letters";
	}
}
