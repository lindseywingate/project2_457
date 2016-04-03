/*This code was written by Lindsey Wingate*/
import java.util.*;
import java.io.*;

class Program3_LW
{
	public static void main (String[] args) throws IOException	
	{
		if(args.length == 0) {
			System.out.println("Please enter a file to read from when you run the program.");
			System.exit(0);	
		}

		File file = new File(args[0]);
		String line;
					
		FileInputStream streamer = new FileInputStream(file);	
		BufferedReader br = new BufferedReader (new InputStreamReader(streamer));
		ArrayList<String> tokens = new ArrayList<String>();	
		ArrayList<String> content = new ArrayList<String>();

		//read token and lexeme, split into lists
		while ((line = br.readLine()) !=null) {	
			String line_str = new String(line);
			String[] parts = line.split(" ");
			for(int i=0; i<parts.length-1; i++) {
				//System.out.println("array: "+parts[i]);
				tokens.add(parts[0]);
				content.add(parts[1]);	
			}
		}
		//compare tokens and lexemes to verify accuracy
		//if accurate and no errors, add lexeme to list 
		String error;
		for(int b=0; b<tokens.size(); b++) {
			
			if(tokens.get(b) == "<read>,")	{
				if(content.get(0) != "read") {
					error = "read";	
					send_error(error);
					break;
				}
			}
			if(tokens.get(b) == "<id>,"){
				//if(content.get(0).isalpha()) {
					error = "read";	
					send_error(error);
					break;
				}
			if(tokens.get(b) == "<number>,")	{
				try{
					Long.parseLong(content.get(b));
					}
				catch (Exception e) {
					error="number";
					send_error(error);
				}
				break;
			}

			if(tokens.get(b) == "<write>,") {
				if(content.get(b) != "write") {
					error = "write";
					send_error(error);
					break;	
				}	
			}
			if(tokens.get(b) == "<lparen>,") {
				if(content.get(b) != "(") {
					error="(";
					send_error(error);
					break;
				}	
			}
			if(tokens.get(b)=="<rparen>,") {
				if(content.get(b) != ")") {
					error=")";
					send_error(error);
					break;
				}	
			}
			if(tokens.get(b)=="<add_op>,") {
				if(content.get(b) != "+" || content.get(b) != "-") {
					error="+/-";
					send_error(error);
					break;
				}	
			}
			if(tokens.get(b)=="<mult_op>,") {
				if(content.get(b) != "*" || content.get(b) != "/" || content.get(b) != "//" || content.get(b) != "%") {
					error="*/%//";
					send_error(error);
					break;
				}	
			}
			if(tokens.get(b)=="<assign>,") {
				if(content.get(b) != ":=") {
					error="*/%//";
					send_error(error);
					break;
				}	
			}
		}		
	}
	public static void send_error(String error)
	{
		System.out.println("Error: There is an error with "+error);
	}
}
