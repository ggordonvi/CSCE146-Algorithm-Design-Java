
public class Process implements Comparable {
	
	private int priority;
	private double time;
	private String name;
	
	public Process()
	{
		name = "";
		priority = 0;
		time = 0.0;
	}
	public Process(String name, int priority, double time)
	{
		this.name = name;
		this.priority = priority;
		this.time = time;
	}
	
	//Getters and Setters
	public int getPriority()
	{
		return priority;
	}
	public void setPriority(int aPriority)
	{
		priority = aPriority;
	}
	public double getTime()
	{
		return time;
	}
	public void setTime(double aTime)
	{
		time = aTime;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String aName)
	{
		name = aName;
	}
	
	//To String
	public String toString()
	{
		String toString = ""+ name +" "+ priority +" "+ time;
		return toString;
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
