public class OwnerExhaustionException extends Exception
{
	public String getMessage()
	{
		return "Adding a pet would result in the household's care time to be negative."
	}
}
