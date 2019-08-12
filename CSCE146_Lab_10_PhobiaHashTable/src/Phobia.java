
public class Phobia {
	
	String phobia;
	String description;
	
	//Default constructor
	public Phobia(String aPhobia, String aDescription)
	{
		phobia = aPhobia;
		description = aDescription;
		System.out.println("Success");
	}
	
	//Getters and setters
	public String getphobia()
	{
		return phobia;
	}
	public void setphobia(String aPhobia)
	{
		phobia = aPhobia;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String aDescription)
	{
		description = aDescription;
	}
	
	//To string
	public String toString()
	{
		return "phobia: "+ phobia +", Description: "+ description;
	}
	//Equals
	public boolean equals(Phobia aPhobia)
	{
		Phobia anPhobia = aPhobia;
		return anPhobia.getphobia().equalsIgnoreCase(phobia) &&
				anPhobia.getDescription().equalsIgnoreCase(description);
	}
}
