//import java.util.*;
public class Fibonacci
{
	static int printMe = 0;
	static int count = 1;

	public static void main(String[] args)
	{
		//Scanner check = new Scanner(System.in);
		//System.out.println("Enter an integer: ");
		//passInt = check.nextInt();
		FibonacciSequence();
	}
	
	public static int FibonacciSequence();
	{	
		
		System.out.println(printMe);
		printMe = printMe+count;
		
		count = count + 1;
		FibonacciSequence();			
	}
}
