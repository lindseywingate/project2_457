import java.util.*;

public class QuickSort
{
	public static ArrayList main(String[] args) 
	{
		ArrayList data = new ArrayList();
		data.add(1);
		data.add(2);
		data.add(3);
		data.add(4);
		data.add(5);
		data.add(6);
		data.add(7);
		
		for(int x=0; x<data.size(); x++)
		{
			System.out.println(data.get(x));
		}
		data = quicksort(data);

		System.out.println("------------------SORTED DATA-------------");
		for(int x = 0; x<data.size(); x++) {
			System.out.println(data(x));
		}
	}
	
	public static ArrayList quicksort(ArrayList input)
	{
		//Divide my list into 2 parts, and make them separate lists
		ArrayList top = new ArrayList();
		ArrayList bottom = new ArrayList();
		
		//check to make sure array has data :)		
		if(input.size() == 0){
			return null;
		}
		int pivot = (int) input.get(0); //casting item from list to int
		for (int x = 1; x < input.size(); x++) {
			if(pivot < (int) input.get(x)) {
				top.add(input.get(x));
			}		
			else {
				bottom.add(input.get(x));
			}		
		}
		ArrayList answer = new ArrayList();

		//paranoid notation
		bottom = quicksort(bottom);
		if (bottom !=null) {
			for(int w = 0; w<bottom.size(); w++) {
				answer.add(bottom.get(w));			
			}
		}		
		
		top = quicksort(top);
		if (top != null) {
			for (int e = 0;e<top.size(); e++) {
				answer.add(top.get(e));
				return answer;
			}	
		}
	}
	
}




	
