public class ArrayStack {
	
	private String[] stack;
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
		stack = new String[size];
		head = 0;
	}
	public void push(String data)
	{
		//pushing new data onto the stack
		if(head>=stack.length)//the stack is full
			return;
		stack[head] = data;
		System.out.println(head);
		head++;
		
	}
	public String pop()//removes the last element
	{
		if(head==0)//stack is empty
			return null;
		String retVal = stack[head-1];
		head--;
		return retVal;
	}
	public String peek()
	{
		if(head <= 0)
			return null;
		return stack[head-1];
	}
	public void print()
	{
		for(int i=0;i>=0;i++)
			System.out.println(stack[i].toString());
	}
}