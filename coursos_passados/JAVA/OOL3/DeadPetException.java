/**Exception triggers if pets will not get along in the house
*/
public class DeadPetException extends Exception
{
     public String getMessage()
     {
          return "ERROR!!!  At least one of these pets will die if they are left alone!!!";
     }
}
