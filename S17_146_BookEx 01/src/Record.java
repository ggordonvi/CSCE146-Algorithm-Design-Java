import java.util.Scanner;

public class Record 
{
	private final String TAG = "Record: ";
	static private final String DUMMYSTRING = "dummystring";
	static private final int DUMMYINT = Integer.MIN_VALUE;
	private String name;
	private int teaching;
	
	public Record() 
	{
		this.setName(Record.DUMMYSTRING);
		this.setTeaching(Record.DUMMYINT);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getTeaching()
	{
		return this.teaching;
	}
	
	private void setName (String what)
	{
		this.name = what;
	}
	
	private void setTeaching(int what)
	{
		this.teaching = what;
	}
	
	public int compareTo(Record that)
	{
		if(this.getName().compareTo(that.getName()) < 0)
			return -1;
		else if(this.getName().compareTo(that.getName()) > 0)
			return +1;
		else
			return 0;
	}
	
	public void readRecord(Scanner inFile)
	{
		int n;
		String s;
		if(inFile.hasNext())
		{
			s = inFile.next();
			this.setName(s);
			n = inFile.nextInt();
			this.setTeaching(n);
		}
	}
	
	public String toString()
	{
		String s;
		s = String.format("%-10s %4d", this.getName(), this.getTeaching());
		return s;				
	}
}
