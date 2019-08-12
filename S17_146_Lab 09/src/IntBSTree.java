

public class IntBSTree {
	
	private class Node
	{
		private int data;
		private Node leftChild;
		private Node rightChild;
		public Node (int aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root;
	public IntBSTree ()
	{
		root = null;
	}
	
	public void insert (int data)
	{
		if (root == null)
		{
			root = new Node(data);
		}
		else
			insert(root, data);
	}
	private Node insert (Node aNode, int data)
	{
		if (aNode == null)
			aNode = new Node(data);
		else 
		{
			if (data <= aNode.data)
				aNode.leftChild = insert (aNode.leftChild, data);
			else
				aNode.rightChild = insert (aNode.rightChild, data);
		}
		return aNode;
	}
	
	// Print in-order
	public void printInOrder ()
	{
		printInOrder(root);
	}
	private void printInOrder(Node aNode)
	{
		if (aNode == null)
			return;
		if (aNode.leftChild != null)
		{
			printInOrder(aNode.leftChild);
		}
		System.out.println(aNode.data);
		if (aNode.rightChild != null)
		{
			printInOrder(aNode.rightChild);
		}
		return;
	}
	
	// Print breadth order
	public void breadth()
	{
		breadth (root);
	}
	public void breadth (Node root)
	{
		if (root == null)
			return;
		System.out.println(root.data + " ");
		breadth(root.rightChild);
		breadth(root.leftChild);
		}
	
	// Get Depth method
	public int getDepth (int value)
	{
		return getDepth (root, value);
	}
	public int getDepth (Node aNode, int data)
	{
		if (aNode == null)
			return 0;
		if (aNode.data == 0)
			return 1;
		else if (aNode.data < data)
			return 1 + getDepth (aNode.leftChild, data);
		else if (aNode.data > data)
			return 1 + getDepth (aNode.rightChild, data);
		else
			return -1;
	}
}
