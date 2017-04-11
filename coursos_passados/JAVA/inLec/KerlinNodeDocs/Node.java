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

    public void setNext(Node newNext)
    {
	next = newNext;
    }

    public Household getData()
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
