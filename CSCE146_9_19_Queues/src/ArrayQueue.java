/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * Sep 19, 2017
 * 10:20:08 AM
 */

/**
 * @author aylanickerson
 *
 */
public class ArrayQueue <T> implements QueueInterface{
	private T[] queue;
	private int tailIndex;//the index past the last element
	public static final int DEFAULT_SIZE=100;
	
	public ArrayQueue()
	{
		init(DEFAULT_SIZE);
	}
	public ArrayQueue(int size)
	{
		init(size);
	}
	private void init(int size)//initializes the array
	{
		if(size<0)
			queue=(T[]) (new Object[size]);
		tailIndex=0;
	}
	public void enqueue(Object data)
	{
		if(this.queue.length<=tailIndex)
			return;
		this.queue[tailIndex]=(T)data;
		tailIndex++;
	}
	public T dequeue()
	{
		T returnItem=this.queue[0];
		for(int i=0;i<tailIndex;i++)
			this.queue[i]=this.queue[i+1];
		tailIndex--;
		return returnItem;
	}
	public T peek()
	{
		return this.queue[0];
	}
	public void print()
	{
		for (int i=0;i<tailIndex;i++)
			System.out.println(queue[i].toString());
	}
}
