import java.util.*;
/**
*The PayrollSystem class contains constructors to create one parent (employee) and two child classes used to output employees payroll.
*The user is able to enter the first and last name, social security number, and base rate of the employee. Also, depending on the type of employee, can enter the gross rate and commission rate.
*@author Lindsey Wingate
*/

public class PayrollSystem
{ 
	//requests type of employee and the data for that employee
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the system. How many employees would you like to record?");
		int x = keyboard.nextInt();
		while(x!=0)
		{
			System.out.println("Press 1 to create a commissioned employee or 2 to create a salaried employee. Press 3 to quit.");	
			int input = keyboard.nextInt();

			if(input == 1)
			{
				//gather commissioned employee data
				keyboard.nextLine();
				System.out.println("Please insert the first name: ");
				String fn = keyboard.nextLine();
		
				System.out.println("Please insert the last name: ");
				String ln = keyboard.nextLine();
	
				System.out.println("Please insert the social security number: ");
				int ss = keyboard.nextInt();
		
				System.out.println("Please insert the gross scale. Must be more than 5 ");
				double g = keyboard.nextDouble();
				
				System.out.println("Please insert the commission rate as an integer. Must be more than 10 percent: ");
				double com = keyboard.nextDouble();

				System.out.println("Please insert the salary base rate. Must be more than 999");
				double base = keyboard.nextDouble();	
		
				//create object
				System.out.println("\n");
				
				BasePlusCommissionEmployee yo;
				try
				{
				yo = new BasePlusCommissionEmployee(fn, ln, ss, g, com, base);				
				}
				catch(invalidSocialException e)
				{
					System.out.println(e.message());	
				}
				catch(invalidMoneyException z)
				{
					System.out.println(z.message());
				}
				System.out.println("\n");
				x = x - 1;
			}	
		
			else if(input == 2)
			{
				//gather salaried employee data
				keyboard.nextLine();

				System.out.println("Please insert the first name: ");
				String fn = keyboard.nextLine();

				System.out.println("Please insert the last name: ");
				String ln = keyboard.nextLine();
				
				System.out.println("Please insert the social security number: ");
				int ss = keyboard.nextInt();
				
				System.out.println("Please insert the salary base rate: ");
				double base = keyboard.nextDouble();
			
				//create object
				System.out.println("\n");
				SalariedEmployee yay;
				
				try
				{
					yay = new SalariedEmployee(fn, ln, ss, base);
				}
				catch(invalidSocialException i)
				{
					System.out.println(i.message());
				}
				catch(invalidMoneyException y)
				{
					System.out.println(y.message());
				}
				System.out.println("\n");
				x = x - 1;
			}
			else
			{
				break;
			}	
		}
	}
}
