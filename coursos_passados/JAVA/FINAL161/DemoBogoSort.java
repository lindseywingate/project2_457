import java.util.*;

public class DemoBogoSort
{
     //Get Some Raw Data
     static int[] data = {1, 5, 51, 2, 14, 23, 12, 10, 92, 29, 29};
          
     
     public static void main(String[] args)
     {

          //Show Raw Data to User
          System.out.println("Original Data:");
          for (int item : data)
               System.out.print(item + " ");
          
          //Call Bogo Sort
          bogoSort();

     }
     
	public static int[] bogoSort()
	{
		boolean check = false;
		int length = data.length-1;
		Random index = new Random();
		int checker = 0;

		while(check == false)
		{
			int randomNum = index.nextInt(length);
			int temp = data[randomNum];
			data[length] = data[randomNum];
			data[randomNum] = temp;
			System.out.println("Attempt: ");
			for(int thing : data)
				System.out.println(thing);
			
			for (int i = 0; i<length; i++)
			{
				if(data[i] > data[i+1])
				{					
					check = false;
					break;
				}				
				else
					check = true;
			}
		}	
		
		return data;
	}
}
