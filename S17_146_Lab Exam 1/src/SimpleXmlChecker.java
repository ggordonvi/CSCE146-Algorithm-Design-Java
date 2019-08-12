import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class SimpleXmlChecker {
	
	static int max_size;
	static int top;
	static String tagArr[];
	private static Scanner input;
	private static Scanner keyboard;
	
	private static void Stack ()
	{
		tagArr = new String [max_size];
		top = 0;
	}
	
	public boolean isEmpty()
	{
		if (top == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void push (String  newElement)
	{
		if (top >= max_size)
		{
			System.out.println("We don't have any space.");
		}
		tagArr[top] = (String) newElement;
		top++;
	}
	
	public String pop()
	{
		if(!this.isEmpty())
		{
			String temp = this.peek();
			tagArr [top-1] = null;
			top--;
			return temp;
		}
		else
		{
			return null;
		}
	}
	
	public String peek()
	{
		if (top > 0)
		{
			return tagArr[top-1];			
		} 
		else 
		{
			return null;
		}
	}
	
	public static void checkXML(String token) 
	{
		Stack();
		while (token != null)
		{
			if (token.equals("<"))
			{
				tagArr.push(token);
			}
			if (token.equals("</"))
			{
				tagArr.push(token);
			}
			System.out.println(tagArr);	
		}
		checkTags(tagArr);
	}
	
	public static void checkTags(String [] tagArr)
	{
		while (true)
		{
			if (top == top-1)
			{
				tagArr.pop(top);
				tagArr.pop(top-1);
				top--;
			}
			break;
		}
	}
	
	public static void main (String[] args) throws FileNotFoundException
	{
		keyboard = new Scanner(System.in);
		System.out.println("Welcome to the simple XML tester.  Time to test simple XML's");
		System.out.println("Enter a file name:");
		String fileName = keyboard.nextLine();

		input = new Scanner (new File("c:\\users\\eddie\\workspace\\Lab Exam 1\\" + fileName));
		String token = input.nextLine();		
		
		checkXML(token);
	}
	
}
