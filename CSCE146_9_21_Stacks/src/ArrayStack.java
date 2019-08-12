/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * Sep 21, 2017
 * 10:17:40 AM
 */

/**
 * @author aylanickerson
 *
 */
public class ArrayStack <T> implements StackInterface{
	private T[] stack;
	public static final int MAX_STACK=100;
	private int head;//points to the first null element
	
	public ArrayStack()
	{
		init(MAX_STACK);
	}
	public ArrayStack(int size)
	{
		init(size);
	}
	private void init(int size)
	{
		if(size<=0)
			return;
		stack=(T[])(new Object[size]);
	}
	public void push(Object data)
	{
		//pushing new data onto the stack
		if(head>=stack.length)//the stack is full
			return;
		stack[head]=(T)data;
		head++;
		
	}
	public T pop()//removes the last element
	{
		if(head==0)//stack is empty
			return null;
		T retVal=stack[head-1];
		head--;
		return retVal;
	}
	public T peek()
	{
		if(head>0)
			return stack[head-1];
		return null;
	}
	public void print()
	{
		for(int i=0;i>=0;i++)
			System.out.println(stack[i].toString());
		
	}

}
