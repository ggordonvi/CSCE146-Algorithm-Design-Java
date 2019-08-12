//George Gordon
public class IntBSTree <T extends Comparable> {
	
	private class Node
	{
		private T data;
		private Node leftChild;
		private Node rightChild;
		private Node (T aData)
		{
			data = aData;
			leftChild = rightChild =null;
		}
	}
	
	private Node root;
	public IntBSTree ()
	{
		root = null;
	}
	
	// Insert
	public void insert (T data)
	{
		if (root == null)
			root = new Node (data);
		else
			insert(root, data);
	}
	private Node insert (Node aNode, T data)
	{
		if (aNode == null)
			aNode = new Node(data);
		else if (data.compareTo(aNode.data) < 0)
			aNode.leftChild = insert(aNode.leftChild, data);
		else if (data.compareTo(aNode.data) >= 0)
			aNode.rightChild = insert(aNode.rightChild, data);
		return aNode;
	}
	
	// Remove
	public void delete (T data)
	{
		root = delete(root, data);
	}
	private Node delete (Node aNode, T data)
	{
		if (aNode == null)
			return null;
		if (data.compareTo(aNode.data) < 0)
			aNode.leftChild = delete(aNode.leftChild, data);
		if (data.compareTo(aNode.data) > 0)
			aNode.rightChild = delete(aNode.rightChild, data);
		else
		{
			if (aNode.rightChild == null)
				return aNode.leftChild;
			if (aNode.leftChild == null)
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
		if (aNode.leftChild == null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
	private Node deleteMinFromTree (Node aNode)
	{
		if (aNode == null)
			return null;
		if (aNode.leftChild == null)
			return aNode.rightChild;
		aNode.leftChild = deleteMinFromTree(aNode.leftChild);
		return aNode;
	}

}
