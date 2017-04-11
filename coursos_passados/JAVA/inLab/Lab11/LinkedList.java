/**LinkedList creates a new linked list with the capacity to remove, add, search, and print node data.
*/
public class LinkedList
{
   Node front = null;
   int size = 0;

/*default constructor*/
    public LinkedList()
    {
    }

/*remove node*/
    public Node remove(String target)
    {
	//empty
	if (front == null)
	    {
		return null;
	    }
	//not in list 
	if (!(search(target)))
	    {
		return null;
	    }
	//Front
	if (front.getData().getName().equals(target))
	    {
		Node curr = front;
		front = front.getNext();
		curr.setNext(null);
		return curr;
	    }
	else
	    {

		Node curr = front;

		while (curr.getNext() != null && target.equals(curr.getNext().getData().getName()) == false)
		    {
			curr = curr.getNext();

		    }
		if (curr.getNext() == null)
		    {
			return null;
		    }
		else
		    {
			Node temp = curr.getNext().getNext();
			Node output = curr.getNext();
			curr.setNext(temp);
			output.setNext(null);
			return output;
		    }
	    }
    }

/*search for specific node*/
    public boolean search(String name)
    {
	boolean found = false;
	Node curr = front;
	//Run through list
	while (curr != null)
	    {
		if (name.equals(curr.getData().getName()))
		    return true;
		curr = curr.getNext();
	    }
	return found;
    }

/*add node*/
    public void add(Node newNode)
    {

	if (newNode == null)
	    return;

	if (front == null)
	    {
		front = newNode;
		return;
	    }

	Node curr = front;
	while (curr.getNext() != null)
	    {
		curr = curr.getNext();
	    }
	curr.setNext(newNode);
	
    }

/*user friendly format*/
    public String toString()
    {
	String output = "";
	Node curr = front;
	while (curr != null)
	    {
		output = output + curr.toString()+"\n";
		curr = curr.getNext();
	    }
	return output;
    }   

/*decides whether or not a node will be replaced after 5 students is reached*/
    public void switchNodes(Node replace)
    {
	System.out.println("TEST!");
	double score = -100;
	double diff1=0.0;
	double diff2=0.0;
	int count = 0;
	String searchName = "";

	if (replace == null)
		return;
	
	Node curr = front;
	
	if (curr != null)
	{
	System.out.println("TEST!");
		count++;
		if(count < 2)
		{
			System.out.println("TEST! count<2");
			if(replace.getData().getScore()>curr.getData().getScore())
			{
				System.out.println("TEST! count<2 22222");
				score = curr.getData().getScore();
				searchName = curr.getData().getName();
				diff1 = replace.getData().getScore()-curr.getData().getScore();
			}
		}		
		if(count >= 2)
		{
				System.out.println("TEST! count>=2");
			if(replace.getData().getScore()>curr.getData().getScore())
			{
				diff2 = replace.getData().getScore()-curr.getData().getScore();
				System.out.println(diff1+diff2);
				if(diff2>diff1)
				{	
					searchName = curr.getData().getName();	
				}
			}		
		}
		else
		{

		}
		curr = curr.getNext();	
	}
	if(score!=-100)
		{
			remove(searchName);
			add(replace);
		}
    }
}
