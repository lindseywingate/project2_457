import java.util.*;

public class inLab7
{
	public static void main(String[]args)
	{
		int x, reverse = 0;
		Scanner bert = new Scanner(System.in);
		
		System.out.println("Please enter an integer to reverse! ");
		reverse = bert.nextInt();
		
		while(x !=0)
		{		
			reverse = reverse*10;
			reverse = reverse + x%10;
			x = x/10;
			System.out.println(reverse);
		}
		
	}
}
