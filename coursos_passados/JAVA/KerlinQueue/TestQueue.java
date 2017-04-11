public class TestQueue
{
    public static void main (String[] args)
    {
	Node newNode = new Node();
	Household myHouse = new Household();
	myHouse.setName("MY HOUSE");
	newNode.setData(myHouse);
	myList.add(newNode);
	System.out.println(myList);
	//DELIMIATE DATA!!!!
	System.out.println("----------------");
	//Peek!
	System.out.println("Peeking:\n" + myList.peek());
	//DELIMIATE DATA!!!!
	System.out.println("----------------");

    }
}
