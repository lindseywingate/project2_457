public class invalidSocialException extends Exception
{
	public String message()
	{
		return "Invalid entry for SSN. Please enter your social with 6 digits or more";
	}
}
