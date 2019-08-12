import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//please make sure to include the file dictionay.txt

public class BoardGame {

private static Map<String, Integer> dict = new HashMap<>();

	//Method to read the dictionary file
	public static void readDictionary(String filename) throws FileNotFoundException
	{

		FileReader fr = new FileReader(filename);
		Scanner sc = new Scanner(fr);
		//Use while loop to convert the words of dictionary to lower case
		while(sc.hasNext())
		{
			dict.put(sc.next().toLowerCase(), 1);
		}
		sc.close();
	}

	//function to check if a given string is present in
	// dictionary.
	public static boolean isWord(String word)
	{
		return word.length() >=3 && dict.containsKey(word.toLowerCase());
	}
	
	public static List<String> foundWords = new ArrayList<>();
	// A recursive function to print all words present on boggle
	public static void findWordsUtil(String board[][], boolean visited[][], int i, int j, String str)
	{
		// Mark current cell as visited and append current character
		// to str
		visited[i][j] = true;
		if (str.length() == 15)
		{
			return;
		}
		
		str = str + board[i][j];
		// If str is present in dictionary, then print it
		if (isWord(str))
		{
			if (!foundWords.contains(str))
				foundWords.add(str);
		//System.out.println(str);
		}
		
		int M = board.length;
		
		int N = board[0].length;
		
		// Traverse 8 adjacent cells of boggle[i][j]
		
		for (int row=i-1; row<=i+1 && row<M; row++)
		
		{
		
		for (int col=j-1; col<=j+1 && col<N; col++)
		
		{
		
		if (row>=0 && col>=0 && !visited[row][col])
		
		findWordsUtil(board,visited, row, col, str);
		
		}
		
		}
		
		// Erase current character from string and mark visited
		
		// of current cell as false
		
		if (str != null && str.length() > 0 ) {
		
		str = str.substring(0, str.length()-1);
		
		}
		
		visited[i][j] = false;
		
		}
	
	// Prints all words present in dictionary.
	
	public static void findWords(String board[][])
	
	{
	
	int M = board.length;
	
	int N = board[0].length;
	
	// Mark all characters as not visited
	
	boolean visited[][] = new boolean[M][N];
	
	// Initialize current string
	
	String str = "";
	
	// Consider every character and look for all words
	
	// starting with this character
	
	for (int i=0; i<M; i++)
	
	{
	
	for (int j=0; j<N; j++)
	
	{
	
	findWordsUtil(board, visited, i, j, str);
	
	}
	
	}
	
	}
	
	// Driver program to test above function
	
	public static void main(String[] args) throws FileNotFoundException
	
	{
	
	readDictionary("dictionary.txt");
	
	FileReader fr = new FileReader(args[0]);
	
	Scanner sc = new Scanner(fr);
	
	int size = Integer.parseInt(sc.nextLine());
	
	String board[][] = new String[size][size];
	
	int i = 0;
	
	while(sc.hasNextLine())
	
	{
	
	String[] line = sc.nextLine().split("\\s+");
	
	board[i++] = line;
	
	}
	
	sc.close();
	
	findWords(board);
	
	Collections.sort(foundWords);
	
	for(String word : foundWords)
	
	System.out.println(word);
	
	}
	
	}