 /*This code was written by Lindsey Wingate*/
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Scanner
{
	public static void main (String[] args) throws IOException
	{

		File file = new File(args[0]);
		
		FileInputStream streamer = new FileInputStream(file);	
		BufferedReader br = new BufferedReader (new InputStreamReader(streamer));

		String line = null;
		String read = "read";	
		String write = "write";
		String id = "^[a-zA-Z][a-zA-z0-9]*";
		String lparen = "[(]";
		String rparen = "[)]";
		String assign = "[:][=]";
		String add_op = "^[+-]";	
		String mult_op = " ^[/*|//|///|/%]";
		String number = "^[0-9]*[\\.]*[0-9]";
		String operators = "^[+-/*|//|///|/%]";

		Pattern r = Pattern.compile(read);
		Pattern s = Pattern.compile(write);
		Pattern c = Pattern.compile(id); 
		Pattern i = Pattern.compile(lparen);
		Pattern j = Pattern.compile(rparen);
		Pattern a = Pattern.compile(assign);	
		Pattern k = Pattern.compile(add_op);
		Pattern l = Pattern.compile(mult_op);
		Pattern b = Pattern.compile(number);
		Pattern op = Pattern.compile(operators);

		while ((line = br.readLine()) !=null) {
			//System.out.println(line);
			Matcher m = r.matcher(line);
			if(m.find( )) {
				System.out.println("<read>, read");		
				line = line.replace("read", "");	
				line = line.trim();
			}
			Matcher n = s.matcher(line);
			if(n.find()) {
				System.out.println("<write>, write");
				line = line.replace("write", "");
				line = line.trim();
			}	
			Matcher p = i.matcher(line);
			if(p.find()) {
				System.out.println("<lparen>, " + p.group(0));
				line = line.replace("(", "");
				line = line.trim();
			}	
			Matcher o = c.matcher(line);
			if(o.find()) {
				System.out.println("<id>, " + o.group(0));
				line = line.replace(o.group(0), "");
				line = line.trim();
			}
			Matcher x = a.matcher(line);
			if(x.find()) {
				System.out.println("<assign>, " + x.group(0));
				line = line.replace(x.group(0), "");
				line = line.trim();
			}		
				Matcher oper = op.matcher(line);
				while(oper.find()) {
					System.out.println("TA DA! ");
					Matcher d = c.matcher(line);
					if(d.find()) {
						System.out.println("<id>, " + d.group(0));
						line = line.replace(d.group(0), "");
						line = line.trim();
					}
					Matcher add = k.matcher(line);
					if(add.find()) {
						System.out.println("<add_op>, " + add.group(0));
						line = line.replace(add.group(0), "");
						line = line.trim();
					}
					Matcher num = b.matcher(line);
					if(num.find()) {
						System.out.println("<number>, " + num.group(0));
						line = line.replace(num.group(0), "");
						line = line.trim();
					}
					Matcher mult = l.matcher(line);
					if(mult.find()){
						System.out.println("<mult_op>, " + mult.group(0));
						line = line.replace(mult.group(0), "");
						line = line.trim();
					} 
			}
			Matcher id2 = c.matcher(line);
			if(id2.find()) {
				System.out.println("<id>, " + id2.group(0));
				line = line.replace(id2.group(0), "");
				line = line.trim();
			}
			Matcher num2 = b.matcher(line);
			if(num2.find()) {
				System.out.println("<number>, " + num2.group(0));
				line = line.replace(num2.group(0), "");
				line = line.trim();
			}
			
			Matcher z = k.matcher(line);
			if(z.find()) {
				System.out.println("<add_op>, " + z.group(0));
				line = line.replace(z.group(0), "");
				line = line.trim();
			}
			Matcher y = l.matcher(line);
			if(y.find()) {
				System.out.println("<mult_op>, " + y.group(0));
				line = line.replace(y.group(0), "");
				line = line.trim();
			}
			Matcher w = b.matcher(line);
			if(w.find()) {
				System.out.println("<number>, " + w.group(0));
				line = line.replace(w.group(0), "");
				line = line.trim();
			}
			Matcher q = j.matcher(line);
			if(q.find()) {
				System.out.println("<rparen>, " + q.group(0));
				line = line.replace(q.group(0), "");
				line = line.trim();
			}
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
