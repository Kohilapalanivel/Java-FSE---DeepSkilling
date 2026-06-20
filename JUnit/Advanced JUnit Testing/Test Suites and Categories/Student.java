package junitpractice;

public class Student 
{
	public String getGrade(int mark)
	{
	        if(mark >= 50)
	        {
	            return "Pass";
	        }
	        else
	        {
	            return "Fail";
	        }
	    }
}
