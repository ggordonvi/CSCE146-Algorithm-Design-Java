
public class Ugrad extends Student{
	private int level; //1-f 2-soph 3-jun 4-sen 5-ssen
	public Ugrad()
	{
		super();
		this.level=1;
	}
	public Ugrad(String aName, int anID, int aLevel)
	{
		super(aName, anID);
		//TODO set level
	}
	public int getLevel()
	{
		return this.level;
	}
	public void setLevel(int aLevel)
	{
		if(aLevel>=1 && aLevel<=5)
		{
			this.level=aLevel;
		}
	}
	public boolean equals(Ugrad anUgrad)
	{
		return anUgrad !=null &&
				super.equals(anUgrad) &&
				this.level ==anUgrad.getLevel();
	}
	public String toString()
	{
		return super.toString()+ " "+ this.level;
	}

}
