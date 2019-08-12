
public class ProcessScheduler <T> {
	
	LinkedListQueue<Process> processes;
	Process currentProcess;
	
	public ProcessScheduler ()
	{
		processes = new LinkedListQueue<Process>();
	}
	
	public Process getCurrentProcess ()
	{
		if (currentProcess == null)
			return null;
		return currentProcess;
	}
	
	public void addProcess (Process aProcess)
	{
		if (currentProcess == null)
			currentProcess = aProcess;
		processes.enqueue(aProcess);
	}
	
	public void runNextProcess ()
	{
		currentProcess = processes.dequeue();
	}
	
	public void cancelCurrentProcess ()
	{
		currentProcess = processes.dequeue();
	}
	
	public void printProcessQueue ()
	{
		processes.print();
	}

}
