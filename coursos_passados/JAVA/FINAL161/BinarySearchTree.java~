import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
   This class implements a binary search tree.
*/

public class BinarySearchTree
{    
     private class Node
    {
        int  value;          // Value stored in node
        Node left, right;    // Left and right child      
        
        /**
           Constructor for leaf nodes.
           @param val The value to store in the node.
        */
        
        Node(int val)
        {
            value = val;
            left = null;
            right = null;
        }   
        
        /** 
           Constructor for non-leaf nodes.
           @param val The value to initialize the node.
           @param leftChild The link to the left child.
           @param rightChild The link to the right child.
        */

        Node(int val, Node leftChild, Node rightChild)
        {
            value = val;
            left = leftChild;
            right = rightChild;
        }
    }
    
    /**
       The BTreeDisplay class graphically displays trees
       in a JPanel. The JPanel is recursively partitioned
       into a top part dislaying the root, and two lower 
       parts displaying the left and right subtrees.
    */
    
    private class BTreeDisplay extends JPanel
    {
        /**
           Constructor.
           @param tree The root of the binary 
			  tree to display.
        */
        
        BTreeDisplay(Node tree)
        {           
           setBorder(BorderFactory.createEtchedBorder());
           setLayout(new BorderLayout());
           if (tree != null) 
           {          
               String value = String.valueOf(tree.value);  
               int pos = SwingConstants.CENTER;
               JLabel rootLabel = new JLabel(value, pos);                         
               add(rootLabel, BorderLayout.NORTH);
               JPanel panel = new JPanel(new GridLayout(1, 2));
               panel.add(new BTreeDisplay(tree.left));
               panel.add(new BTreeDisplay(tree.right));    
               add(panel);
           }       
        }   
    }
   
    /**
       This class represents the result of 
       removing a node from a binary tree.
    */
    
    private class RemovalResult
    {
       Node node;    // Removed node
       Node tree;    // Remaining tree
       RemovalResult(Node node, Node tree)
       {
         this.node = node;
         this.tree = tree;
       }
    }

    private Node root = null;   // Root of binary tree    
   
   /**
      The getView method creates and returns a 
      a graphical view of the binary tree.
      @return A panel that displays a view of the tree.
    */

    public JPanel getView()
    {
       return new BTreeDisplay(root);       
    }    
    
    /**
       The public add method adds a value to the 
       tree by calling a private add method and 
       passing it the root of the tree.
       @param x The value to add to the tree.
       @return true.     
    */
    
    public boolean add(int x)
    {
        root =  add(x, root);
        return true;
    }
   
    /**
       The contains method checks to see if a 
       value is in the binary tree.
       @param x The value to check for.
       @return true if x is in the tree, 
		 false otherwise.
    */
    
    public boolean contains(int x)
    {
        // Call the private recursive method
        return contains(x, root);
    }
    
    /**
       The isEmpty method checks for an empty tree.
       @return true if the tree is empty, 
		 false otherwise.
    */
    
    public boolean isEmpty()
    {
        if (root == null)
            return true;
        else
            return false;
    }
   
    /**
       The add method adds a value to the search tree.
       @x the value to add.
       @param bstree The root of the binary 
		 search tree.
       @return The root of the resulting 
		 binary search tree.
    */  
    
    private Node add(int x, Node bstree)
    {
        if (bstree == null)
            return new Node(x);
        // bstree is not null. 
        if (x < bstree.value)
        {
            // Add x to the left subtree and replace 
            // the current left subtree with the result
            bstree.left = add(x, bstree.left);             
        }
        else
        {   
            // Add x to the right subtree
            bstree.right = add(x, bstree.right);
        }
        return bstree;
    }
    
    /**
       The method contains checks whether an
       item is in a binary search tree.
       @param x The item to check for.
       @param bstree The binary tree to look in.
		 @return true if found, false otherwise.
    */
    
    private boolean contains(int x, Node bstree)
    {
        if (bstree == null)
            return false;
        if (x == bstree.value) 
            return true;
        if (x < bstree.value)
        {
            // Recursively look in left subtree
            return contains(x, bstree.left);
        }
        else
        { 
            // Recursively look in right subtree
            return contains(x, bstree.right);
        }
    }
    
    /** 
       The remove method removes a value from the 
       binary search tree. 
       @returns true if x was removed, 
		 false if x not found.
    */
    
    public boolean remove(int x)
    {
        RemovalResult result = remove(root, x);
        if (result == null)
            return false;
        else 
        {
            root = result.tree;
            return true;
        }        
    }
   
    /**
       This remove method removes a value a 
		 from a binary search tree and returns the 
       removed node and the remaining tree wrapped 
       in a RemovalResult object.
       @param bTree The binary search tre.
       @param x The value to be removed.
       @return null if x is not found in bTree.
    */

