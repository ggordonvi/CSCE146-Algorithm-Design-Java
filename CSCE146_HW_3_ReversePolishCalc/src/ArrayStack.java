
public class ArrayStack <T> implements StackInterface {
	
	private T[] stack;
	public static final int MAX_STACK = 100;
	private int head; //Points to the first null element
	public int counter;
	
	//Constructors
	public ArrayStack ()
	{
		init(MAX_STACK);
	}
	public ArrayStack (int size)
	{
		init(size);
	}
	private void init (int size)
	{
		if (size <= 0)
			return;
		counter = 0;
		//Initialize head to 0
		head = 0;
		stack = (T[])(new Object[size]);
	}
	
	//Push new data onto the stack, add an element
	public void push (Object data)
	{
		//The stack is full
		if(head >= stack.length)
			return;
		//Add element to stack
		stack[head] = (T)data;
		head++;
		counter++;
	}
	
	//Removes the last element
	public T pop ()
	{
		//Array is empty
		if (head == 0)
			return null;
		//Remove top or 'head' value
		T retVal = stack[head-1];
		head--;
		counter--;
		return retVal;
	}
	
	//Peek at head
	public T peek ()
	{
		if (head > 0)
			return stack[head-1];
		return null;
	}
	
	public int getCounter ()
	{
		return counter;
	}
	
	//Print stack
	public void print ()
	{
		//Print stack in order, start at head and go back
		for (int i = head-1; i >= 0; i--)
		{
			System.out.println(stack[i].toString());
		}
	}
}