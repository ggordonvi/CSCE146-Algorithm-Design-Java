
public class Process {
	
	private String name;
	private double completionTime;
	
	public Process ()
	{
		name = null;
		completionTime = 0;
	}
	public Process (String aName, double aCompletionTime)
	{
		name = aName;
		completionTime = aCompletionTime;
	}
	
	public String getName ()
	{
		return name;
	}
	public String setName (String aName)
	{
		return name = aName;
	}
	public double getCompletionTime ()
	{
		return completionTime;
	}
	public double setCompletionTime (double aCompletionTime)
	{
		return completionTime = aCompletionTime;
	}
	
	public String toString ()
	{
		return "Process Name: "+getName()+ " Completion Time: "+getCompletionTime()+"";
	}
	

}
