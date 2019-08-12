
public class ProcessHeap <T extends Comparable<T>> {
	
	private T[] heap;
	public static final int DEFAULT_SIZE = 128;
	private int lastIndex;
	
	public ProcessHeap()
	{
		init(DEFAULT_SIZE);
	}
	public ProcessHeap(int size)
	{
		init(size);
	}
	private void init(int size)
	{
		if (size <= 0)
			return;
		heap = (T[])(new Comparable[size]);
		lastIndex = 0;
	}
	
	//Insert
	public void insert (T value)
	{
		if(lastIndex >= heap.length) //Heap is full
			return;
		heap[lastIndex] = value;
		bubbleUp();
		lastIndex++;
	}
	private void bubbleUp()
	{
		int index = lastIndex;
		while(index > 0 && heap[(index-1)/2].compareTo(heap[index])<0)
		{
			T temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;
		}
	}
	
	public T peek()
	{
		if(heap == null)
			return null;
		return heap[0];
	}
	
	//Remove
	public T remove()
	{
		if(lastIndex == 0)
			return null;
		T retVal = heap[0];
		heap[0] = heap[lastIndex-1];
		heap[lastIndex-1] = null;
		lastIndex--;
		bubbleDown();
		return retVal;
	}
	public void bubbleDown()
	{
		int index = 0;
		while(index*2+1 < lastIndex)
		{
			int bigIndex = index*2+1;
			if(index*2+2 < lastIndex && 
					heap[index*2+1].compareTo(heap[index*2+2])<0)
			{
				bigIndex = index*2+2;
			}
			if(heap[index].compareTo(heap[bigIndex])<0)
			{
				T temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			else
			{
				break;
			}
			index = bigIndex;
		}
	}
	//HeapSort
	public void heapSort()
	{
		while(lastIndex != 0)
		{
			System.out.println(this.remove());
		}
	}
		
	//print heap
	public void printHeap()
	{
		for(int i = 0; i < lastIndex; i++)
		{
			System.out.println(heap[i].toString());
		}
	}
	
	//is empty
	public boolean isEmpty()
	{
		if(lastIndex == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
