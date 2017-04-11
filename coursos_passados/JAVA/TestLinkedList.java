public class TestLinkedList
{
    public static void main (String[] args)
    {
	LinkedList myList = new LinkedList();
	//Print our Linked List
	System.out.println(myList);
	//DELIMIATE DATA!!!!
	System.out.println("----------------");

	Node newNode = new Node();
	Household myHouse = new Household();
	myHouse.setName("MY HOUSE");
	newNode.setData(myHouse);
	myList.add(newNode);
	System.out.println(myList);
	//DELIMIATE DATA!!!!
	System.out.println("----------------");

	myHouse = new Household();
	myHouse.setName("YOUR HOUSE");
	newNode = new Node();
	newNode.setData(myHouse);
	myList.add(newNode);
	System.out.println(myList);
	//DELIMIATE DATA!!!!
	System.out.println("----------------");
	
	myHouse = new Household();
	myHouse.setName("THEIR HOUSE");
	newNode = new Node();
	newNode.setData(myHouse);
	myList.add(newNode);
	System.out.println(myList);
	//DELIMIATE DATA!!!!
	System.out.println("----------------");

	if (myList.search("YOUR HOUSE"))
	    {
		System.out.println("Found!!!");
	    }
	else
	    {
		System.out.println("NOT Found!!!");
	    }

	if (myList.search("TEDDY'S HOUSE"))
	    {
		System.out.println("Found!!!");
	    }
	else
	    {
		System.out.println("NOT Found!!!");
	    }

	//DELIMIATE DATA!!!!
	System.out.println("----------------");
	Node output = myList.remove("YOUR HOUSE");
	System.out.println("LIST:");
	System.out.println(myList);
	System.out.println("REMOVED:");
	System.out.println(output);

	//DELIMIATE DATA!!!!
	System.out.println("----------------");
	output = myList.remove("YOUR HOUSE");
	System.out.println("LIST:");
	System.out.println(myList);
	System.out.println("REMOVED:");
	System.out.println(output);

	//DELIMIATE DATA!!!!
	System.out.println("----------------");
	output = myList.remove("THEIR HOUSE");
	System.out.println("LIST:");
	System.out.println(myList);
	System.out.println("REMOVED:");
	System.out.println(output);

	//DELIMIATE DATA!!!!
	System.out.println("----------------");
	output = myList.remove("MY HOUSE");
	System.out.println("LIST:");
	System.out.println(myList);
	System.out.println("REMOVED:");
	System.out.println(output);

	//DELIMIATE DATA!!!!
	System.out.println("----------------");
	output = myList.remove("YOUR HOUSE");
	System.out.println("LIST:");
	System.out.println(myList);
	System.out.println("REMOVED:");
	System.out.println(output);




    }
}
