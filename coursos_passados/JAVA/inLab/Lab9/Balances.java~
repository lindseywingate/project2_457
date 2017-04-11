import java.util.*;

/**
* The Balances class is used to store names, bank balances, and allows access to change the balances.
* <br><br>
* @author Lindsey Wingate
*/
public class Balances
{
/*
* main creates the hashtable and asks the user whether they would like to change a balance or not
*--Getting user input<br>
*--calling changeBalance for changes<br>
*/
	public static void main(String args[])
	{
		Scanner getInfo = new Scanner(System.in);

		Hashtable <String,Double> table = new Hashtable<String,Double>();
		table.put("Jordan", 5000.4);
		table.put("Lindsey", 2.2);
		table.put("Christine", 3000.5);
		table.put("Kirk", -30.90);
		table.put("Amanda", 800.1);
		Set<String> keys = table.keySet();
		for (String key : keys) {
			System.out.println(key + ": " +table.get(key));	
		}
		System.out.println(" ");
	
		changeBalance(table, keys);

		System.out.println("Would you like to change another balance? Choose Y or N");
		String response = getInfo.nextLine();
		if (response.equals("y") || response.equals("Y"))	{
			changeBalance(table, keys);
		}
		else
		 System.out.println("Goodbye");
	}
/*
*changeBalance requests the name on the account and the balance. It allows the user to override the previous balance
*/
	public static void changeBalance(Hashtable <String,Double> table, Set<String> keys)	
	{
		Scanner getInfo = new Scanner(System.in);
		System.out.println("What is the name on the account?");
		String name = getInfo.nextLine();
		
		if(table.containsKey(name)) {
			System.out.println("It has it!");
			System.out.println("What is the new balance on the account?");
			Double newBal = getInfo.nextDouble();	
			table.put(name, newBal);
		}
		else	{
			System.out.println("There is no account for that name.");
		}

			System.out.println(" ");
			System.out.println("Account Totals: ");

		for (String key : keys) {
			System.out.println(key + ": " +table.get(key));
		}
		System.out.println(" ");				
			
	}
}
