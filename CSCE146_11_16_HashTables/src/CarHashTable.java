import java.util.*;

public class CarHashTable {
	
	private ArrayList<Car>[] table;
	private static final int TABLE_SIZE = 100;
	
	public CarHashTable()
	{
		table = new ArrayList[TABLE_SIZE];
		for(int i = 0; i < table.length; i++)
		{
			table[i] = new ArrayList<Car>();
		}
	}
	
	//Hash Function
	private int calcIndex (Car aCar)
	{
		int index = 0;
		String makeAndModel = aCar.getMake()+aCar.getModel();
		for(int i = 0; i< makeAndModel.length(); i++)
		{
			index += makeAndModel.charAt(i);
		}
		index %= TABLE_SIZE;
		return index;
	}
	
	public void add (Car aCar)
	{
		table[calcIndex(aCar)].add(aCar);
	}
	
	public void remove (Car aCar)
	{
		table[calcIndex(aCar)].remove(aCar);
	}
	
	public void lookUp (Car aCar)
	{
		int index = calcIndex(aCar);
		if(table[index].contains(aCar))
		{
			System.out.println(aCar.toString());
		}
		else
		{
			System.out.println("Nope");
		}
	}

}
