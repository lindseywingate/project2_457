public class SomeonesSettingPasswordsException extends Exception
{
	public String getMessage()
	{
		return "Someone is trying to set password without admin permission";
	}
}
