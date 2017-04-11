import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegEx
{
	public static void main (String[] args)
	{
		String letter = "[a-zA-Z]";
		String digit = "[0-9]";
		String name = "Lindsey";
		String number = "1234";

		String fullName1 = "Lindsey Wingate";
		String fullName2 = "Lindsey Wingate";
		String fullName3 = "Wingate, Lindsey";

		System.out.println("Does "+ name + "contain a letter? " + name.matches(letter));
		System.out.println("Is "+ name + "all text? " + name.matches(letter + "+"));
		System.out.println("Is "+ number + "all digits? " + number.matches("\\d+"));
	}

}
