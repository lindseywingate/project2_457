import java.util.*;
import java.io.*;
import java.lang.*;

/**inLab4 will allow the user to input how many students they have, their names, test scores, and return the students name and letter grade.
*<br><br>
*@author Lindsey Wingate
*@version 2.0
*@last updated 2/10/2015
*/

public class inLab4
{
	/**
	* main gathers the user input, creates two arrays (student names and student grades) and passes the information to checkScore
	*/
	public static void main(String[] args)
	{
		//gather number of students from user
		Scanner keyboard = new Scanner(System.in);
		int numOfStudents;
		System.out.println("How many students?");
		numOfStudents = keyboard.nextInt();

		//create arraylists and variables necessary
		String[]names = new String[numOfStudents];
		int[]grades = new int[numOfStudents];
		int count = 0;		

		while (count < numOfStudents)
		{
			String studentName;
			System.out.println("What is the name of the student?");
			names[count] = keyboard.nextLine();
			names[count] = keyboard.nextLine();

			int studentGrade;
			System.out.println("What is the grade of the student?");
			grades[count] = keyboard.nextInt();
			
			count = count + 1;
		}

		checkScore(names, grades, numOfStudents);
	}

	/**checks the grades to make sure they are within 0-100 and calculates the letter grade and passes the new letter grades and student names to be printed (toString)
	*/

	public static void checkScore(String[] names, int[] grades, int num)
	{

	//variables
	char newGrade;
	char[]newGrades = new char[num];
	int count = 0;
	

		//check array to reassign character grade
		for (int x=0; x < grades.length; x++)
		{

			if (grades[x]<60 && grades[x]>0)
			{
				newGrade = 'F';
				newGrades[x] = newGrade;	
			}
			if (grades[x]<70 && grades[x]>59)
			{
				newGrade = 'D';
				newGrades[x] = newGrade;	
			}
			if (grades[x]<80 && grades[x]>69)
			{
				newGrade = 'C';
				newGrades[x] = newGrade;	
			}
			if (grades[x]<90 && grades[x]>79)
			{
				newGrade = 'B';
				newGrades[x] = newGrade;	
			}
			if (grades[x]>=90 && grades[x]<=100)
			{
				newGrade = 'A';
				newGrades[x] = newGrade;	
			}
			if (grades[x]<0 || grades[x]>100)
			{
				System.out.println("Invalid grade.");
			}
		}
	toString(names, grades, newGrades, num);
	}

	/**creates the string containing the student name, test score, and grade. Prints final results.
	*/
	public static void toString(String[] names, int[] grades, char[] newGrades, int num)
	{
		//will need to build a string
		StringBuilder sb = new StringBuilder();
		int count = 0;

		while (count<num)
		{//build string
			sb.append(" Student name: ");
			sb.append(names[count]);
			sb.append(" Student grade: ");
			sb.append(grades[count]);
			sb.append(" Student letter grade: ");
			sb.append(newGrades[count]);
			String s = sb.toString();
			System.out.print(s);

		//print results formatted nicely
			System.out.print("Student Name:"+names[count]+"\nGrade:"+newGrades[count]+"\n");
			count = count + 1;
		}
	}
}








