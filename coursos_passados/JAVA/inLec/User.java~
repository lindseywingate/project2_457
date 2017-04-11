import java.util.*;
/**
 * The User class is an object class for storing user information
 * <br><br>
 * @author Scott D. Kerlin
 * @version 2.0
 * @since 2/23/15
 */
public class User
{
     private static ArrayList<String> listOfUsernames = new ArrayList<String>();
     private String username = "";//protected usable in child class, still hidden from world
     private boolean usernameSet = false;
     private String password= "";
     private boolean passwordSet = false;
     private int group = Integer.MAX_VALUE;
     private String realName = "";
     private boolean realNameSet = false;
     private int officeNumber =-1;
         
     
     /**
      * Default Constructor
      * <br><br>
      * Builds a default User with set default values
      */ 
     public User()
     {
          //Not doing anything here as I have defaults listed above for each of the User attributes!
     }
     
     /**
      * Full Parameter Constructor
      * <br><br>
      * Builds a default User with all values set per requested.  Also error checks integers
      * @param u: username
      * @param p: password
      * @param g: group number
      * @param r: real name
      * @param o: office number
      */ 
     public User(String u, String p, int g, String r, int o)
     {
          setUsername(u);
          setPassword(p);
          setGroup(g);
          setRealName(r);
          setOfficeNumber(o);
     }
     
     /**
      * setUsername
      * <br><br>
      * Sets the username of the User.  Can only be done once!
      * @param u: username
      * @return true if set was succesful, false otherwise
      */ 
     public boolean setUsername(String u)
     {
          if (usernameSet || inUsernameList(u))
               return false;
          username = u;
          usernameSet = true;
          listOfUsernames.add(u);
          return true;
     }
     
     /**
      * inUsernameList()
      * <br><br>
      * Checks for inputted username in the username list
      * @param u: username to look for
      * @return true if set was succesful, false otherwise
      */ 
     public boolean inUsernameList(String u)
     {
          for(String name : listOfUsernames)
          {
               if (name.equals(u))
                       return true;
          }
          return false;
     }


     /**
      * setPassword
      * <br><br>
      * Sets the password.  Can only be done once!
      * @param p: password
      * @return true if set was succesful, false otherwise
      */ 
     public boolean setPassword(String p)
     {
          if (passwordSet)
               return false;
          password = p;
          passwordSet = true;
          return true;
     }     

	
	protected boolean setPassword(String p, AdminUser a)
	{
		if(a.getOnDuty())
		{
			password = p;
			return true;
		}
		else
		return false;
	}
    
     /**
      * setRealName
      * <br><br>
      * Sets the User's Real Name  Can only be done once!
      * @param r: Real Name
      * @return true if set was succesful, false otherwise
      */ 
     public boolean setRealName(String r)
     {
          if (realNameSet)
               return false;
          realName = r;
          realNameSet = true;
          return true;
     }     

     /**
      * setGroup
      * <br><br>
      * Sets the User's group  Can only be done once!
      * @param g: User's Group
      * @return true if set was succesful, false otherwise
      */ 
     public boolean setGroup(int g)
     {
          if (group != Integer.MAX_VALUE || g < 1)
               return false;
          
          group = g;
          return true;
     }       
     
     /**
      * setOfficeNumber
      * <br><br>
      * Sets the User's office number
      * @param o: User's office number
      * @return true if set was succesful, false otherwise
      */ 
     public boolean setOfficeNumber(int o)
     {
          if (o < 1)
               return false;
          
          officeNumber = o;
          return true;
     }
	public boolean setOfficeNumber(int o, MinionUser a)
	{
		if (o<1)
			return false;
		officeNumber = o;
		return true;
	}
     
     /**
      * getUserName()
      * <br><br>
      * Returns the User's username
      * @return a String containing the User's Username
      */ 
     public String getUserName()
     {
          return username;
     }   
     
     /**
      * getPassword()
      * <br><br>
      * Returns the User's password, only allowed if request is made by the user
      * @param p (user's password)
      * @return a String containing the User's Username
      */ 
     public String getPassword(String p)
     {
          if (password.equals(p))
               return password;
          return getPassword();
     }   
     /**
      * getPassword()
      * <br><br>
      * Returns the User's password, only allowed if request is made by the user
      * @return a String containing the User's Username
      */ 
     public String getPassword()
     {
          return "You can't look at someone else's password!";
     }   


     
     /**
      * getRealName()
      * <br><br>
      * Returns the User's Real Name
      * @return a String containing the User's Real Name
      */ 
     public String getRealName()
     {
          return realName;
     }   

     
     /**
      * getGroup()
      * <br><br>
      * Returns the User's group
      * @return an int containing the User's Group
      */ 
     public int getGroup()
     {
          return group;
     }   

     
     /**
      * getOfficeNumber()
      * <br><br>
      * Returns the User's office number
      * @return an int containing the User's office number
      */ 
     public int getOfficeNumber()
     {
          return officeNumber;
     }   
     
     /**
      * toString()
      * <br><br>
      * Returns the User's information
      * @return an String containing the User's information
      */ 
     public String toString()
     {
          return getRealName() + "\n\tUsername:\t" + getUserName() + "\n\tPassword:\t" + getPassword() + "\n\tGroup:\t" + getGroup() + "\n\tOffice Number:\t" + getOfficeNumber() + "\n";
     
     }   
     
     /**
      * toString()
      * <br><br>
      * Returns the User's information
      * @param p User's Password
      * @return an String containing the User's information
      */ 
     public String toString(String p)
     {
          if (password.equals(p))
               return getRealName() + "\n\tUsername:\t" + getUserName() + "\n\tPassword:\t" + getPassword(p) + "\n\tGroup:\t" + getGroup() + "\n\tOffice Number:\t" + getOfficeNumber() + "\n";
          else
               return toString();
     }  
     
     /**
      * equals()
      * <br><br>
      * Checks two users to see if they are the same user
      * @param otherUser the user to check against
      * @return a true if both users have the same UserName, false otherwise
      */ 
     public boolean equals(User otherUser)
     {
          if (username.equals(otherUser.getUserName()))
               return true;
          return false;
     } 

}
