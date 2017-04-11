/**
 * The TowerEmptyException exception should be thrown anytime someone tries to remove a disk from an empty Tower.
 * @author Scott Kerlin
 * @version Oct 4, 2013
 */
public class TowerEmptyException extends Exception
{
     public TowerEmptyException()
     {
          super("EXCEPTION -- TOWER IS EMPTY");
     }
     
}
