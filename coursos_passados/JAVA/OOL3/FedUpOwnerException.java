/**Exception triggers if owner cannot handle the pets inserted in the household
*/
public class FedUpOwnerException extends Exception
{
     public String getMessage()
     {
          return "ERROR!!!  Adding this pet will cause owner become deranged and go crazy!!!";
     }
}
