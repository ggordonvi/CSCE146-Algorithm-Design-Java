import java.io.File;
import java.util.Scanner;
import java.io.*;

// George Gordon
/*  CSCE 146 HW 06
 *   Binary search tree too sort fruit weights
 */

public class FruitTree <T extends Comparable>{
	
	// Node class
	private class Node
	{
		private float data;
		private String name;
		private Node leftChild;
		private Node rightChild;
		private Node (String aName, float aData)
		{
			name = aName;
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root;
	public FruitTree ()
	{
		root = null;
	}
	
	// Insert methods
	public void insert (String name, float data)
	{
		if (root == null)
			root = new Node (name, data);
		else
			insert(root, name, data);
	}
	private Node insert (Node aNode, String name, float data)
	{
		if (aNode == null)
			aNode = new Node(name, data);
		else if (data < aNode.data)
			aNode.leftChild = insert(aNode.leftChild, name,  data);
		else if (data >= aNode.data)
			aNode.rightChild = insert (aNode.rightChild, name, data);
		return aNode;
	}
	
	// Remove methods
	public void delete (String name, float data)
	{
		root = delete(root, name, data);
	}
	private Node delete (Node aNode, String name, float data)
	{
		if (aNode == null)
			return null;
		if(data < aNode.data)
			aNode.leftChild = delete(aNode.leftChild, name, data);
		else if(data > aNode.data)
			aNode.rightChild = delete(aNode.rightChild, name, data);
		else
		{
			if(aNode.rightChild == null)
				return aNode.leftChild;
			if(aNode.leftChild == null)
				return aNode.rightChild;
			else
			{
				Node temp = aNode;
				aNode = findMinInTree (aNode.rightChild);
				aNode.rightChild = deleteMinFromTree(temp.rightChild);
				aNode.leftChild = temp.leftChild;
			}
		}
		return aNode;
	}
	private Node findMinInTree (Node aNode)
	{
		if (aNode == null)
			return null;
		if(aNode.leftChild == null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
	private Node deleteMinFromTree(Node aNode)
	{
		if (aNode == null)
			return null;
		if (aNode.leftChild == null)
			return aNode.rightChild;
		aNode.leftChild = deleteMinFromTree(aNode.leftChild);
		return aNode;
	}
	
	// Pre Order traversal
	public void printPreOrder ()
	{
		printPreOrder(root);
	}
	private void printPreOrder (Node aNode)
	{
		if (aNode == null)
			return;
		System.out.println(aNode.name + "\t" + aNode.data);
		if (aNode.leftChild != null)
			printPreOrder (aNode.leftChild);
		if (aNode.rightChild != null)
			printPreOrder (aNode.rightChild);
	}
	
	// In Order traversal
	public void printInOrder ()
	{
		printInOrder(root);
	}
	private void printInOrder (Node aNode)
	{
		if (aNode == null)
			return;
		if (aNode.leftChild != null)
			printInOrder (aNode.leftChild);
		System.out.println(aNode.name + "\t" + aNode.data);
		if (aNode.rightChild != null)
			printInOrder (aNode.rightChild);
	}
	
	// Post Order traversal
	public void printPostOrder ()
	{
		printPostOrder(root);
	}
	private void printPostOrder (Node aNode)
	{
		if (aNode == null)
			return;
		if (aNode.leftChild != null)
			printPostOrder (aNode.leftChild);
		if (aNode.rightChild != null)
			printPostOrder (aNode.rightChild);
		System.out.println(aNode.name + "\t" + aNode.data);
	}


	public static  void main(String[] args) 
	{
		// Initialize
		FruitTree tree = new FruitTree();
		// Start messages
		System.out.println("Welcome to the Fruit Tree!");
		System.out.println("Populatng tree with file: 'fruit.txt'");
		// No user input, didn't look like it was needed
		String fileName = "fruit.txt";
		// Begin reading the file
		try (BufferedReader in = new BufferedReader(new FileReader(fileName)))
		{
			String line;
			// While it has a line
			while ((line = in.readLine()) != null)
			{
				//Split into two values
				String [] value = line.split("	");
				tree.insert(value[0], Float.parseFloat(value[1]));
			}
		}
		catch (IOException e)
		{
			System.out.print("Error");
		}
		// In-order
		System.out.println();
		System.out.println("Printing in order traversal: ");
		tree.printInOrder();
		// Pre-order
		System.out.println();
		System.out.println("Printing pre-order traversal: ");
		tree.printPreOrder();
		// Post-Order
		System.out.println();
		System.out.println("Printing post-order traversal: ");
		tree.printPostOrder();
		
		System.out.println();
		System.out.println("Deleting Apple 0.4859853412170728");
		String applename = "Apple";
		float applevalue = (float) 0.4859853412170728;
		tree.delete(applename, applevalue);
		System.out.println("Printing in order traversal: ");
		tree.printInOrder();
	}
		

}
