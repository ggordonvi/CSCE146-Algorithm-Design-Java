import java.util.Arrays;
import java.util.Random;

public class SearchTester {
	
	static Random rand = new Random();
	static int DEFAULT_SIZE = 1000;
	static int DEFAULT_TESTS = 20;
	static int totalLinear = 0;
	static int totalBinary = 0;

	public static void main(String[] args) {
		System.out.println("Welcome to the Search Tester!");
		System.out.println("We are going to see which algorithm performs the best out of 20 tests.");
		System.out.println();
		//Run test 20 times
		for (int i = 0; i < 20; i++)
		{
			//Create array from method
			int[] randomNumbers = createArray();
			//Get number to search for
			int findNumber = getRandomNumber();
			//Perform searches
			System.out.println("Searching using Linear Search...");
			int linearSearches = linearSearch(randomNumbers, findNumber);
			System.out.println("Searching using Binary Search...");
			int binarySearches = binarySearch(randomNumbers, findNumber, 0, randomNumbers.length-1, 0);
			//Add individual searches to total searches
			System.out.println("Linear Checks: " +linearSearches);
			System.out.println("Binary Checks: " +binarySearches);
			System.out.println();
			totalLinear += linearSearches;
			totalBinary += binarySearches;
		}
		//Print final results
		System.out.println("The average number of checks for 20 tests were:");
		System.out.println("Linear Search Average: " + totalLinear/DEFAULT_TESTS);
		System.out.println("Binary Search Average: " + totalBinary/DEFAULT_TESTS);
	}
	
	public static int[] createArray()
	{
		//Create array of size 1000
		int[] randomNumbers = new int[DEFAULT_SIZE];
		//Populate array
		for (int i = 0; i < DEFAULT_SIZE; i++)
		{
			//Random used for numbers 0-999
			randomNumbers[i] = rand.nextInt(1000);
		}
		//Sort array
		Arrays.sort(randomNumbers);
		return randomNumbers;
	}
	
	public static int getRandomNumber()
	{
		//Get a random number 0-999
		return rand.nextInt(1000);
	}
	
	public static int linearSearch(int[] randomNumbers, int findNumber)
	{
		int linearCount = 0;
		//Run test the length of array
		for(int i = 0; i < randomNumbers.length; i++)
		{
			//Increase count for each search
			linearCount++;
			if(randomNumbers[i] == findNumber)
			{
				//If found, print found and return the count
				System.out.println("Found!");
				return linearCount;
			}
		}
		//Else not found, return the count
		System.out.println("Not found!");
		return linearCount;
	}
	
	//Recursive
	public static int binarySearch(int[] randomNumbers, int findNumber, int minIndex, int maxIndex, int binaryCount)
	{
		int midIndex = (maxIndex + minIndex) / 2;
		//binaryCount++;
		//If not found
		if(minIndex > maxIndex)
		{
			System.out.println("Not found!");
			return binaryCount;
		}
		//If found value
		if(randomNumbers[midIndex] == findNumber)
		{
			System.out.println("Found!");
			return binaryCount;
		}
		else
		{
			//Check upper half
			if(findNumber > randomNumbers[midIndex])
			{
				//System.out.println(binaryCount);
				return binarySearch(randomNumbers, findNumber, midIndex+1, maxIndex, binaryCount+1);
			}
			//Check lower half
			else
			{
				//System.out.println(binaryCount);
				return binarySearch(randomNumbers, findNumber, minIndex, midIndex-1, binaryCount+1);
			}
		}
		//System.out.println(binaryCount);
		//return binaryCount;
	}
}
