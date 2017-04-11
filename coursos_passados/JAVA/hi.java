public class hi
{
	public static void main(String[] args)
	{
		String fn = "hi";
	
		for(int x = 0; x<=fn.length(); ++x)
		{	
			String[] parts = fn.split("");
			System.out.println(parts[x]);
		}
	}
}
