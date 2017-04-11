public class Queue extends LinkedList
{
    //Handy to know where the back of the list is
    Node tail = null;

    public Queue()
    {
    }

    //Dequeue, always removes from FRONT of the Queue
    public Node dequeue()
    {
	//Empty or has data
	if (front == null)
	    return null;
	else
	    {
		//Save Data
		//Move Front
		//Sanitize Data
		//Check if tail needs updating
		//Return Data
		Node curr = front;
		front = front.getNext();
		curr.setNext(null);
		if (curr == tail)
		    tail = null;
		return curr;
	    }
    }

    public Node remove(String target)
    {
	//No remove, so just forwarding this to dequeue
	return dequeue();
    }

    //enqueue adds to back of Queue
    public void enqueue(Node newNode)
    {
	//We either are adding to an empty list or adding to the TAIL of the list
	if (front == null)
	    {
		front = newNode;
		tail = newNode;
	    }
	else
	    {
		//Link old tail to new node
		//Move tail to new node
		tail.setNext(newNode);
		tail = newNode;
	    }
    }

    //No add, so this is going to be forwarded to enqueue
    public void add(Node newNode)
    {
	enqueue(newNode);
    }

    //Peek at next item
    public Household peek()
    {
	//Either empty or there is a first element
	if (front == null)
	    return null;
	else
	    return front.getData();
    }

    public String toString()
    {
	String output = "------FRONT------\n";
	output += super.toString();
	output += "------BACK------\n";
	return output;
    }
    
}
