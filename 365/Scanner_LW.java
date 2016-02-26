/*This code was written by Lindsey Wingate*/
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Scanner_LW
{
	public static void main (String[] args) throws IOException
	{

		File file = new File(args[0]);
		
		FileInputStream streamer = new FileInputStream(file);	
		BufferedReader br = new BufferedReader (new InputStreamReader(streamer));

		String line = null;
		String read = "^read";	
		String write = "^write";
		String id = "^[a-zA-Z][a-zA-B0-9]*";
		String lparen = "^[(]";
		String rparen = "^[)]";
		String assign = "^[:][=]";
		String add_op = "^[+-]";	
		String mult_op = "^[\\*|/?|//?|%]";
		String number = "^[0-9]*[\\.]*[0-9]";
	
		Pattern r = Pattern.compile(read);
		Pattern s = Pattern.compile(write);
		Pattern c = Pattern.compile(id); 
		Pattern i = Pattern.compile(lparen);
		Pattern j = Pattern.compile(rparen);
		Pattern a = Pattern.compile(assign);	
		Pattern k = Pattern.compile(add_op);
		Pattern l = Pattern.compile(mult_op);
		Pattern b = Pattern.compile(number);

		while ((line = br.readLine()) !=null) {
			line = line.trim();
			String change_me = new String(line);
			Matcher m = r.matcher(line);
			if(m.find( )) {
				System.out.println("<read>, read");		
				line = line.replace(m.group(0), "");
				line = line.trim();
			}
			Matcher n = s.matcher(line);
			if(n.find()) {
				System.out.println("<write>, write");
				line = line.replace(n.group(0), "");
				line = line.trim();
			}	
			Matcher p = i.matcher(line);
			if(p.find()) {
				System.out.println("<lparen>, " + p.group(0));
				int six = p.end();
				line = change_me.substring(six);
				line = line.trim();
			}	
			Matcher o = c.matcher(line);
			if(o.find()) {
				System.out.println("<id>, " + o.group(0));
				int seven = o.end();
				line = change_me.substring(seven);
				line = line.trim();
			}
			Matcher numbah = b.matcher(line);
			if(numbah.find()) {
				System.out.println("<number>, " + numbah.group(0));
				line = line.replace(numbah.group(0), "");
				line = line.trim();
			}
			Matcher x = a.matcher(line);
			if(x.find()) {
				System.out.println("<assign>, " + x.group(0));
				line = change_me.substring(5);
				line = line.trim();
				
				int count = line.length();
				while(count>0) {
					String change_me2 = new String(line);
					Matcher test = c.matcher(line);
					if(test.find()) {
						System.out.println("<id>, " + test.group(0));
						int hi = test.end();
						line = change_me2.substring(hi);		
						//System.out.println("CHECK: "+line);
						line = line.trim();
					}
					Matcher num2 = b.matcher(line);
					if(num2.find()) {
						System.out.println("<number>, " + num2.group(0));
						int hi2 = num2.end();
						line = change_me2.substring(hi2);
						//System.out.println("CHECK: "+line);
						line = line.trim();	
					}
					Matcher z = k.matcher(line);
					if(z.find()) {
						System.out.println("<add_op>, " + z.group(0));
						int hi3 = z.end();
						line = change_me2.substring(2);
						//System.out.println("CHECK: "+line);
						line = line.trim();	
					}
					Matcher y = l.matcher(line);
					if(y.find()) {
						System.out.println("<mult_op>, " + y.group(0));
						int hi4 = y.end();
						line = change_me2.substring(hi4+1);
						//System.out.println("CHECK: "+line);
						line = line.trim();
					}
					count--;
				}
				Matcher q = j.matcher(line);
				if(q.find()) {
					System.out.println("<rparen>, " + q.group(0));
					line = line.replace(q.group(0), "");
					line = line.trim();
				}
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
	/*	Matcher oper = op.matcher(line);
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
					}*/

}
/*This code is written by Lindsey Wingate*/
