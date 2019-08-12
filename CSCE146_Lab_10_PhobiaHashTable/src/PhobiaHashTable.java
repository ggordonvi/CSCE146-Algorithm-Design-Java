import java.util.*;

public class PhobiaHashTable {
	
	private class Phobia {
		private String phobia;
		private String description;
		//Default constructor
		public Phobia(String aPhobia, String aDescription)
		{
			phobia = aPhobia;
			description = aDescription;
			//System.out.println("Success");
		}
		//Getters and setters
		public String getPhobia()
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
			return "Name: "+ phobia +"\tDescription: "+ description;
		}
		//Equals
		public boolean equals(Phobia aPhobia)
		{
			Phobia anPhobia = aPhobia;
			return anPhobia.getPhobia().equalsIgnoreCase(phobia) &&
					anPhobia.getDescription().equalsIgnoreCase(description);
		}
	}
	
	private ArrayList<Phobia>[] table;
	private static final int CAP_A = 'A';
	
	//Default constructor
	public PhobiaHashTable()
	{
		table = new ArrayList[26];
		for(int i = 0; i < table.length; i++)
		{
			table[i] = new ArrayList<Phobia>();
		}
	}
	
	//Calculate index
	private int calcIndex(String aPhobia)
	{
		return aPhobia.toUpperCase().charAt(0) - CAP_A;
	}
	public String getKey(String aPhobia)
	{
		return aPhobia.charAt(0)+"";
	}
	
	//Add
	public void add(String aPhobia, String aDescription)
	{
		Phobia newPhobia = new Phobia(aPhobia, aDescription);
		//System.out.println(calcIndex(aPhobia));
		table[calcIndex(aPhobia)].add(newPhobia);
	}
	
	//Remove
	public void remove(String aPhobia, String aDescription)
	{
		Phobia testPhob = new Phobia(aPhobia, aDescription);
		boolean found = false;
		for(int i = 0; i < 26; i++)
		{
			if(table[i] != null)
			{
				for(Phobia phob : table[i])
				{
					if(phob.equals(testPhob))
					{
						testPhob = phob;
						found = true;
					}	
				}
				if(found)
				{
					table[i].remove(testPhob);
				}
			}
		}
	}
	
	//Look up
	public String lookUp(String aPhobia)
	{
		int index = calcIndex(aPhobia);
		for(Phobia phobia : table[index])
		{
			if(phobia.phobia.equals(aPhobia))
			{
				return phobia.description;
			}
		}
		return "Phobia not found!";
	}
	
	//Print hash table
	public void printHashTable()
	{
		System.out.println("Printing all phobias...");
		for(int i = 0; i < 26; i++)
		{
			if(table[i] != null)
			{
				for(Phobia phobia : table[i])
				{
					System.out.println(phobia.toString());
				}
			}
		}
	}
}
