import java.util.*;

public class Arrays
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		int[] numbers;
		numbers = new int[10];	
	
		//also int[] numbers = new int[10];

		//also 
		//final int SIZE = 10;
		//int[] numbers = new int[SIZE];
		
		employees(numbers);	
	}
	public static void employees(int[] numbers)
	{
		for(int x = 0; x<numbers.length;x++)
		{
			int a = x + 1;
			Scanner keyboard = new Scanner(System.in);
			System.out.println("How many hours for employee " + a);
			numbers[x] = keyboard.nextInt();
		}
	}
}		
