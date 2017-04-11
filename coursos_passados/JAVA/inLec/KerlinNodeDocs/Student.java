public class Student
{
	private String name;
	private double score;

	public Student()
	{
	}

	public Student(String n, int s)
	{
		setName(n);
		setScore(s);
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setScore(double score)
	{
		score = s;
	}

	public void getName()
	{
		return name;
	}
	
	public void getScore()
	{
		return score;
	}
	
	public String toString(name, score)
	{
		return "Name: "+name+"\nScore: "+score;
	}

}
