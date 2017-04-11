public class Node
{
    //Attributes
    private Comparable data = null;
    private Node next = null;

    //Methods
    public Node()
    {
 
    }

    public Node(Comparable input)
    {
         setData(input);
    }

    public void setData(Comparable input)
    {
         data = input;
    }

    public void setNext(Node newNext)
    {
         next = newNext;
    }

    public Comparable getData()
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
