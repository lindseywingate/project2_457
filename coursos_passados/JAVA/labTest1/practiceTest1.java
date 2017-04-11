import java.util.*;

public class practiceTest1
{
	public static void main(String[] args)
	{
		Random gen = new Random();
		int randNum = 0;
		
		System.out.println("This is the test review.");
		String test = "5";
		int newString;
		newString = Integer.parseInt(test);
		System.out.println(newString);

		Scanner keyboard = new Scanner(System.in);
		int num;
		System.out.println("How many students?");
		num = keyboard.nextInt();
		int x;

		for(x=0; x<num; ++x)
		{
			randNum = gen.nextInt(5)+5;
			System.out.println("This is a test!! print me " + num + " times!!");
			System.out.println(randNum);
		}
		
	}
}
