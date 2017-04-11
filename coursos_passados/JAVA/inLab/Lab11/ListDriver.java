import java.io.*;
import java.util.*;
/**ListDriver allows you to manipulate a linked list of scores. You may add, delete, display, or quit*/
public class ListDriver	
{
/*main allows the user to add up to 5 top scores. To add another score it must be greater than one already provided*/
	public static void main(String[] args)
	{
		
		LinkedList students = new LinkedList();
		Scanner scanMe = new Scanner(System.in);
		int input = 0;		
		int count = 0;

		while(input!=4)	
		{
			System.out.println("What would you like to do:\n1. Insert student and score \n2. Delete student and score \n3. Display students and scores\n4.Quit");
			input = scanMe.nextInt();
			

			if(input == 1)
			{
				count=count+1;

				scanMe.nextLine();
				System.out.println("Please enter a name: ");
				System.out.println(" ");
				String name = scanMe.nextLine();

				System.out.println("Please enter a score: ");
				double score = scanMe.nextDouble();

				Node nerdster = new Node();
				Student nerd = new Student(name, score);
				//add object data to node
				nerdster.setData(nerd);

				if(count>5)
				{
					students.switchNodes(nerdster);	
				}
				else
				{
	
					//add node to linkedlist
					students.add(nerdster);
				}
			}
	
			if(input == 2)//search1
			{	
				scanMe.nextLine();
				System.out.println("Please enter name to delete: ");
				String searchName = scanMe.nextLine();
				students.remove(searchName);
			}
			if(input == 3)
			{
				System.out.println(students);
			}			
			if(input == 4)
				System.out.println("Goodbye!");
		}

	}
}
	
