import java.lang.reflect.Array;
import java.util.*;

public class Sorter {
	
	//Local heap class
	private static int[] heap;
	public static final int DEFAULT_SIZE = 128;
	private static int lastIndex;
	
	public Sorter()
	{
		init(DEFAULT_SIZE);
	}
	public Sorter(int size)
	{
		init(size);
	}
	private void init(int size)
	{
		if (size <= 0)
			return;
		heap = new int[size];
		lastIndex = 0;
	}
	public void insert (int value)
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
		while(index > 0 && heap[(index-1)/2] - (heap[index])>0)
		{
			int temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;
		}
	}
	public int peek()
	{
		if(heap == null)
			return 0;
		return heap[0];
	}
	public int remove()
	{
		if(lastIndex == 0)
			return 0;
		int retVal = heap[0];
		heap[0] = heap[lastIndex-1];
		heap[lastIndex-1] = 0;
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
					heap[index*2+1] - (heap[index*2+2])>0)
			{
				bigIndex = index*2+2;
			}
			if(heap[index] - (heap[bigIndex])>0)
			{
				int temp = heap[index];
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
	
	//Bubble sort
	public static void bubbleSort(int[] arr) 
	{  
		int n = arr.length;  
		int temp = 0;  
	    for(int i=0; i < n; i++)
	    {  
	    	for(int j=1; j < (n-i); j++)
	    	{  
	    		if(arr[j-1] > arr[j])
	    		{  
	    			temp = arr[j-1];  
	    			arr[j-1] = arr[j];  
	    			arr[j] = temp;  
	    		}  
	    	}
	    }	
	}
	
	//Quick Sort
	private static int[] values;
	private static int value;
	
	public static void quickSort(int[] a) {
        if (a == null || a.length==0){
            return;
        }
        values = a;
        value = a.length;
        quicksort(0, value - 1);
    }
    private static void quicksort(int left, int right) {
        int i = left, j = right;
        int pivot = values[left + (right-left)/2];
        while (i <= j) 
        {
            while (values[i] < pivot) 
            {
                i++;
            }
            while (values[j] > pivot) 
            {
                j--;
            }
            if (i <= j) 
            {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (left < j)
            quicksort(left, j);
        if (i < right)
            quicksort(i, right);
    }

    private static void swap(int i, int j) 
    {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
	
	

	public static void heapSort(int[] a)
	{
		Sorter sort = new Sorter();
		
		int[] temp = a;
		for(int value : temp)
		{
			sort.insert(value);
		}
		
		int index = 0;
		while(lastIndex != 0)
		{
			//System.out.println(index + " " + sort.remove());
			a[index] = sort.remove();
			index++;
		}
		/*
		for(int i = 0; i < a.length; i++)
		{
			if(lastIndex != 0)
			{
				a[i] = sort.remove();
				//System.out.println(i + " " + sort.remove());
			}
		}
		*/
		
	}

}
