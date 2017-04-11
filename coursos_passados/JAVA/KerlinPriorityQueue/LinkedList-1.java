public class LinkedList
{
    Node front = null;

    public LinkedList()
    {
    }
   
    public boolean isEmpty()
    {
         if (front == null)
              return true;
         return false;
    }
    
    public Object max()
    {
         Node curr = front;
         Node max = curr;
         //Run through list
         while (curr != null)
         {
              if (max.getData().compareTo(curr.getData()) < 0)
                   max = curr;
              curr = curr.getNext();
         }
         if (max == null)
              return null;
         return max.getData();
    }
    
    public Node remove(Object target)
    {
         //empty
         if (front == null)
         {
              return null;
         }
         //Not in the list 
         if (!(search(target)))
         {
              return null;
         }
         //Front
         if (front.getData().equals(target) || (front.getData() instanceof Household && ((Household) front.getData()).getName().equals(target)))
         {
              Node curr = front;
              front = front.getNext();
              curr.setNext(null);
              return curr;
         }
         else
         {
              //Somewhere in the middle or end
              Node curr = front;
              //System.out.println(curr);
              while (curr.getNext() != null && (target.equals(curr.getNext().getData()) == false || (target instanceof Household && target.equals(((Household) curr.getNext().getData()).getName()) == false)))
              {
                   curr = curr.getNext();
                   //System.out.println(curr);
              }
              //1 of 2 things true....Either curr is before our target's node OR curr is before null
              if (curr.getNext() == null)
              {
                   return null;
              }
              else
              {
                   Node temp = curr.getNext().getNext();
                   Node output = curr.getNext();
                   curr.setNext(temp);
                   output.setNext(null);
                   return output;
              }
  
         }


    }

    protected Object get(Object target)
    {
         Node curr = front;
         //Run through list
         while (curr != null)
         {
              if (target.equals(curr.getData()))
                   return curr.getData();
              curr = curr.getNext();
         }
         return null;  //Nothing to get

    }
    
    public boolean search(Object target)
    {
         boolean found = false;
         Node curr = front;
         //Run through list
         while (curr != null)
         {
              if (target instanceof Household)
              {
                   if (target.equals(((Household) curr.getData()).getName()))
                        return true;
              }
              else
              {
                   if (target.equals(curr.getData()))
                        return true;
              }
              curr = curr.getNext();
         }
         return found;
 
    }

    public void add(Node newNode)
    {
         //Put at END!!!!
         
         //They gave us a null!!!
         if (newNode == null)
              return;

         //Empty List?
         if (front == null)
         {
              front = newNode;
              return;
         }

         //At this point, we know that there is
         //Something in the list
 
         //So....Is there something else in the list?
         //Are we at the end?
         Node curr = front;
         while (curr.getNext() != null)
         {
              curr = curr.getNext();
         }
         //Curr now points to the last non-null
         //So set Curr's next to the new node
         curr.setNext(newNode);
     
    }

    public String toString()
    {
         String output = "";
         Node curr = front;
         while (curr != null)
         {
              output = output + curr+ "\n";
              curr = curr.getNext();
              //System.out.println(curr);
         }
         return output;
    }
    
}
