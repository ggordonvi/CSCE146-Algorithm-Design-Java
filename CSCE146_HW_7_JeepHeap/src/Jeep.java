
public class Jeep implements Comparable<Jeep> {

	private String name;
	private double weight;
	private int hp;
	
	public Jeep ()
	{
		name = null;
		weight = 0.0;
		hp = 0;
	}
	public Jeep (String aName, double aWeight, int aHp)
	{
		this.name = aName;
		this.weight = aWeight;
		this.hp = aHp;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String aName)
	{
		this.name = aName;
	}
	
	public double getWeight()
	{
		return weight;
	}
	public void setWeight(double aWeight)
	{
		this.weight = aWeight;
	}
	
	public int getHp()
	{
		return hp;
	}
	public void setHp(int aHp)
	{
		this.hp = aHp;
	}
	
	public String toString()
	{
		return name + ": [Weight]= " + weight + ", [Horsepower]= " + hp;
	}
	
	
	public int compareTo(Jeep aJeep) {
		
		if(this.hp > aJeep.hp)
			return 1;
		else if(this.hp < aJeep.hp)
			return -1;
		else
			return 0;
	}
	
}
