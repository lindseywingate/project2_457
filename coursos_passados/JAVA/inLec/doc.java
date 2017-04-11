import java.util.*;

import java.io.*;

 

public class doc

{

  public static void main(String[] args) throws FileNotFoundException

  {

    //prepare to read data

    File file = new File("Pets.txt");

    Scanner inputFile = new Scanner(file);

   

    //read data from file

    while (inputFile.hasNext())

    {

    String line = " ";

    line = inputFile.nextLine();

   

    //split data by seperator (!) and assign to data

    String[] data = line.split("!");//split line at spaces and create an array

   

    //print names of fish

    if(data[0].equals("Fish"))

    {

    System.out.println(data[1]);

    }

    }

  inputFile.close();

}

}
