public class BSTreeLL <T extends Comparable<T>> {
	
	private class Node 
	{//Vertex
		public T data;
		private Node leftChild;
		private Node rightChild;
		public Node(T aData) 
		{
			data = aData;
			leftChild = rightChild = null;
		}//Node
	}//Node

	private Node root;

	public BSTreeLL() 
	{
		root = null;
	}//BSTreeLL
	
	public void insert(T aData) 
	{
		if(root == null) {//Empty Tree
			root = new Node(aData);
		} else {
			insert(root, aData);//Calls recursive insert
		}//if else
	}//insert

	public Node insert(Node aNode, T aData) 
	{
		if(aNode == null) {//Found leaf
			aNode = new Node(aData);
		} else if(aData.compareTo(aNode.data) < 0) {//Go left
			aNode.leftChild = insert(aNode.leftChild, aData);
		} else if(aData.compareTo(aNode.data) > 0) {//Go right
			aNode.rightChild = insert(aNode.rightChild, aData);
		}
		return aNode;
	}//insert

	public void printPreOrder() 
	{
		printPreOrder(root);
	}//printPreOrder

	private void printPreOrder(Node aNode) 
	{
		if(aNode == null) return;
		System.out.print(aNode.data + " ");
		printPreOrder(aNode.leftChild);
		printPreOrder(aNode.rightChild);
	}//printPreOrder

	public void printInOrder() 
	{
		printInOrder(root);
	}//printInOrder

	private void printInOrder(Node aNode) 
	{
		if(aNode == null) return;
		printInOrder(aNode.leftChild);
		System.out.print(aNode.data + " ");
		printInOrder(aNode.rightChild);
	}//printInOrder

	public void delete(T value) 
	{
		if(root == null) return;
		delete(root, value);
	}//delete

	private Node delete(Node aNode, T value) 
	{
		//Search
		if(aNode == null) return null;//Didn't find the value
		if(value.compareTo(aNode.data) < 0){//Go left
			aNode.leftChild = delete(aNode.leftChild, value);
		} else if(value.compareTo(aNode.data) > 0) {
			aNode.rightChild = delete(aNode.rightChild, value);
		} else if(value.equals(aNode.data)){//else
			//Handles both cases
			if(aNode.rightChild == null) {
				return aNode.leftChild;
			}//if
			if(aNode.leftChild == null) {
				return aNode.rightChild;
			}//if

			//Handles case 3... Two children
			Node temp = aNode;
			aNode = findMinInTree(aNode.rightChild);

			//delete the min
			aNode.rightChild = deleteMinFromTree(aNode.rightChild);
			aNode.leftChild = temp.leftChild;
		}//if else else
		else {}
		return null;
	}//delete

	private Node deleteMinFromTree(Node aNode) 
	{
		if(aNode == null) return null;
		if(aNode.leftChild ==null)
			return aNode.rightChild;
		aNode.leftChild = deleteMinFromTree(aNode.leftChild);
		return aNode;
	}

	private Node findMinInTree(Node aNode) 
	{
		if(aNode == null) return null;
		if(aNode.leftChild == null) return aNode;
		return findMinInTree(aNode.leftChild);
	}//findMinInTree


}//BSTreeLL


/*
Traversals
  Pre-order trequires acessing each of the values of the node then traversing the left subtree and then the right subtree(Left side)
  Preorder would be 8 3 1 6 4 3 7 10 14 13
*/