
public class Student extends Person{
	private int id;
	public Student()
	{
		super(); //calls parents default constructor
		this.id=0; //need this for new ones from this class
	}
	public Student (String aName, int anID)
	{
		super(aName);
		//TODO call mutator ID
	}
	public int getID()
	{
		return this.id;
	}
	public void setID(int anID) //error checking here
	{
		if(anID>=0)
		{
			this.id=anID;
		}
	}
	public boolean equals(Student aStudent)
	{
		return aStudent!=null &&
				super.equals(aStudent) &&
				this.id==aStudent.getID();
	}
	public String toString()
	{
		return super.toString()+" "+this.id;
	}

}
