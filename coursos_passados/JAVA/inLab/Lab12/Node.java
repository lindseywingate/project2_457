/**Node creates a node to store string data to place in a stack*/
public class Node
{
	private String data;
	private Node next = null;
		/*default constructor*/
	public Node()
	{

	}
/*accepts data to store*/
	public Node(String userInput)
	{
		setData(userInput);
	}
/*sets data to store*/
	public void setData(String userInput)
	{
		data = userInput;
	}
/*sets next node*/
	public void setNext(Node newbs)
	{
		next = newbs;
	}
/*gets data if requested*/
	public String getData()
	{
		return data;
	}
/*gets next node*/
	public Node getNext()
	{
		return next;
	}
/*user friendly print data*/
	public String toString()
	{
		String output = "";
		output = output + getData();
		return output;
	}

}
