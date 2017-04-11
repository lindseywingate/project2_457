import java.util.*;

public class Employee
{
	private String nome;
	private int numero;
	
	public Employee(String n, int num)
	{
		setName(n);
		setNumber(num);
	}
	
	public void setName(String n)
	{
		nome = n;
	}
	
	public String getName()
	{
		return nome;
	}
	public void setNumber(int num)
	{
		numero = num;
	}	
	public int getNumber()
	{
		return numero;		
	}
	public String toString()
	{
		 return "Name: "+nome+"\n ID: "+numero;
	}
}
