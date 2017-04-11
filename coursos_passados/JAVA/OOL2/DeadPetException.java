public class DeadPetException extends Exception
{
	public String getMessage()
	{
		return "The pet combination in the house will likely result in 1 or more dead pets";
	}
}
