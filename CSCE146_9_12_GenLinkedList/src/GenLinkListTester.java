/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * @author aylanickerson
 * Sep 12, 2017
 * 11:00:08 AM
 */

public class GenLinkListTester {
	public static void main(String[] args)
	{
		//If it is a primitive type you must use the wrapper class
		GenLinkedList<Integer> intLL=new GenLinkedList<Integer>();
		
		for(int i=0;i<10;i++)
			intLL.insert(i);
		System.out.println(intLL.getCurrent());
		
		for(int i=0;i<10;i++)
		{
			System.out.println(intLL.getCurrent());
			intLL.goToNext();
		}
		}
}
