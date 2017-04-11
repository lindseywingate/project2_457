import java.util.*;
import java.io.*;

public class EmployeeDataDriver 
{
	public static void main(String[] args) throws FileNotFoundException	{
		ArrayList<Employee> employees= new ArrayList<Employee>();		
		employees = readData(employees);
		employees = quickSort(employees);
		for(Employee bob : employees)	
			System.out.println(bob);
		linearSearch(employees);
	}

	public static ArrayList<Employee> readData(ArrayList<Employee>employees) throws FileNotFoundException	{
		File data = new File("payroll.txt");
		Scanner test = new Scanner(data);
		int count = 0;

		while (test.hasNext())	{
			String line = test.nextLine();

			//split line data into an array
			String [] data2 = line.split("/");
			int num = Integer.parseInt(data2[1]);
			String name = data2[0];			
			//check if printing out correct data			
			//System.out.println(name +" "+ num);			

			//create new object with line data and add to array
			Employee frank = new Employee(name, num);
			employees.add(frank);
			count = count + 1;				
		}		
		return employees;
	}

	public static ArrayList<Employee> quickSort(ArrayList<Employee> employees)	{
		if (employees.size()==0)
  			return null;
  			
  		ArrayList<Employee>top = new ArrayList<Employee>();
  		ArrayList<Employee>bottom = new ArrayList<Employee>();

		Employee pivot = employees.get(0);
		for(int b = 1; b< employees.size(); b++) {
   			if(employees.get(b).getNumber()>pivot.getNumber())
				top.add(employees.get(b));
   			else
   				 bottom.add(employees.get(b));
  		}

		ArrayList<Employee>answer = new ArrayList<Employee>();  
 		bottom = quickSort(bottom);

 		if(bottom != null)	{
   			for(int c = 0; c<bottom.size(); c++) {
    				answer.add(bottom.get(c));
  			}
 		} 
  
  		answer.add(pivot);

		top = quickSort(top);
  		if(top!=null) {
   			for(int d = 0; d<top.size(); d++) {
    				answer.add(top.get(d));
  			} 
 		}
  		return answer;
 	}	
			
	public static void linearSearch (ArrayList<Employee>employees)	{
		Scanner eye = new Scanner(System.in);
		boolean found = false;
		System.out.println("Please provide an employee name: ");
		String input = eye.nextLine();
		for(Employee dude : employees)	{
			if(input.equals(dude.getName()))	{
				System.out.println("Employee found!");
				found = true;
				break;
			}			
			else
				found = false;
		}
		if(found == false)
			System.out.println("Employee not found");
	}			
}

