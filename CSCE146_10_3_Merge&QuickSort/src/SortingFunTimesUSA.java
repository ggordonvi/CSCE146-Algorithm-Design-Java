import java.util.Random;

public class SortingFunTimesUSA {

	public static void main(String[] args) {
		
		Random r = new Random();
		int[] a = new int[10];
		int[] b = new int[10];
	
		for(int i=0; i<a.length;i++)
		{
			a[i] = r.nextInt(100);
			b[i] = r.nextInt(100);
		}
		
		System.out.println("Pre-sorted Array");
		System.out.print("Array A: ");
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.print("\nArray B: ");
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		
		System.out.println("\n");
		System.out.println("Merge Sorting...");
		mergeSort(a);
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		
		System.out.println("\n Quick Sorting...");
		quickSortTail(b, 0, b.length-1);
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
	}
	public static void mergeSort(int[] a)
	{
		int size=a.length;
		if(size<2)
			return;
		int mid=size/2;
		int leftSize=mid;
		int rightSize=size-mid;
		int[] left=new int[leftSize];
		int[] right=new int[rightSize];
		
		//populate left array
		for(int i=0;i<mid;i++)
		{
			left[i]=a[i];
		}
		//populate the right array
		for(int i=mid; i<size;i++)
		{
			right[i-mid]=a[i];
		}
		mergeSort(left);
		mergeSort(right);
		//TODO merge
		merge(left, right, a);
	}
	private static void merge(int[] left, int[] right, int[] a)
	{
		int leftSize=left.length;
		int rightSize=right.length;
		int i=0;//left array index
		int j=0;//right array index
		int k=0;//sorted array 'a' index
		
		while(i<leftSize && j<rightSize)//both indices have not reached the end
		{
			if(left[i]<=right[j])
			{
				a[k]=left[i];
				i++;
				k++;
			}
			else
			{
				a[k]=right[j];
				j++;
				k++;
			}
		}
		while(i<leftSize)//while there are some elements left in the left array
		{
			a[k]=left[i];
			i++;
			k++;
		}
		while(j<rightSize)//while there are some elements left in the right array
		{
			a[k]=right[j];
			j++;
			k++;
			
		}
	}
	public static void quickSortTail(int[] a, int left, int right)
	{
		if(left<right)
		{
			//TODO partition
			//TODO recursive funtime
			int partition=partition(a, left, right);
			quickSortTail(a, left, partition-1);
			quickSortTail(a, partition+1, right);
		}
	}
	private static int partition(int[] a, int left, int right)
	{
		int pivot=a[right];//set pivor to last value
		int i=left;
		int j=right;
		while(j<right)
		{
			if(a[j]<pivot)
			{
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp; //swap
				i++;
			}
			j++;
		}
		//Fix up swap
		int temp= a[i];
		a[i]=a[right];
		a[right]=temp;
		return i;
	}

}
