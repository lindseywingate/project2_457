import java.util.*;
import java.io.*;
/**
The class inLab10 allows you to create a random array of numbers and sort them as if you were going to do a quicksort.
It also allows you to create random lists of names starting with A and B, replacing the B names with "replaced." A highly valuable resource...
*/

public class inLab10	{

	/*does what I said in the first explanation*/

	public static void main(String[] args)	{
	//Part 1
		int[] nums = new int[20];
		int count = 0;
		Random gen = new Random();
		int total = 0;

		//add values to array
		for(int thing : nums)	{
			int value = gen.nextInt(80)+10;
			total = total + value;
			nums[count] = value;
			count++;
		}

		//print average
		int answer = total/count;

		//initialize arrayLists to separate values
		ArrayList<Integer>greater = new ArrayList<Integer>();
		ArrayList<Integer>less = new ArrayList<Integer>();
		
		//add values together and get average

		for(int nextThing : nums) {
			if(nextThing>answer)	{
				greater.add(nextThing);	
			}	
			else if(nextThing<answer)	{
				less.add(nextThing);
			}
		}
		System.out.println(" ");
		System.out.println("The list of the greater values: ");
		for(int inListG: greater)	{
			System.out.print(inListG+" ");
		}

		System.out.println("The list of the lesser values: ");
		for(int inListL: less)	{
			System.out.print(inListL+" ");		
		}	
		System.out.println(" ");
		
	//Part 2
		//declare array for names to be stored
		ArrayList<String>names = new ArrayList<String>();
	
		Scanner eye = new Scanner(System.in);
		System.out.println("How many names would you like to enter? ");
		int numNames = eye.nextInt();
		
		eye.nextLine();
		while(numNames>0)	{

			System.out.println("Please enter names starting with A or B: ");
			System.out.println(" ");
			String addMe = eye.nextLine();
			names.add(addMe);
			numNames--;
		}
		
		System.out.println("What names would you like to remove? ");
		String removeMe = eye.nextLine();
		int indexCounter = 0;		
		
		for(String blah : names)	{
			if(blah.equals(removeMe))	{
				names.remove(removeMe);	
				break;
			}
		}

		for(String last : names)	{
			int index = last.indexOf("B");
			if(index==0)	{
				System.out.println("Index of Removed Element: "+indexCounter);
				names.set(indexCounter, "Replaced");
			}
		indexCounter++;
		}	

		System.out.println(" ");
		System.out.println("Modified ArrayList: ");
		for(String nombre : names)	{
			System.out.println(nombre);		
		}							
	}
}

















