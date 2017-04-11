import java.util.*;
/**
 * The employee class is an object class for storing user information
 * <br><br>
 * @author Lindsey Wingate
 * @since 2/24/15
 */
public class Employee
{
	private String name;
	private int employeeID;
	private int payrate;
	private int hours;
	private int pay;
	/**
	* Default Constructor
	*<br>
	*Builds a default employee with set default values
	*/
	public Employee()
	{
	}
	
	public Employee(String[] data)
	{
		name = setUsername(data);
		employeeID = setUserID(data);
		payrate = setPayRate(data);
		hours = setHours(data);
		pay = weeklyPay(payrate, hours);
		toString(employeeID, pay);
	}
	
	public String setUsername(String[] data)
	{
		String name = data[0];
		return name;
	}
		
	public int setUserID(String[] data)
	{
		int employeeID = Integer.parseInt(data[1]);
		return employeeID;
	}
		
	public int setPayRate(String[] data)
	{
		int payrate = Integer.parseInt(data[2]);
		return payrate;	
	}
		
	public int setHours(String[] data)
	{
		int hours = Integer.parseInt(data[3]);	
		return hours;				
	}
	
	public void toString(int ID, int pay)
	{
		System.out.println(ID+"\t\t\t"+pay);
	}
	
	public int weeklyPay(int payrate, int hours)
	{
		pay = payrate * hours;
		return pay;
	}

}

	
