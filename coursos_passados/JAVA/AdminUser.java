//Extends brings in all the methods and attributes of the parent!
public class AdminUser extends User
{
     /**
 * The AdminUser class is an object class for storing Admin User information
 * <br><br>
 * @author Scott D. Kerlin
 * @version 2.0
 * @since 2/23/15
 */
    private boolean onDuty = false;
    
     /**
      * Default Constructor
      * <br><br>
      * Builds a default AdminUser with set default values
      */ 
    public AdminUser()
    {
         //I give default value to attributes when I declare them.
         super();
    }
    
         /**
      * Full Parameter Constructor
      * <br><br>
      * Builds an AdminUser with all values set per requested.  Also error checks integers
      * @param u: username
      * @param p: password
      * @param g: group number
      * @param r: real name
      * @param o: office number
      * @param d: on duty status
      */ 
    public AdminUser(String u, String p, int g, String r, int o, boolean d)
    {
        super(u,p,g,r,o);
        onDuty = d;
 
    }

    /**
      * getOnDuty
      * <br><br>
      * Returns the on duty status of the Admin
      * @return true on duty, false otherwise
      */ 
    public boolean getOnDuty()
    {
         return onDuty;
    }
    /**
      * changeOnDuty
      * <br><br>
      * Toggles the on duty status of the Admin, requires that another admin makes the change!
      * @param a: Admin authorizing the duty change
      */
    public void changeOnDuty(AdminUser a)
    {
         if (!(a.getUserName().equals(getUserName())) && a.getOnDuty())
              onDuty = !onDuty;
    }

    /**
      * changePassword
      * <br><br>
      * Changes a User's password
      * @param targetUser: The user to change the password of
      * @param username: The supplied username, used to verify the person making the request is the User
      * @param password: The supplied password, used to verify the person making the request is the User
      * @newPassword: The new password for the User
      * @return true if set was succesful, false otherwise
      */
    public boolean changePassword(User targetUser, String username, String password, String newPassword)
    {
         if(password.equals(targetUser.getPassword()) && username.equals(targetUser.getUserName()))
         {
              targetUser.setPassword(newPassword, this);
              return true;
         }
         return false;
    }

         /**
      * toString()
      * <br><br>
      * Returns the AdminUser's information
      * @return an String containing the AdminUser's information
      */ 
    public String toString()
    {
         String output = super.toString();
         output = output + "\tOn Duty Status: " + getOnDuty();
         return output;
    }


     /**
      * toString()
      * <br><br>
      * Returns the AdminUser's information
      * @param p AdminUser's Password
      * @return an String containing the AdminUser's information
      */ 
     public String toString(String p)
     {
          if (getPassword(p).equals(p))
               return super.toString(p) + "\tOn Duty Status: " + getOnDuty();
          else
               return toString();
     } 


}










