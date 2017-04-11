java.util.*;

public class LinkedBlockingDeque extends BlockingQueue
{
    	Node back = null;
	Node front = null;
	
  	public LinkedBlockingDeque()
	{
	}

  	public Node addFirst(Node addMe)
	{
		if (addMe == null)
			return;
		if (front == null)
		{		
			front = addMe;
			back = addMe;
		}		
		else
		{
			front.setNext(newNode);
			front = newNode;			
		}
			
	}

	public Node addLast(Node addMe)
	{
		if(addMe == null)
			return;
		if (back == null)
		{
			front = addMe;
			back = addMe;
		}
		if (back != null)
		{
			back.setNext(newNode);
			back = newNode;
		}
	}

	public Node removeFirst(Node removeMe)
	{
		if(removeMe = null)
			return;
		if(front == null)
			return;
		else
		{
			Node curr = front;
			front = front.getNext();
			curr.setNext(null);
			if (curr = front)
				front = null;
			return curr;
		}
	}

	public Node removeLast(Node removeMe)
	{
		if(removeMe = null)
			return;
		if(back == null)
			return;
		else
		{
			Node curr = back;
			back = back.getNext();
			curr.setNext(null);
			if (curr = back)
				front = null;
			return curr;
		}
	}

    public String toString()
    {
	String output = "------FRONT------\n";
	output += super.toString();
	output += "------BACK------\n";
	return output;
    }
    
}
