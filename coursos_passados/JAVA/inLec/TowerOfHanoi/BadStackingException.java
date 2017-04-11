/**
 * The BadStackingException exception should be thrown anytime someone tries to put a larger disk on top of smaller disk.
 * @author Scott Kerlin
 * @version Oct 4, 2013
 */
public class BadStackingException extends Exception
{
     public BadStackingException()
     {
          super("EXCEPTION -- LARGE DISKS CANNONT STACK ON SMALLER DISKS");
     }
     
}
