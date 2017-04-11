public class PriorityQueue extends LinkedList
{
     //Need a linked list to store my different queues!
     LinkedList myQueues = new LinkedList();

    public PriorityQueue()
    {
    }

    //Dequeue, always removes from FRONT of the Queue
    public Node dequeue()
    {
         //Find the highest priority, non-empty queue
         Queue maxQ = (Queue) myQueues.max();
         if (maxQ == null)
              return null;
         
         //Dequeue the highest priority, non-empty queue
         Node output = maxQ.dequeue();
         
         //Check if that queue is now empty.
         //If empty, need to remove that queue from the linked list
         if (maxQ.isEmpty())
         {
              myQueues.remove(maxQ);
         }
         
         //Return dequeued node
         return output;
    }

    public Node remove(String target)
    {
         //No remove, so just forwarding this to dequeue
         return dequeue();
    }

    //enqueue adds to back of the correct Queue
    public void enqueue(Node newNode, int priority)
    {
         //Locate the queue that matches the priority
         Queue newQ = new Queue(priority);
         Queue currQ = (Queue) myQueues.get(newQ);
         
         //If null, we don't have a queue with the correct priority level at the moment.
         if (currQ == null)
         {
              //Add a Queue with the correct priority
              myQueues.add(new Node(newQ));
              //Try the enqueue again!
              currQ = newQ;
              
         }
         //Enqueue the node to the current queue
         currQ.enqueue(newNode);
         
              

    }

    //No add, so this is going to be forwarded to enqueue
    public void add(Node newNode)
    {
         //Assume priority of zero
         enqueue(newNode, 0);
    }

    //Peek at next item
    public Household peek()
    {
         //Find the highest priority, non-empty queue
         Queue maxQ = (Queue) myQueues.max();
         if (maxQ == null)
              return null;
         return maxQ.peek();
    }

    public String toString()
    {
         String output = "";
         output += myQueues;
         return output;
    }
    
}
