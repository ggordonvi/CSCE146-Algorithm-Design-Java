
public class Tester {
	
	public static void main (String[] args)
	{
		AdjMatrix aMatrix = new AdjMatrix();
		
		aMatrix.addEdge(1, 2, 1);
		aMatrix.addEdge(1, 4, 1);
		aMatrix.addEdge(2, 4, 1);
		aMatrix.addEdge(4, 3, 1);
		aMatrix.addEdge(4, 5, 1);
		aMatrix.addEdge(3, 1, 1);
		aMatrix.addEdge(3, 5, 1);
		aMatrix.addEdge(3, 6, 1);
		aMatrix.addEdge(5, 6, 1);
		aMatrix.addEdge(5, 7, 1);
		
		System.out.println("Adjacency Matrix Graph Tester");
		System.out.println();
		
		aMatrix.printAdjMatrix();
		System.out.println();
		
		System.out.println("Printing DFS..");
		aMatrix.printDFS();
		System.out.println();
		
		System.out.println("Printing BFS..");
		aMatrix.printBFS();
		System.out.println();
		
		System.out.println("\nPrinting DFS for all Vertices..");
		aMatrix.printDFSForAll();
		System.out.println();
		
		System.out.println("Printing BFS for all Vertices..");
		aMatrix.printBFSForAll();
		System.out.println();
		
	}

}
