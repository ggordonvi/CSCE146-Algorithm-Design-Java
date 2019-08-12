import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// George Gordon

public class WordFinder {
	
	private Vertex origin;
	private ArrayList<Vertex> vertices;
	private ArrayList<Vertex> markedVerts;
	boolean [][] visited = new boolean[5][5];
	String [] dictionary = new String[25144];

	
	private class Vertex
	{
		char name;
		ArrayList<Edge> neighbors;
		
		public Vertex (char aName)
		{
			this.name = aName;
			this.neighbors = new ArrayList<Edge>();
		}
	}
	
	private class Edge
	{
		Vertex toVert;
		double weight;
		
		public Edge (Vertex aVert, double aWeight)
		{
			this.toVert = aVert;
			this.weight = aWeight;
		}
	}
	
	public WordFinder ()
	{
		origin = null;
		vertices = new ArrayList<Vertex>();
	}
	
	public void addVertex (char aName)
	{
		for (Vertex vert : vertices)
		{
			if (vert.name == aName)
				return;
		}
		Vertex v = new Vertex (aName);
		if (origin == null)
			origin = v;
		vertices.add(v);
	}
	
	public void addEdge (char fromVert, char toVert, double weight)
	{
		Vertex v1 = getVertex(fromVert);
		Vertex v2 = getVertex(toVert);
		if (v1 == null || v2 == null)
			return;  //Can"t add edge to nothing
		v1.neighbors.add(new Edge(v2, weight));
	}
	
	private Vertex getVertex (char aName)
	{
		for (Vertex vert : vertices)
		{
			if (vert.name == aName)
				return vert;
		}
		return null;
	}	
	
	public void printDFS ()
	{
		if(markedVerts == null)
			markedVerts = new ArrayList<Vertex>();
		else
			markedVerts.clear();
		printDFS(origin);
	}
	
	private void printDFS (Vertex vert)
	{
		if (markedVerts.contains(vert))
			return; // Vertex already marked
		System.out.println(vert.name);
		markedVerts.add(vert);
		for(Edge edge : vert.neighbors)
			printDFS(edge.toVert);
	}
	
	
	public void readDictionary () throws FileNotFoundException
	{
		int position = 0;
		Scanner scan = new Scanner(new File("dictionary.txt"));
		while (scan.hasNextLine() && position < dictionary.length)
		{
			String line = scan.nextLine();
			String [] words = line.split("\\s+");
			for (String word : words)
			{
				dictionary[position] = word;
				position++;
				if (position >= dictionary.length)
				{
					break;
				}
			}
		}		
	}
	
	public void findWord (char [][] matrix)
	{
		String buildWord= null;
		for (int col = 0; col < matrix.length; col++)
		{
			for (int row = 0; row < matrix.length; row++)
			{
				System.out.println();
				System.out.println("Starting "+ col + " " + row);
				visited[col][row] = true;
				char c = matrix[col][row];
				buildWord = Character.toString(c);
				findWord(buildWord, matrix, col, row);
			}
		}
	}
	
	private void findWord (String buildWord, char[][] matrix,  int col, int row)
	{
		int n = 25144;
		for (int i = 0; i < n; i++)
		{
			if (buildWord.startsWith(dictionary[i]))
			{
				//Recursive methods ugh.
			}
		}
	}
	
	private void setUp (char [][] matrix) throws FileNotFoundException
	{
		// Show 2D array
		for (int col = 0; col < matrix.length; col++) 
		{
		    for (int row = 0; row < matrix.length; row++) 
		    {
		        System.out.print(matrix[col][row] + "  ");
		    }
		    System.out.println();
		}
		// Add vertex
		for (int col = 0; col < matrix.length; col++)
		{
			for (int row = 0; row < matrix.length; row++)
			{
				addVertex(matrix[col][row]);
			}
		}
		// Create Dictionary
		readDictionary();
		
	}
		
	public static void main(String[] args) throws FileNotFoundException  {
		
		WordFinder game = new WordFinder();
		char [][] matrix = { 	{'R', 'A', 'H', 'J', 'M'	},
											{'Y', 'U', 'W', 'W', 'K'	},
											{'R', 'X', 'N', 'F', 'M'	},
											{'Q', 'G', 'E', 'E', 'B'		},
											{'E', 'O', 'A', 'P', 'E'		},
										};
	
		game.setUp(matrix);
		game.findWord(matrix);
		
		}
}