    private RemovalResult remove(Node bTree, int x)
    {
       if (bTree == null)
           return null;  
       if (x < bTree.value)
       {
           // Remove x from the left subtree
           RemovalResult result = remove(bTree.left, x);
           if (result == null) 
               return null;
           bTree.left = result.tree;
           result.tree = bTree;
           return result;           
       }
       if (x > bTree.value) 
       {
           // Remove x from the right subtree
           RemovalResult result = remove(bTree.right, x);
           if (result == null) 
               return null;
           bTree.right = result.tree;
           result.tree = bTree;
           return result;            
       }
       // x is in this root node      
       // Is it a leaf? 
       if (bTree.right == null && bTree.left == null) 
           return new RemovalResult(bTree, null);
       
       // Does the node have two children?
       if (bTree.right != null && bTree.left != null)
       {
          // Remove largest node in left subtree and 
          // make it the root of the remaining tree
          RemovalResult remResult
			              = removeLargest(bTree.left);
          Node newRoot = remResult.node;
          newRoot.left = remResult.tree;
          newRoot.right = bTree.right;
          
          // Prepare the result to be returned
          bTree.left = null;
          bTree.right = null;
          return new RemovalResult(bTree, newRoot);              
       }
      // The node has one child
      Node node = bTree;
      Node tree;  
      if (bTree.left != null)
          tree = bTree.left;
      else
          tree = bTree.right;
      node.left = null;
      node.right = null;
      return new RemovalResult(node, tree);                  
    }
    
    /**
       The removeLargest method removes the 
		 largest node from a binary search tree.
       @param bTree: The binary search tree.
       @return  The result of removing the 
		 largest node.
    */
    
    private RemovalResult removeLargest(Node bTree)
    {
        if (bTree == null) 
           return null;        
        if (bTree.right == null)
        {
            // Root is the largest node
            Node tree = bTree.left;
            bTree.left = null;
            return new RemovalResult(bTree, tree);            
        }
        else
        {
            // Remove the largest node from the 
			   // right subtree
            RemovalResult remResult = 
				           removeLargest(bTree.right);
            bTree.right = remResult.tree;
            remResult.tree = bTree;
            return remResult;            
        }
    }

    public void balance()
    {
	//Root is the Root
	//Some stuff to the left and some stuff to right

	//List!
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	//Get Data
	list = inOrder(root);

	//Test that list is in order!!!
	//System.out.println(list);

	//Convert to a list of Midpoints!!!
	list = midpoints(list);

	//Test that list is in Midpoint order
	//System.out.println(list);

	//Rebuild the tree by adding all the data!
	root = null;
	
	for (int x = 0; x < list.size();  x++)
	    {
		add(list.get(x));
	    }

    }

    private ArrayList<Integer> midpoints(ArrayList<Integer> myList)
    {
	ArrayList<Integer> output = new ArrayList<Integer>();

	if (myList.isEmpty())
	    return output;

	//Figure out midpoint
	int middle = myList.size() / 2; 
	
	//Small and big lists!
	ArrayList<Integer> small = new ArrayList<Integer>();
	ArrayList<Integer> big = new ArrayList<Integer>();

	//Small Stuff!
	int counter = 0;
	while (counter < middle)
	    {
		small.add(myList.get(counter));
		counter++;
	    }

	//Put middle directly into output
	output.add(myList.get(counter));
	counter++;

	//Big Stuff!
	while (counter < myList.size())
	    {
		big.add(myList.get(counter));
		counter++;
	    }
	//Handling the Small stuff
	output.addAll( midpoints(small));

	//Handling the Big Stuff
	output.addAll( midpoints(big));

	return output;



    }

    private ArrayList<Integer> inOrder (Node curr)
    {
	ArrayList<Integer> output = new ArrayList<Integer>();
	
	//Check if null!!!
	if (curr == null)
	    return output;

	//Go Left
	if (curr.left != null)
	    output = inOrder(curr.left);
	
	//Do Middle
	output.add(curr.value);
	
	//Go Right
	if (curr.right != null)
	    output.addAll( inOrder(curr.right) );

	return output;
    }


	public int[] branches()
	{
		ArrayList<Integer>LeftBranches = new ArrayList<>();
		ArrayList<Integer>RightBranches = new ArrayList<>();
		Node check = root;

		if (bstree == null)
        		System.out.println("No branches available for viewing.");
	
		else if (check.left == null && check.right == null)
       		{
			System.out.println("No branches available for viewing.");
        	}
		
        	else if (check.left != null)
		{
			LeftBranches = LeftBranch(check, LeftBranches);
		}
	
		else if (check.right != null)
		{
			RightBranches = RightBranch(check, RightBranches);
		}
        
		int size = LeftBranches.size();
		int size = size + RightBranches.size();
		int[] branchesArray = new int[size];
		for(int item : LeftBranches)
		{
			branchesArray.add(item);
		}
		for(int item : RightBranches)
		{
			branchesArray.add(item);
		}
        return branchesArray;	
			
	}

	private ArrayList<Integer> LeftBranch(Node check, ArrayList<Integer>branchesList)
	{
		if (check.left !=null)
		{
			branchesList.add(check.value);
			check = left;
			LeftBranch(check, branchesList);

			if (check.right !=null)
				branchesList = RightBranch(Node check, ArrayList<Integer>branchesList);
		}

		
		
	return branchesList;
	}

	private ArrayList<Integer> RightBranch(Node check, ArrayList<Integer>branchesList)
	{
		check = right;
		if (check.right !=null)
		{
			branchesList.add(check.value);
			check = right;
			rightBranch(check, branchesList);
		}

		if (check.right != null)
				LeftBranch(Node check, ArrayList<Integer>branchesList);
			
	return branchesList;	
	}
}
