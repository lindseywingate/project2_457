public class MinionUser extends User
{
	private boolean onDuty = false; //on duty?
	
	public MinionUser()
	{
		super();
	}

	public MinionUser(String u, String p, int g, String r, int o, boolean d)
	{
		super(u,p,g,r,o);//make parent do work- already has information
		//super must be called first to bring in variables
		onDuty = d;

	}
	public boolean getOnDuty()
	{
		return onDuty;
	}
	
	public boolean changeOfficeNumber(User targetUser, String username, String password, int newOfficeNumber)//checks username and password first and new office number
	{
		if(password.equals(targetUser.getPassword()) && username.equals(targetUser.getUserName()))
		{
			targetUser.setOfficeNumber(newOfficeNumber,this);
			return true;
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
