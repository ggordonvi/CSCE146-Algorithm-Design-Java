import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/*
 * George Gordon - CSCE 146
 * HW 8 - Unlicensed Word Finder
 * Separate into a bunch of methods
 * buildDictionary
 * printDictionary - helper
 * printBoard
 * search - from each cell
 * find - from each surrounding cell
 * hasfound - check against dictionary 
 */

public class WordFinder {
	
	private static String[] dictionary;
	private int dictSize = 25144;
	private static boolean [][] visited;
	private String word;
	private final int SIZE = 5;
	
	public WordFinder()
	{
		dictionary = new String[dictSize];
		buildDictionary();
		//printDict();
	}
	
	//Build our dictionary array
	public void buildDictionary()
	{
		String dictFile = "dictionary.txt";
		int index = 0;
		try {
			FileReader dict = new FileReader(dictFile);
			Scanner scan = new Scanner(dict);
			while (scan.hasNext())
			{
				dictionary[index] = scan.next().toLowerCase();
				index++;
			}
			scan.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Dictionary.txt not in source folder!");
		}
	}
	
	//Print dictionary to check
	public void printDict()
	{
		for(int i = 0; i < dictionary.length; i++)
		{
			System.out.println(dictionary[i]);
		}
	}
	
	//Prints game board matrix
	public void printBoard (char [][] board)
	{
		for (int row = 0; row < board.length; row++) 
		{
		    for (int col = 0; col < board.length; col++) 
		    {
		        System.out.print(board[row][col] + "  ");
		    }
		    System.out.println();
		}
		System.out.println();
	}
	
	//Search the board from each letter on board
	public void searchBoard (char [][] board)
	{		
		//Create visited matrix
		visited = new boolean[SIZE][SIZE];
		word = "";
		
		//For each starting point, print and call
		for(int row = 0; row < SIZE; row++)
		{
			for(int col = 0; col < SIZE; col++)
			{
				System.out.println("Starting: ("+ row +", "+ col +")");
				findWords(board, visited, row, col, word);
				//System.out.println();
			}
		}		
	}
	
	//Search all 8 cells surrounding the starting letter
	public void findWords(char [][] board, boolean [][] visited, int x, int y, String word)
	{
		//System.out.println("x: "+ x + ", y: " + y + " - " + word);
		
		//Check bounds
		if(x < 0 || x > SIZE-1 || y < 0 || y > SIZE-1)
			return;
		//Check if already visited
		if(visited[x][y] == true)
			return;
		//Check assigned max word length
		if(word.length() == 6)
			return;
		
		//Checks passed, mark visited
		visited[x][y] = true;
		//Add to current word
		word = word + board[x][y];
		
		//If word is found, print
		if(hasFound(word))
			System.out.println("Found Word: " + word);

		//Traverse 8 surrounding cells
		findWords(board, visited, x-1, y-1, word); //TOP left
		findWords(board, visited, x-1, y, word); //TOP middle
		findWords(board, visited, x-1, y+1, word); //TOP right
		findWords(board, visited, x, y-1, word); //MIDDLE left
		findWords(board, visited, x, y+1, word); //MIDDLE right
		findWords(board, visited, x+1, y-1, word); //BOTTOM left
		findWords(board, visited, x+1, y, word); //BOTTOM middle
		findWords(board, visited, x+1, y+1, word); //BOTTOM right

		//Going back, remove last letter in our word
		if (word != null && word.length() > 0)
		{
			word = word.substring(0, word.length()-1);
		}
		//Going back, mark visited false again
		visited[x][y] = false;
	}
	
	//Checks current word against our dictionary
	public boolean hasFound(String word)
	{
		//Must be a word with 2 or more letters
		if(word.length() < 2)
			return false;
		//Inefficient? for loop to search entire dictionary
		for(int i = 0; i < dictSize; i++)
		{
			if(word.toLowerCase().equals(dictionary[i]))
			{
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		//Initialize game, builds dictionary
		WordFinder game = new WordFinder();
		//Our game board
		System.out.println("Unlicensed Word Finding Game\n");
		char [][] board = { {'R','A','H','J','M'},
							{'Y','U','W','W','K'},
							{'R','X','N','F','M'},
							{'Q','G','E','E','B'},
							{'E','O','A','P','E'} };
		//Prints board, and then begins search
		game.printBoard(board);
		game.searchBoard(board);
	}

}
