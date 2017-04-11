public class Node
{
    //Attributes
    private int data = null;
    private Node next = null;

    //Methods
    public Node()
    {
	
    }

    public Node(int input)
    {
	setData(input);
    }

    public void setData(int input)
    {
	data = input;
    }

    public void setNext(Node newNext)
    {
	next = newNext;
    }

    public int getData()
    {
	return data;
    }

    public Node getNext()
    {
	return next;
    }

    public String toString()
    {
	String output = "";
	output = output + getData();
	return output;
    }


}
