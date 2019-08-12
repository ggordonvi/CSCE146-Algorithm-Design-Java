import java.util.*;

public class Graph {
	
	private class Vertex
	{
		String name;
		ArrayList<Edge> neighbors;
		public Vertex (String aName)
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
	
	Vertex origin;
	private ArrayList<Vertex> vertices;
	private ArrayList<Vertex> markedVerts;
	
	public Graph ()
	{
		origin = null;
		vertices = new ArrayList<Vertex>();
		markedVerts = new ArrayList<Vertex>();
	}
	
	public void addVertex (String aName)
	{
		for (Vertex vert : vertices)
		{
			if (vert.name.equals(aName))
				return;
		}
		Vertex v = new Vertex (aName);
		if (origin == null)
			origin = v;
		vertices.add(v);
	}
	
	public void addEdge (String fromVert, String toVert, double weight)
	{
		Vertex v1 = getVertex(fromVert);
		Vertex v2 = getVertex(toVert);
		if (v1 == null || v2 == null)
			return;
		v1.neighbors.add(new Edge(v2, weight));
	}
	
	private Vertex getVertex (String aName)
	{
		for (Vertex vert : vertices)
		{
			if (vert.name.equals(aName))
				return vert;
		}
		return null;  // Didn't find that name
	}
	
	Stack<Vertex> stack = new Stack<Vertex>();
	public void printDFS ()
	{
		markedVerts.clear();
		for (Vertex vert : vertices)
		{
			markedVerts.clear();
			printDFS(vert);
		}
		//printDFS(origin);
	}	
	private void printDFS (Vertex vert) throws EmptyStackException
	{
		if (markedVerts.contains(vert))
		{
			System.out.print(vert.name);
			
			System.out.println();
			//for(Vertex vertex : stack)
				//System.out.print(vertex + " ");
			return;
		}
		System.out.print(vert.name + " ");
		markedVerts.add(vert);
		stack.push(vert);

		for (Edge edge : vert.neighbors)
		{
			printDFS(edge.toVert);
			
		}
		
		return;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph start = new Graph();
		
		start.addVertex("1");
		start.addVertex("2");
		start.addVertex("3");
		start.addVertex("4");
		start.addVertex("5");
		start.addVertex("6");
		start.addVertex("7");
		
		start.addEdge("1", "5", 1.0);
		start.addEdge("5", "2", 1.0);
		start.addEdge("5", "3", 1.0);
		start.addEdge("5", "7", 1.0);
		start.addEdge("2", "1", 1.0);
		start.addEdge("3", "1", 1.0);
		start.addEdge("4", "2", 1.0);
		start.addEdge("6", "3", 1.0);
		start.addEdge("7", "4", 1.0);
		start.addEdge("7", "6", 1.0);
		
		System.out.println("The Cycles in this graph are");
		start.printDFS();
		
	}

}
