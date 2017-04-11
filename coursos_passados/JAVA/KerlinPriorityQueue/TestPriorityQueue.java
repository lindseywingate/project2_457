public class TestPriorityQueue
{
    public static void main (String[] args)
    {
         PriorityQueue myList = new PriorityQueue();
         //Print our Linked List
         System.out.println(myList);
         //DELIMIATE DATA!!!!
         System.out.println("----------------");
         //Peek!
         System.out.println("Peeking:\n" + myList.peek());
         //DELIMIATE DATA!!!!
         System.out.println("----------------");


         Node newNode = new Node();
         Household myHouse = new Household();
         myHouse.setName("MY HOUSE");
         newNode.setData(myHouse);
         myList.enqueue(newNode, 1);
         System.out.println(myList);
         //DELIMIATE DATA!!!!
         System.out.println("----------------");
         //Peek!
         System.out.println("Peeking:\n" + myList.peek());
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
         myList.enqueue(newNode,1);
         System.out.println(myList);
         //DELIMIATE DATA!!!!
         System.out.println("----------------");
         myHouse = new Household();
         myHouse.setName("Bob's HOUSE");
         newNode = new Node();
         newNode.setData(myHouse);
         myList.enqueue(newNode, -1);
         System.out.println(myList);
         //DELIMIATE DATA!!!!
         System.out.println("----------------");
         myHouse = new Household();
         myHouse.setName("Ted's HOUSE");
         newNode = new Node();
         newNode.setData(myHouse);
         myList.enqueue(newNode, -1);
         System.out.println(myList);
         //DELIMIATE DATA!!!!
         System.out.println("----------------");

         myHouse = new Household();
         myHouse.setName("Bill's HOUSE");
         newNode = new Node();
         newNode.setData(myHouse);
         myList.add(newNode);
         System.out.println(myList);
         //DELIMIATE DATA!!!!
         System.out.println("----------------");
//Peek!
         System.out.println("Peeking:\n" + myList.peek());
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
         //Peek!
         System.out.println("Peeking:\n" + myList.peek());
         //DELIMIATE DATA!!!!
         System.out.println("----------------");
         

         //DELIMIATE DATA!!!!
         System.out.println("----------------");
         output = myList.remove("YOUR HOUSE");
         System.out.println("LIST:");
         System.out.println(myList);
         System.out.println("REMOVED:");
         System.out.println(output);
         //Peek!
         System.out.println("Peeking:\n" + myList.peek());
         //DELIMIATE DATA!!!!
         System.out.println("----------------");
         

         //DELIMIATE DATA!!!!
         System.out.println("----------------");
         output = myList.remove("THEIR HOUSE");
         System.out.println("LIST:");
         System.out.println(myList);
         System.out.println("REMOVED:");
         System.out.println(output);
         //Peek!
         System.out.println("Peeking:\n" + myList.peek());
         //DELIMIATE DATA!!!!
         System.out.println("----------------");
         
         
         myHouse = new Household();
         myHouse.setName("Sneaky HOUSE");
         newNode = new Node();
         newNode.setData(myHouse);
         myList.enqueue(newNode,1);
         System.out.println(myList);
         //DELIMIATE DATA!!!!
         System.out.println("----------------");
         //Peek!
         System.out.println("Peeking:\n" + myList.peek());
         //DELIMIATE DATA!!!!
         System.out.println("----------------");


         //DELIMIATE DATA!!!!
         System.out.println("----------------");
         output = myList.remove("MY HOUSE");
         System.out.println("LIST:");
         System.out.println(myList);
         System.out.println("REMOVED:");
         System.out.println(output);
         //Peek!
         System.out.println("Peeking:\n" + myList.peek());
         //DELIMIATE DATA!!!!
         System.out.println("----------------");
         

         //DELIMIATE DATA!!!!
         System.out.println("----------------");
         output = myList.remove("YOUR HOUSE");
         System.out.println("LIST:");
         System.out.println(myList);
         System.out.println("REMOVED:");
         System.out.println(output);
         //Peek!
         System.out.println("Peeking:\n" + myList.peek());
         //DELIMIATE DATA!!!!
         System.out.println("----------------");
         




    }
}
