/**
 * The TowerFullException exception should be thrown anytime someone tries to add a disk to a full Tower.
 * @author Scott Kerlin
 * @version Oct 4, 2013
 */
public class TowerFullException extends Exception
{
     public TowerFullException()
     {
          super("EXCEPTION -- TOWER IS FULL");
     }
     
}
