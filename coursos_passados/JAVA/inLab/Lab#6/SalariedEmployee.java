/** the Salaried Employee class extends the Employee class
*@author Lindsey Wingate
*/

public class SalariedEmployee extends Employee
{
	//default constructor
	public SalariedEmployee()
	{
		super();
	}
		
/**Parameter Constructor
*<br><br>
*Builds a salaried employee, calling upon Employee for the basic information to be set(first and last name, social security number)
*@param base: base salary
*/
	public SalariedEmployee(String fn, String ln, int ss, double base) throws invalidSocialException, invalidMoneyException
	{
		super(fn, ln, ss);
		printSalary(fn, ln, ss, base);
	}
	 
/**toString method
*<br><br>
*Prints all relevant data to the screen for the company's use
*/

	public void printSalary(String firstName, String lastName, int social, double base)throws invalidMoneyException
	{
		System.out.println(firstName+"\n"+lastName+"\n"+social+"\nEarned Salary: "+base);
	}	
}
