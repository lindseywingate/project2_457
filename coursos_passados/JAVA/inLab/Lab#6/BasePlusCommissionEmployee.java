/**The BasePlusCommissionEmployee is based off Employee with additional variables
*@author Lindsey Wingate
*/
public class BasePlusCommissionEmployee extends Employee
{
	
	private double grossScale;
	private double comRate;
	private double baseSalary;
	
	//default constructor
	public BasePlusCommissionEmployee()
	{
		super();
	}
	
/**calls employee for basic information to set (last and first name, social security number)
*@param g: gross scale
*@param com: commission rate
*@param base: base salary rate
*/
	public BasePlusCommissionEmployee(String fn, String ln, int ss, double g, double com, double base) throws invalidSocialException, invalidMoneyException
	{
		super(fn, ln, ss);
		setGross(g);
		setComRate(com);
		calculateSalary(fn, ln, ss, grossScale, comRate, baseSalary);
	}
	
/**sets gross rate, if not correct sets off error
*/
	public void setGross(double g) throws invalidMoneyException
	{
		if(g<5)
		{
			throw new invalidMoneyException();
		}
		
		else
		{
			grossScale = g;
		}
	}

/**sets commission rate, if not correct sets off error
*/

	public void setComRate(double com) throws invalidMoneyException
	{
		if(com<=10)
		{
			throw new invalidMoneyException();
		}
		else
		{
			comRate = com;
		}
	}
/**sets base salary, if too low sets of error
*/
	public void setBaseSalary(double base) throws invalidMoneyException
	{
		if(base<999)
		{
			throw new invalidMoneyException();
		}
		else
		{
			baseSalary = base;	
		}
	}

/**toString method
*prints off all applicable data for the payroll
*/
	public void calculateSalary(String firstName, String lastName, int social, double grossScale, double comRate, double baseSalary) throws invalidMoneyException
	{
		double earnedSalary = (grossScale*comRate)+baseSalary+(baseSalary*.15);
		System.out.println(firstName+"\n"+lastName+"\n"+social+"\nEarned Salary: "+ earnedSalary+"\n");
	}
}
