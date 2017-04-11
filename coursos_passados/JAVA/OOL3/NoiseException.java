/**Exception thrown if pets are too loud.
*/
public class NoiseException extends Exception
{
     public String getMessage()
     {
          return "ERROR!!!  Adding this pet will cause the police to write citations for noise violations!!!";
     }
}
