/** Exception occurs when household exceeds budget
*/
public class BudgetBrokenException extends Exception
{
     public String getMessage()
     {
          return "ERROR!!!  Adding this pet will cause household to deal with loan sharks!!!";
     }
}