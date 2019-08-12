import java.io.File;
import java.util.Scanner;

public class RevPolCalculator {
	
	public static void readExpression (String fileName)
	{
		if (fileName == null)
		{
			System.out.println("Filename cannot be blank!");
			return;
		}
		try
		{
			File inFile = new File(fileName);
			Scanner scanFile = new Scanner(inFile);
			while (scanFile.hasNextLine())
			{
				int result = 0;
				String expression = scanFile.nextLine();
				System.out.println("Calculating: "+ expression);
				evaluateExpression(expression);
			}			
		}
		catch (Exception e)
		{
			System.out.println("Filename error");
		}
	}
	
	public static void evaluateExpression (String expression)
	{
		StackInterface<Integer> stack = new ArrayStack<Integer>();
		int result = 0;
		try
		{
			for (String value : expression.split("\\s+"))
			{
				if (value.equals("+"))
				{
					if (stack.getCounter()<2)
					{
						System.out.println("Ill formatted expression.");
						result = 0;
					}
					int x = stack.pop();
					int y = stack.pop();
					stack.push(y+x);
				}
				else if (value.equals("-"))
				{
					int x = stack.pop();
					int y = stack.pop();
					stack.push(y-x);
				}
				else if (value.equals("*")) 
				{
					int x = stack.pop();
					int y = stack.pop();
					stack.push(y*x);
				}
				else if (value.equals("/"))
				{
					int x = stack.pop();
					int y = stack.pop();
					if (x == 0)
					{
						System.out.println("Can't divide by zero!");
						result = 0;
					}
					else
					{
						stack.push(y/x);
					}
				}
				else 
				{
					try
					{
						int x = Integer.parseInt(value);
						stack.push(new Integer(x));
					}
					catch (Exception e)
					{
						System.out.println(e);
					}
				}
			}
		}
		catch(Exception e)
		{
			//System.out.println(e);
		}
		if (stack.peek() == null)
		{
			result = 0;
		}
		else
		{
			result = stack.peek();
		}
		System.out.println("Result: "+ result);
		System.out.println();
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the Reverse Polish Calculator!");
		System.out.println("Enter the name of the file: ");
		String fileName = input.nextLine();
		System.out.println();
		
		readExpression(fileName);
		
	}

}