public class TestUser
{
     public static void main(String[] args)
     {
          User u1 = new User();
          System.out.println("Default User:");
          System.out.println(u1);
          u1.setUsername("skerlin");

	try
	{
		u1.setPassword("skerlinpassword");
	}
	catch(SomeonesSettingPasswordsException e)
	{
		System.out.println("Something went wrong.");
		System.out.println(e.getMessage());
	}

	//catch(PasswordTooShortException e) ex.

	catch(Exception e) //ex.
	{
		System.out.println("Some other bad thing");
	}

          u1.setGroup(1);
          u1.setRealName("Scott Kerlin");
          u1.setOfficeNumber(100);
          System.out.println("--------");
          System.out.println("Manually added stuff to default user:");
          System.out.println(u1.toString("skerlinpassword"));
          
	User u2 = new User();
	try{
		u2 = new User("hammer", "nails", -10, "Mr. Nail Gun", -11);
	}
	catch(SomeonesSettingPasswordsException e)
	{
		System.out.println("Something went wrong.");
		System.out.println(e.getMessage());
	}
	catch(Exception e) //ex.
	{
		System.out.println("Some other bad thing");
	}
          
          System.out.println("--------");
          System.out.println("New user with parameters");
          System.out.println(u2);
          System.out.println("-------");
          System.out.println("The User 1 and User 2 are the same person == " + u1.equals(u2));
          
          System.out.println("-------");

	User u3 = new User();
	try
	{
		u3 = new User("hammer", "nails", -10, "Mr. Nail Gun", -11);
	}
	catch(SomeonesSettingPasswordsException e)
	{
		System.out.println("Something went wrong.");
		System.out.println(e.getMessage());
	}
	catch(Exception e) //ex.
	{
		System.out.println("Some other bad thing");
	}
          System.out.println(u3);
          System.out.println("-------");
          System.out.println("The User 2 and User 3 are the same person == " + u2.equals(u3));
          
          System.out.println("-------");
          AdminUser a1 = new AdminUser("mrdude", "iamyourleader", 1, "The Admin Dude", 2542,true);
          System.out.println(a1);
          System.out.println("-------");
          
          a1.changeOnDuty(a1);
          System.out.println(a1);
          System.out.println("-------");
          
          AdminUser a2 = new AdminUser("iserious", "adminpassword", 1, "Ike Serious", 2543, true);
          System.out.println(a1);
          System.out.println("-------");

          a1.changeOnDuty(a2);
          System.out.println(a1);
          System.out.println("-------");        

	User[] users = new User[5];
	users[0] = u1;
	users[1] = u2;
	users[2] = u3;
	users[3] = a1;
	users[4] = a2;

	if ( users[2] instanceof AdminUser)
		System.out.println(((AdminUser) users[2]).getOnDuty());
//polymorph = putting adminusers in user array because CHILD user. 
//polmorph - explicit cast because .getOnDuty is in AdminUser. Take item out of index 3, label as AdminUser and get access
//to getOnDuty()
	else
		System.out.println("The User in box 2 is NOT an Admin");
     }
}
