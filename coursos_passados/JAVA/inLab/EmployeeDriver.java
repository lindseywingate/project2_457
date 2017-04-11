import java.io.*;
import java.util.*;

public class EmployeeDriver
{
	public static void main(String[] args)
	{
		//open file to get information on employees 
		File file = new File("payroll.txt");
		Scanner inputFile = new Scanner (file);	
		
		while(inputFile.hasNext())
		{
			String line = inputFile.nextLine();
			
			int x = 0
			while(x<4)			
			{			
				String[] data;
				data[x] = line.split(" ");
				x += 1;
			}

			//create new employee object for each line in file
			System.out.println("\n");
			Employee name = new Employee()
		}

		close();
	}
}
