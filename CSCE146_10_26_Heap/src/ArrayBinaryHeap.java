
public class ArrayBinaryHeap <T extends Comparable<T>> {
	
	private T[] heap;
	public static final int DEFAULT_SIZE = 128;
	private int lastIndex;
	  
	public ArrayBinaryHeap(int size) 
	{
		init(size);
	}//ArrayBinaryHeap
	public ArrayBinaryHeap() 
	{
		init(DEFAULT_SIZE);
	}///ArrayBinaryHeap
	  
	private void init(int size) 
	{
		if(size <= 0) return;
		heap = new (T[])(Comparable[size]);
	    lastIndex = 0;
	}//init
	
	public insert(T value) 
	{
		if(lastIndex >= heap.length) return;//Heap is full
	    heap[lastIndex] = value;
	    bubbleUp();
	    lastIndex++;
	}//insert
	
	private void bubbleUp() 
	{
		int index = lastIndex;
		while(index > 0 && heap[(index-1)/2].compareTo(heap[index] < 0)) {
			//Child was greater than the parent so swap
			swap((index-1)/2,index);
		}
	}//bubbleUp
	
	public T peek() 
	{
		if(heap==null) return null;
		return heap[0];
	}

	private void swap(int i, int j) 
	{
		T temp = heap[i];
	    heap[i] = heap[j];
	    heap[j] = temp;
	}//swap
	
	public T remove() 
	{
		if(lastIndex == 0) return null;
	    T refVal = heap[0];
	    heap[0] = heap[lastIndex-1];
	    lastIndex--;
	    bubbleDown();
	    return retVal;
	}//remove
	
	private void bubbleDown() 
	{
		int index = 0;
		while(index*2+1 < lastIndex) 
		{
			int bigIndex = index*2+1;
			if(index*2+2 < lastIndex && heap[bigIndex].compareTo(heap[index*2+2] < 0) 
			{
				//Right child existed and was larger
				bigIndex = index*2+2;
			}
			if(heap[index].compareTo(heap[bigIndex]) < 0) 
			{
				//Parent was smaller, swap
				swap(index, bigIndex);
			} 
			else 
				break;//We are done
			index = bigIndex;
		}//while
	}//bubbleDown
	
	public void heapSort() 
	{
		while(lastIndex != 0) 
		{
	      System.otthis.remove();
	    }
	}//heapSort
}//ArrayBinaryHeap