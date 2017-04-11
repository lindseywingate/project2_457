import java.util.*;

public class Sandwich
{
	public static void main(String[] args)
	{
		String[] sandwich = new String[2];
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Are you hungry? Enter y or n to quit");
		String hungry = keyboard.nextLine();
		boolean test = false;
	
		do
		{
		if(hungry.equals("y")|| hungry.equals("Y"))
		{	
			test = true;
			System.out.println("Would you like peanut butter? Enter y/n");
			String PB = keyboard.nextLine();
			
			if(PB.equals("y")||PB.equals("Y"))
			{
				sandwich[0]="Peanut Butter";

				System.out.println("Would you like jelly? Enter y/n");
				String jelly = keyboard.nextLine();
				if(jelly.equals("y")||jelly.equals("Y"))
				{
					System.out.println("Would you like grape or strawberry? Enter g for grape or s for strawberry.");
					String type = keyboard.nextLine();
					if(type.equals("g")||type.equals("G"))
					{
						sandwich[1] ="Grape Jelly";
					}
					if(type.equals("s")||type.equals("S"))
					{
						sandwich[1]="Strawberry Jelly";
					}
				}	
			}
			else
			{
				System.out.println("Would you like jelly? Enter y/n");
				String jelly = keyboard.nextLine();
				if(jelly.equals("y")||jelly.equals("Y"))
				{
					System.out.println("Would you like grape or strawberry? Enter g for grape or s for strawberry.");
					String type = keyboard.nextLine();
					if(type.equals("g")||type.equals("G"))
					{
						sandwich[0] ="Grape Jelly";
					}
					if(type.equals("s")||type.equals("S"))
					{
						sandwich[0]="Strawberry Jelly";
					}
				}	
			}
		}
		else
		{
			test = false;
			System.out.println("Raw bread is always good too.");
			break;
		}

		System.out.println("Are you hungry? Enter y or n to quit");
		hungry = keyboard.nextLine();

		}while(test == true);
		

	}
}
		
