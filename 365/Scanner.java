/*This code was written by Lindsey Wingate*/
import java.util.*;
import java.io.*;
import java.unix.regex;
class Scanner
{
	public static void main (String[] args) throws IOException
	{

		File file = new File(args[0]);
		
		FileInputStream streamer = new FileInputStream(file);	
		BufferedReader br = new BufferedReader (new InputStreamReader(streamer));

		String line = null;
		
		while ((line = br.readLine()) !=null) {
			System.out.println(line);
			
	
		} 
		br.close();
	}	
	/*	<id> can be a-z or A-Z followed by a-z, A-Z, 0-9;
		<number> can be int or float
		<lparen> = (
		<rparen> = )
		<add_op> = + or -
		<mult_op> = *, /, //, or %
		<assign> = :=
		reserved words are <read> and <write>
		<error> text that is not a valid token - stop processing input file
			
		for line:
			find token
			find lexeme
			print token, lexeme (ex: <read>, read
									 <id>, a)
		
		Scanner output = list
	*/
}





/*This code is written by Lindsey Wingate*/
