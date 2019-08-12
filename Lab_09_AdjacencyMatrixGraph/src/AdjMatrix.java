import java.util.*;

public class AdjMatrix {
	
	public static final int DEFAULT_SIZE = 7;
	private int[][] adjMatrix;
	private ArrayList<Integer> markedVerts;
  	private ArrayList<Integer> visitedVerts;

  	public AdjMatrix() 
  	{
  		init(DEFAULT_SIZE);
  	}
  	public AdjMatrix(int size) 
  	{
  		init(size);
  	}


  	public void addEdge(int fromVertex, int toVertex, int weight) 
  	{
  		if(fromVertex < 0 || toVertex < 0 || fromVertex >= adjMatrix.length || toVertex >= adjMatrix.length) return;//make sure our indices are inbounds
  		adjMatrix[fromVertex][toVertex] = weight;
  	}

  	public void printAdjMatrix() 
  	{
  		System.out.println("   v1 v2 v3 v4 v5 v6 v7");
  		for(int i = 1; i < adjMatrix.length; i++) 
  		{
  			System.out.print("v"+i + " ");
  			for(int j = 1; j < adjMatrix.length; j++) 
  			{
  				System.out.print(adjMatrix[i][j]+"  ");
  			}
  			System.out.println();
  		}
  	}

  	public void printDFSForAll()
  	{
  		markedVerts.clear();
  		for(int i = 1; i < adjMatrix.length; i++)
  		{
  			markedVerts.clear();
  			printBFS(i);
  			System.out.println("v"+ i +": "+ markedVerts.toString());
  		}
  	}
  	public void printDFS() 
  	{
  		markedVerts.clear();
  		printDFS(1);
  	}
  	private void printDFS(int index) 
  	{
  		System.out.print(index + " ");
  		markedVerts.add(index);
  		for(int i = 0; i < adjMatrix[index].length; i++) {
  			if(adjMatrix[index][i] != 0 && !markedVerts.contains(i))
  				printDFS(i);
  		}
  	}

  	public void printBFSForAll()
  	{
  		for(int i = 1; i < adjMatrix.length; i++)
  		{
  			System.out.print("v" + i + ": ");
  			markedVerts.clear();
  			visitedVerts.clear();
  			printBFS(i);
  			System.out.println();
  			
  		}
  	}
  	public void printBFS() 
  	{
  		markedVerts.clear();
  		visitedVerts.clear();
  		printBFS(1);
  	}
  	private void printBFS(int index) 
  	{
  		if(!visitedVerts.contains(index)) 
  		{
  			System.out.print(index + " ");
  			visitedVerts.add(index);
  		}
  		markedVerts.add(index);
  		//Visit Neighbors
  		for(int i = 0; i < adjMatrix[index].length; i++) 
  		{
  			if(adjMatrix[index][i] != 0.0 && !visitedVerts.contains(i)) 
  			{
  				System.out.print(i + " ");
  				visitedVerts.add(i);
  			}
  		}
  		for(int i = 0; i < adjMatrix[index].length; i++) 
  		{
  			if(adjMatrix[index][i] != 0 && !markedVerts.contains(i)) 
  			{
  				printBFS(i);
  			}
  		}
  	}

  	
  	private void init(int size) 
  	{
  		if(size <= 0) 
  			return;
  		adjMatrix = new int[size+1][size+1];
  		markedVerts = new ArrayList<Integer>();
  		visitedVerts = new ArrayList<Integer>();
  	}
}