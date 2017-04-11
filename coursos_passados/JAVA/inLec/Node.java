public class Node
{
	//Attributes 
	private Household data = null;
	private Node next = null;

	//Methods
	public Node()
	{
	}

	public Node(Household input)
	{
		setData(input);
	}

	public void setData(Household input)
	{
		data = input;
	}

	public Household getData()
	{
	}

	public void setNext(Node newNext)
	{
		next = newNext;
	}

	public Node getNext()
	{
		return next;
	}
}
