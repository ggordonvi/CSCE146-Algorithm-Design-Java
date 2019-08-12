import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class ReversePolish <T> {
	
	static int max_size;
	static int top;
	static String arr[];
	
	private static void Stack ()
	{
		arr = new String [max_size];
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
	
	public void push (T newElement)
	{
		if (top >= max_size)
		{
			System.out.println("We don't have any space.");
		}
		arr[top] = (String) newElement;
		top++;
	}
	
	public String pop()
	{
		if(!this.isEmpty())
		{
			String temp = this.peek();
			arr [top-1] = null;
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
			return arr[top-1];			
		} 
		else 
		{
			return null;
		}
	}
	
	public static void evaluate(String token)
	{
		Stack();
		while (token != null)
		{
			if (token.equals("+"))
			{
				arr.push(arr.pop() + arr.pop());
			}
			else if (token.equals("-"))
			{
				Integer arg2 = arr.pop();
				arr.push(arr.pop() - arg2);
			}
			else if (token.equals("*"))
			{
				arr.push(arr.pop() * arr.pop());
			}
			else if (token.equals("/"))
			{
				Integer arg2 = arr.pop();
				arr.push(arr.pop() / arg2);
			}
			else
			{
				arr.push(Integer.parseInt(token));
			}
			System.out.println(arr);
		}
	}
	
	
	public static void main (String args []) throws FileNotFoundException
	{				
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Reverse Polish Calculator!");
		System.out.println("Enter the name of the file:");
		String fileName = scan.next();
		
		Scanner input = new Scanner (new File("c:\\users\\eddie\\workspace\\HW 04\\" + fileName));
		String token = input.nextLine();
		
		evaluate(token);
		
	}
}
