import java.util.*;

public class InLab3
{
  public static void main(String[] args)
  {
  double tax = .0655;
  double tip = .10;

  Scanner keyboard = new Scanner(System.in);
  System.out.println("What was the bill cost? ");
  double billCost;
  billCost = keyboard.nextDouble();

  Scanner keyboard1 = new Scanner(System.in);
  System.out.println("What is the customer's name? ");
  String custName;
  custName = keyboard1.nextLine();

//call all methods to calculate necessary elements of bill
  double TaxTotal = tax(billCost, tax);
  double TipTotal = tip(billCost, tip);
  double allCosts = totalBill(TaxTotal, TipTotal, billCost);  
  billInfo(custName, billCost, TaxTotal, TipTotal, allCosts);
}

public static double tax(double billCost, double tax)
  {
  double TaxTotal = billCost * tax;

  return TaxTotal;
  }

public static double tip(double billCost, double tip)
  {
  double TipTotal = billCost * tip;

  return TipTotal;
  }

public static double totalBill(double TaxTotal, double TipTotal, double billCost)
  {
  billCost = billCost + TaxTotal + TipTotal;
  
  return billCost;
  }

public static void billInfo(String name, double billCost, double tax, double tip, double totalBill)
  {
  System.out.println("Customer Name: "+ name);
  System.out.println("Bill before tax: " + billCost);
  System.out.println("Tax amount: " + tax);
  System.out.println("Tip amount: "+tip);
  System.out.println("New Bill Amount: "+totalBill);
  }
}

