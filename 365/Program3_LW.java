/*This code was written by Lindsey Wingate*/
import java.util.*;
import java.io.*;

class Program3_LW
{
//	public static ArrayList cutdown(ArrayList<String>orderme, int index)
//	{	
			
//	}
	public static int parenthesis(ArrayList<String>orderme, int index)
	{
		int m=index;
		for(m=index; m<orderme.size(); m++) {
			if(orderme.get(m).equals(")"))
				return m-1;
			else
				continue;	
		}
		return 5;
	}
	public static void send_error(String error)
	{
		System.out.println("Error: There is an error with "+error);
	}
	public static boolean is_num(String num)
	{
		int len;
		len = num.length();
		for(int i = 0; i<len; i++) {
			if(!(Character.isDigit(num.charAt(i)))) {
				return false;
			}
		}
		return true;
	}
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
			String[] parts = line.split(", ");
			for(int i=0; i<parts.length-1; i++) {
				//System.out.println("array: "+parts[i]);
				tokens.add(parts[0].trim());
				content.add(parts[1].trim());	
			}
		}
		ArrayList<String> orderme = new ArrayList<String>();
		//compare tokens and lexemes to verify accuracy
		//if accurate and no errors, add lexeme to list 
		String error;
		for(int b=0; b<tokens.size(); b++) {
			if(tokens.get(b).equals("<read>")) {
				if(!(content.get(b).equals("read"))) {
					send_error("read");
					break;
				}
				else
					orderme.add(content.get(b));
					continue;
			}

			if(tokens.get(b).equals("<write>")) {
				if(content.get(b) != "write") {
					error = "write";
					send_error(error);
					break;	
				}
				else
					orderme.add(content.get(b));
					continue;	
			}

			if(tokens.get(b).equals("<error>")) {
				send_error("token error");
				break;
			}

			if(tokens.get(b).equals("<id>")) { 
				orderme.add("id");
				continue;
			}

			if(tokens.get(b).equals("<assign>")) {
				if(!content.get(b).equals(":=")) {
					send_error(":=");
					break;
				}
				else
					orderme.add(content.get(b));
					continue;	
			}

			if(tokens.get(b).equals("<lparen>")) {
				if(!(content.get(b).equals("("))) {
					send_error("(");
					break;
				}
				else
					orderme.add(content.get(b));
					continue;	
			}

			if(tokens.get(b).equals("<number>")) {
				orderme.add(content.get(b));
				continue;
			}

			if(tokens.get(b).equals("<rparen>")) {
				if(!(content.get(b).equals(")"))) {
					send_error(")");
					break;
				}
				else
					orderme.add(content.get(b));
					continue;	
			}

			if(tokens.get(b).equals("<add_op>")) {
				if(!(content.get(b).equals("+") || content.get(b).equals("-"))) {
					send_error("+/-");
					break;
				}
				else
					orderme.add(content.get(b));
					continue;	
			}

			if(tokens.get(b).equals("<mult_op>")) {
				if((content.get(b).equals("*")) || (content.get(b).equals("/")) || (content.get(b).equals("//")) || (content.get(b).equals("%"))) {
					orderme.add(content.get(b));
					continue;	
				}
				else
					send_error("mult_op");
					break;
			}
		}
		
		int x = orderme.size();
		int m = 0;
		int deleteme = 0;

		//looks for id and assign combo
		for(int test=0; test<orderme.size(); test++)
		{		
			if(orderme.get(test).equals("id"))
				if(orderme.get(test+1).equals(":=")) {
					orderme.remove(test);
					orderme.remove(test);
			}	
		}

		//looks for read/id and write/id combo
		for(int test2=0; test2<orderme.size(); test2++)
		{
			if((orderme.get(test2).equals("read"))||(orderme.get(test2).equals("write"))) {
				orderme.remove(test2);
				orderme.remove(test2);
			}
		}

		for(int test3=0; test3<orderme.size(); test3++)
		{		
			if(orderme.get(test3).equals("(")) {
				orderme.remove(test3);
				int p=test3;
				while((orderme.get(p).equals(")"))==false) {
					if(orderme.get(p).equals(")")==false) {
						orderme.remove(p);	
					}
					if(orderme.get(p).equals(")")) {
						orderme.remove(p);
						break;
					}
				}
			}			
		}	
	
	if(orderme.size()>0)
		System.out.println("Helpful Java Message: The following characters were misplaced. Please rethink your program.");
		for(int i=0; i<orderme.size(); i++)
			System.out.println(orderme.get(i));	
	if(orderme.size()==0)
		System.out.println("Your program should work. Good luck.");	

	}
}
