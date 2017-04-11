//Extends brings in all the methods and attributes of the parent!
public class AdminUser extends User
{
	private boolean onDuty = false; //can use to check if admin actually on duty
	
	public AdminUser()
	{
		//default values given to attributes when declared.
		super();
	}

	public AdminUser(String u, String p, int g, String r, int o, boolean d)
	{
		super(u,p,g,r,o);//make parent do work- already has information
		//super must be called first to bring in variables
		onDuty = d;

	}

	public boolean getOnDuty()
	{
		return onDuty;
	}

	public boolean changePassword(User targetUser, String username, String password, String newPassword)//bring in password and username so they can reset their password
	{
		if(password.equals(targetUser.getPassword()) && username.equals(targetUser.getUserName()))
		{
			targetUser.setPassword(newPassword,this);
			return true;
			//since password is private we can't directly change it in here;
			//setPassword will only let us set it once
		}
		return false;
	}
	public String toString()
	{
		//context sensative. different things in diff places
		String output = super.toString();
		output = output + "\tOn Duty Status: "+ getOnDuty();
		return output;
	}
}
