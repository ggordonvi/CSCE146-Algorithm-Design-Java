import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class WordSearch {
	
	private int size = 5;
	private char [][] board;
	public ArrayList<String> dictionary;
	String buildWord = "";
	
	public WordSearch () throws FileNotFoundException
	{
		board = new char[size][size];
		dictionary = new ArrayList<String>();
		readDictionary();
	}
	
	public void readDictionary () throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("dictionary.txt"));
		while (scan.hasNextLine())
		{
			String line = scan.nextLine();
			if (line != null)
				dictionary.add(line.toLowerCase());
		}
	}
	
	public void clearVisited (boolean [][] visited)
	{
		for (int i = 0; i < visited.length; i ++)
		{
			for (int j = 0; j < visited.length; j++)
			{
				visited[i][j] =false;
			}
		}
	}
	
	public void findWord (char [][] boards, boolean [][] visited)
	{
		for (int col = 0; col < boards.length; col++)
		{
			for (int row = 0; row < boards.length; row++)
			{
				clearVisited(visited);
				System.out.println("Starting "+ col + " " + row);
				findWords(buildWord, boards, visited, col, row);
			}
		}
	}
	
	private void findWords (String buildWord, char[][] board, boolean [][] visited,  int col, int row) throws ArrayIndexOutOfBoundsException
	{
		visited[col][row] = true;
		char c =board[col][row];
		String build = Character.toString(c);
		buildWord += build;
		for (int i = 0; i < dictionary.size(); i++)
		{
			if (buildWord.contentEquals(dictionary[i]))
			{
				System.out.println(buildWord);
				if (buildWord.length() >= 2 && fromWord.equals(buildWord))
				{
					System.out.println("Found Word: " + buildWord);
					continue;
				}
			}
			for (int i = col - 1; i <= col +1 && i < size; i++)
				for (int j = row - 1; j <= row +1 && j < size; j++)
					if (i >= 0 && j >= 0 && visited[i][j] != true)
					{
						System.out.println(i + ", " + j);
						findWords(buildWord, board, visited, i, j);
					}
			//buildWord = buildWord.substring(0, buildWord.length()-1);
			visited[col][row] = false;
		}
		
	}

	
	private void printBoard (char [][] boards)
	{
		for (int col = 0; col < boards.length; col++) 
		{
		    for (int row = 0; row < boards.length; row++) 
		    {
		        System.out.print(boards[col][row] + "  ");
		    }
		    System.out.println();
		}
		System.out.println();
	}
		

	public static void main(String[] args) throws FileNotFoundException  {
		
		WordSearch game = new WordSearch();
		char [][] board = { 	{'r', 'a', 'h', 'j', 'm'},
											{'y', 'u', 'w', 'w', 'k'},
											{'r', 'x', 'n', 'f', 'm'},
											{'q', 'g', 'e', 'e', 'b'},
											{'e', 'o', 'a', 'p', 'e'},
										};
		
		boolean [][] visited = new boolean[5][5];
		for (int i = 0; i < visited.length; i ++)
		{
			for (int j = 0; j < visited.length; j++)
			{
				visited[i][j] = false;
			}
		}
	
		game.printBoard(board);
		game.findWord(board, visited);
		
		}
}
