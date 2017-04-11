import java.util.*;
import java.io.*;

public class example {
  public static void main(String[] args) {
    Vector<String>vectorious = new Vector<String>(10, 2);
    //method 1: add
    vectorious.add("test1");
    vectorious.add("test2");
    vectorious.add("test3");
    vectorious.add("test4");
    
    //method 2: capacity
    int capacity = vectorious.capacity();
    System.out.println(capacity);
    
    //method 3: clone
    System.out.println(vectorious.clone());
    
    //method 4: elementAt
    System.out.println(vectorious.elementAt(2));
    
    //method 5: firstElement
    System.out.println(vectorious.firstElement());
    
    //method 6: get
    System.out.println(vectorious.get(0));
    
    //method 7: contains
    System.out.println(vectorious.contains("test1"));
    
    //method 8: indexOf
    System.out.println(vectorious.indexOf("test5"));
    
    //method 9: remove
    System.out.println(vectorious.remove("test2"));
    
    //method 10: trimToSize
    vectorious.trimToSize();
    System.out.println(vectorious);
    
    //method 11: clear
    vectorious.clear();
    System.out.println("The vector's contents are: "+vectorious);
  }
}
