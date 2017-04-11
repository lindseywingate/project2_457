import java.util.*;
public class Fibonacci
{
	static int printMe = 1;
	static int count = 0;

	public static void main(String[] args)
	{
		Scanner check = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int passInt = check.nextInt();
		FibonacciSequence(passInt);
	}
	
	public static int FibonacciSequence(int num)
	{	
		if(num == 0)
		{System.out.println("0");}
		else if(num==1)
		{System.out.println("1");}

		else
		return FibonacciSequence(num-1) + FibonacciSequence(num-2);
	}		
		





		/*while(num != 0)
		{
			if(count == 0)
			{
				System.out.println("0");
				num = num - 1;
				count = count + 1;
				FibonacciSequence(num);
			}
		
			if(count == 1)
			{
				System.out.println("1");
				num = num - 1;
				count = count + 1;
				FibonacciSequence(num);
			}			
			else
			{
				System.out.println(printMe);
				printMe = printMe+count;
				count = count + 1;
				num = num - 1;			
				FibonacciSequence(printMe);
			}
		break;
		}*/

}
