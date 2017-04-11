/**Node class creates a new node to be used in a linked list and to store data about the student and their score*/
public class Node	{
	
	//attributes
	private Student data;
	private Node next;

/*default constructor*/
	public Node()
	{
	
	}

	/*assigns student data to node*/
	public Node(Student input)
	{
		setData(input);
	}

	/*sets student data to input*/
	public void setData(Student input)
	{
		data = input;
	}

	/*sets node to new node created*/
	public void setNext(Node newNext)
	{
		next = newNext;
	}

	/*gets student data*/

	public Student getData()
	{
		return data;
	}

	/*gets node data*/
	public Node getNext()
	{
		return next;
	}
/*in charge of printing data in node*/
	public String toString()
	{
		String output = "";
		output = output + "Name: " + getData().getName() + "\tScore: " +getData().getScore();
		return output;
	}

}
