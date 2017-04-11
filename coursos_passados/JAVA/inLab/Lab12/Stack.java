/**stack for storing mathematical data*/
public class Stack extends LinkedList
{
/*default constructor*/
	public Stack()
	{

	}
/*takes a node out*/
	public Node pop()
	{
		if(front==null)
		return null;
	
		else
		{
			Node curr = front;
			front = front.getNext();
			curr.setNext(null);
			return curr;
		}
	}
/*overrides linkedlist remove method*/
	public Node remove(String input)
	{
		return pop();
	}
/*overrides linkedlist add method*/
	public void add(Node newNode)
	{
		push(newNode);
	}
/*adds a new node*/
	public boolean push(Node nodster)
	{
		if (nodster == null)
			return false;
		nodster.setNext(front);
		front = nodster;
		return true;
	}
/*allows the user to see the top node information*/
	public String peek()
	{
		if (front == null)
		{
			return null;
		}
		else
		{	
			return front.getData();	
		}
	}
/*search for node in stack*/
	public boolean search(String target)
	{
		boolean found = false;
		Node curr = front;
		//Run through list
		while (curr != null)
		{
			if (target.equals(curr.getData()))
				return true;
			curr = curr.getNext();
		}
		return found;
	}
/*prints node data*/
	public String toString()
	{
		String output = "----TOP----\n";
		output += super.toString();
		output += "----BOTTOM----\n";
		return output;
	}
	
}
