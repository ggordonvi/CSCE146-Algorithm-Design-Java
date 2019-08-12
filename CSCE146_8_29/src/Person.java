
public class Person {
	private String name;
	public Person() //default constructor
	{
		this.name="No Name Yet";
	}
	public Person(String aName)
	{
		//TODO call mutators
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String aName)
	{
		this.name=aName;
	}
	public boolean equals(Person aPerson)
	{
		return aPerson!= null && 
				this.name.equals(aPerson.getName());
		
	}
	public String toString()
	{
		return this.name;
	}
}
