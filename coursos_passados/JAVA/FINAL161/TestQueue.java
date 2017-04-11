public class TestQueue
{
    public static void main (String[] args)
    {
	LinkedBlockingDeque sucks = new LinkedBlockingDeque();
	

	Node newNode = new Node();
	newNode.setData(1);
	sucks.addFirst(1);

	//not at capacity
	sucks.addLast(2);

	//at capacity
	sucks.addFirst(4);
	sucks.addLast(5);

	sucks.removeFront(1);
	sucks.removeBack(2);

	sucks.capacity();	
	
	
    }
}
