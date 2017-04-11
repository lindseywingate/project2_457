/**
*The Employee class creates a parent object including the necessary employee information.
*@author Lindsey Wingate
*/

public class Employee
{
	private String firstName;
	private String lastName;
	private int social;

//default constructor
	public Employee()
	{
	}

/**
*Full Parameter Constructor
*<br><br>
*Builds a default employee with all basic values included
*@param fn: first name
*@param ln: last name
*@param ss: social security number
*/

	public Employee(String fn, String ln, int ss) throws invalidSocialException
	{
		setFirstName(fn);
		setLastName(ln);
		setSocial(ss);
	}

/**
*setFirstName
*<br><br>
*@param fn: first name
*Accepts the first name from the driver and assigns it to a reusable variable
*/

	public void setFirstName(String fn)
	{
		firstName = fn;
	}

/**
*setLastName
*<br><br>
*@param ln: last name
*Accepts the last name from the driver and assigns it to a reusable variable
*/
	public void setLastName(String ln)
	{
		lastName = ln;
	}

/**
*setSocial
*<br><br>
*@param ss: social security number
*Accepts the social security number from the driver and assigns it to a reusable variable
*/
	
	public void setSocial(int ss) throws invalidSocialException
	{
		String newString = Integer.toString(ss);
		if(newString.length()<6)
		{
			throw new invalidSocialException();	
		}
		else
		{
			social = ss;
		}
	}
}
