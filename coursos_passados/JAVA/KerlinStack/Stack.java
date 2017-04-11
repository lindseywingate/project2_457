public class Stack extends LinkedList
{

    public Stack()
    {
    }

    public Node pop()
    {
	//Stacks always pop from the top
	//So there is something to return, or nothing to return (if empty)
	if (front == null)
	    return null; //Emtpy
	else
	    {
		//Save old front
		//Reset front
		//Sanatize
		//return data
		Node curr = front;
		front = front.getNext();
		curr.setNext(null);
		return curr;
	    }
    }

    public Node remove(String target)
    {
	//Selected Removes don't exist in Stacks
	//Could leave this for removing data that was entered in error
	//But I'm just going to make this a call to "pop()" for testing.
	return pop();
    }

    public boolean search(String target)
    {
	boolean found = false;
	Node curr = front;
	//Run through list
	while (curr != null)
	    {
		if (target.equals(curr.getData().getName()))
		    return true;
		curr = curr.getNext();
	    }
	return found;
	
    }

    public void push(Node newNode)
    {
	//We push data onto the stack.
	//So, new data goes to front, not the back
	if (newNode == null)
	    return;//No input!!!

	//Full or empty, always add to the front
	//So make new node point to front, and move front
	newNode.setNext(front);
	front = newNode;
    }

    public void add(Node newNode)
    {
	//Add should just call push, so overriding "add()" with "push()"
	push(newNode);
    }

    //Peeks should always show the DATA at the top/front of the Stack
    //Not the node itself
    public Household peek()
    {
	//empty?
	if (front == null)
	    return null;
	else
	    return front.getData();
    }

    //Adding "Top" and "Bottom" to toString() to describe the data structure
    public String toString()
    {
	String output = "------TOP-------\n";
	output += super.toString();
	output += "------BOTTOM------\n";
	return output;
    }
    
}
