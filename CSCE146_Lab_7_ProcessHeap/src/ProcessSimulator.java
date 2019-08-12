
public class ProcessSimulator {
	public static void main(String[]args)
	{
		final int HEAP_SIZE = 100;
		ProcessHeap heap = new ProcessHeap(HEAP_SIZE);
		//Make initial heap
		heap.insert(new Process("a",10,50));
		heap.insert(new Process("b",5,20));
		heap.insert(new Process("c",20,18));
		heap.insert(new Process("d",18,29));
		heap.insert(new Process("e",33,23));
		heap.insert(new Process("f",1,15));
		heap.insert(new Process("g",16,5));
		
		System.out.println("The current heap is:");
		heap.printHeap();
		
		//ProcessHeap.heapSort(heap);
		
		System.out.println("Starting simulation");
		//Simulation
		final int SIM_TIME = 250;
		Process currProcess = null;
		double currProcessTime = 0.0;
		for(int i=0;i<SIM_TIME;i++)
		{
			if(currProcess == null)
			{
				if(heap.isEmpty())
				{
					System.out.println("Waiting for new processes");
					
				}
				else
				{
					currProcess = (Process)heap.remove();
					System.out.println("Process: "+currProcess.toString()+" is starting");
					currProcessTime = currProcess.getTime();
				}
			}
			else if(currProcessTime>0.0)
			{
				currProcessTime--;
			}
			else
			{
				System.out.println("Process: "+currProcess.toString()+" has ended");
				currProcess = null;
			}
			
			//New process added
			if(i%50 == 0 && i!=0)
			{
				Process randomProcess = new Process("Random Process "+i,i/5,i/5); 
				heap.insert(randomProcess);
				System.out.println("Random process added! "+randomProcess.toString());
			}
		}
		System.out.println("Simulation time has expired");
	}
}