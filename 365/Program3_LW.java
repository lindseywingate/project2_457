/*This code was written by Lindsey Wingate*/
import java.util.*;
import java.io.*;

class Program3_LW
{
	public static void main (String[] args) throws IOException	{
		if(args.length == 0) {
			System.out.println("Please enter a file to read from when you run the program.");
			System.exit(0);	
		}

		File file = new File(args[0]);
		String line;
					
		FileInputStream streamer = new FileInputStream(file);	
		BufferedReader br = new BufferedReader (new InputStreamReader(streamer));

		while ((line = br.readLine()) !=null) {	
		String line_str = new String(line);
			for(String retval: line_str.split(" ", 2))
				System.out.println(retval);
		}
	}
}
