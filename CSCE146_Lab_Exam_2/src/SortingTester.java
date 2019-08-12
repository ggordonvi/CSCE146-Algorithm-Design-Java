import java.util.*;

public class SortingTester {

	public static void main(String[] args) {
		
		int[] a = makeArray();
		long beforeTime = System.currentTimeMillis();
		Sorter.bubbleSort(a);
		long afterTime = System.currentTimeMillis();
		System.out.println("Sorted correctly? "+isSortedCorrectly(a));
		System.out.println("It took "+(afterTime-beforeTime)+"ms for bubble sort");
		
		a = makeArray();
		beforeTime = System.currentTimeMillis();
		Sorter.quickSort(a);
		afterTime = System.currentTimeMillis();
		System.out.println("Sorted correctly? "+isSortedCorrectly(a));
		System.out.println("It took "+(afterTime-beforeTime)+"ms for quick sort");
		
		a = makeArray();
		beforeTime = System.currentTimeMillis();
		Sorter.heapSort(a);
		for(int i = 0; i < a.length; i++)
		{
			System.out.println(a[i] + " ");
		}
		
		
		
		afterTime = System.currentTimeMillis();
		System.out.println("Sorted correctly? "+isSortedCorrectly(a));
		System.out.println("It took "+(afterTime-beforeTime)+"ms for heap sort");
		
		
	}
	public static boolean isSortedCorrectly(int[] a)
	{
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i]>a[i+1])
				return false;
		}
		return true;
	}
	public static int[] makeArray()
	{
		int[] a = new int[10000];//A big ole array
		Random r = new Random(100);//fixes the seed at 100
		for(int i=0;i<a.length;i++)
		{
			a[i] = r.nextInt(1000);//Picks a number from 0 to 999
		}
		return a;
	}
}