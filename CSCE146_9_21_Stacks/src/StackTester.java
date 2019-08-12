/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * Sep 21, 2017
 * 10:50:52 AM
 */

/**
 * @author aylanickerson
 *
 */
public class StackTester {
	public static void main(String[] args)
	{
		//StackInterface stack=new StackInterface();NONONO
		StackInterface<Integer> stack=new ArrayStack<Integer>();//to change to linked list, change ArrayStack to LinkedList
		for(int i=0;i<10;i++)
			stack.push(i);
		for(int i=0;i<10;i++)
			System.out.println(stack.pop());
		String b="3";
		
		try
		{
			int c=Integer.parseInt(b);
			System.out.println(c);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}

}
