/** Exception thrown if pet owner does not have enough time to care for the pet.
*/
public class OwnerExhaustionException extends Exception
{
     public String getMessage()
     {
          return "ERROR!!!  Adding this pet will cause owner to die of exhaustion!!!";
     }
}
