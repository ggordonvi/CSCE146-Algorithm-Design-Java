
public class JeepHeap <Jeep extends Comparable<Jeep>> {
	
	private Jeep[] heap;
	private static int CAPACITY = 128;
	private int tailIndex;
	
	public JeepHeap()
	{
		heap = (Jeep[])(new Comparable[CAPACITY]);
		tailIndex = 0;
	}
	public JeepHeap(int aSize)
	{
		if(aSize > 0)
			return;
		heap = (Jeep[])(new Comparable[aSize]);
		tailIndex = 0;
	}
	
	public void addJeep(Jeep aJeep)
	{
		if(tailIndex >= heap.length)
		{
			System.out.println("Full Jeep Heap!");
			return;
		}
		heap[tailIndex] = aJeep;
		climbUp();
		tailIndex++;
	}
	public void climbUp()
	{
		int index = this.tailIndex;
		while(index > 0 && heap[index/2].compareTo(heap[index]) < 0)
		{
			Jeep temp = heap[index/2];
			heap[index/2] = heap[index];
			heap[index] = temp;
			index = index/2;
		}
	}
	
	public Jeep peek()
	{
		if(heap == null)
			return null;
		return heap[0];
	}
	
	public Jeep removeJeep()
	{
		//System.out.println("Removing Jeep...");
		
		Jeep retVal = peek();
		heap[0] = heap[tailIndex-1];
		heap[tailIndex-1] = null;
		tailIndex--;
		climbDown();
		return retVal;
	}
	public void climbDown()
	{
		int index = 0;
		while(index*2+1 < tailIndex)
		{
			int bigIndex = index*2+1;
			if(index*2+2 < tailIndex && heap[index*2+1].compareTo(heap[index*2+2]) > 0)
			{
				bigIndex = index*2+2;
			}
			if(heap[index].compareTo(heap[bigIndex]) < 0)
			{
				Jeep temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			else
				break;
			index = bigIndex;
		}
	}
	
	public void jeepRollCall()
	{
		for(Jeep aJeep : heap)
		{
			if(aJeep == null)
				break;
			System.out.println(aJeep.toString());
		}
	}
	
	public void jeepHeapSort(JeepHeap heap)
	{
		JeepHeap tempHeap = heap;
		for(int i = tailIndex; i > 0; i--)
		{
			System.out.println(tempHeap.removeJeep()+ " ");
		}
	}

}
