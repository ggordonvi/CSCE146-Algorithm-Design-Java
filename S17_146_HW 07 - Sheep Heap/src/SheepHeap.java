import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.ArrayIndexOutOfBoundsException;


public class SheepHeap <T extends Comparable>{
	
	private T[] heap;
	public static final int CAPACITY =128;
	private int tailIndex;
	
	
	public SheepHeap ()
	{
		heap = (T[])(new Comparable[CAPACITY]);
		tailIndex = 0;
	}
	
	public SheepHeap (int aSize)
	{
		if (aSize > 0)
			return;
		heap = (T[])(new Comparable[aSize]);
		tailIndex = 0;
	}
	
	public void addSheep (T data)
	{
		if (tailIndex >= heap.length)
			return;  // The heap is full
		heap[tailIndex]= data;
		this.climbUp();
	}
	
	private void climbUp ()
	{
		int tempIndex = this.tailIndex;
		while (tempIndex > 0 && heap[(tempIndex - 1)/ 2]
				.compareTo(heap[tempIndex]) < 0)
		{
			T temp = heap[(tempIndex -1)/ 2];
			heap[(tempIndex - 1)/ 2] = heap[tempIndex];
			heap[tempIndex] = temp;
			tempIndex = (tempIndex - 1)/ 2;
		}
	}
	
	public int peek ()
	{
		if (heap == null)
			return 0;
		return (int) heap[0];
	}
	
	public T removeSheep ()
	{
		
		if (heap == null)
		{
			System.out.println("uhhhhh");
			return null;
		}
		T retVal = heap[0];
		heap[0] = heap[tailIndex-1];
		heap[tailIndex-1] = null;
		tailIndex--;
		this.climbDown();
		return retVal;
	}
	
	public void climbDown ()
	{
		int tempIndex = 0;
		while (tempIndex*2+1 < tailIndex)
		{
			int bigIndex = tempIndex*2+1;
			if (tempIndex*2+2 < tailIndex && heap[tempIndex*2+1].compareTo(heap[tempIndex*2+2]) < 0)
			{
				bigIndex = tempIndex*2+2;
			}
			if (heap[tempIndex].compareTo(heap[bigIndex]) < 0)
			{
				T temp = heap[tempIndex];
				heap[tempIndex] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			else
				break;
			tempIndex = bigIndex;
		}
	}
	public void sheepHeapSort (T[] anArray)
	{
		int size = anArray.length;
		heap = (T[]) new Comparable[size+1];
		System.arraycopy(anArray, 0, heap, 1, size);
		climbDown();

	      for (int i =size; i > 0; i--)
	      {
	         T sheepHeap = heap[i]; //move top item to the end of the heap array
	         heap[i] = heap[1];
	         heap[1] = sheepHeap;
	         size--;
	         climbDown();
	      }
	      for(int k = 0; k < heap.length-1; k++)
	         anArray[k] = heap[heap.length - 1 - k];
	   }
	
	public static void main(String[] args) throws RuntimeException
	{
		SheepHeap<Integer> sheepHeap = new SheepHeap<Integer>();
		
		System.out.println("Adding 15 sheep");
		String [] names = {"Bob", "Dylan", "Sarah", "Trevor", "Ashley", "Anne", "Alex", "Gen", 
				"Rob", "Xavier", "Herc", "Belle", "Jen", "Pat", "Space"};
		Integer [] weights = {105, 120, 101, 160, 120, 108, 155, 108, 120, 180, 199, 110, 118, 150, 145};
		
		for (int i = 0; i < names.length; i++)
		{
			System.out.print(names[i]);
			System.out.print(" ");
			System.out.print(weights[i]);
			System.out.println();
			sheepHeap.addSheep(weights[i]);
		}
		
		 System.out.println(Arrays.toString(weights));
		 System.out.println("Removing 5 sheep");
		 sheepHeap.removeSheep();
		 sheepHeap.removeSheep();
		 sheepHeap.removeSheep();
		 sheepHeap.removeSheep();
		 sheepHeap.removeSheep();
		 System.out.println(Arrays.toString(weights));
		 
		 sheepHeap.sheepHeapSort(weights);
		 System.out.println(Arrays.toString(weights));
		
	}
}
