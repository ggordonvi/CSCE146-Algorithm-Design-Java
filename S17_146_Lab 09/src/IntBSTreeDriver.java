
public class IntBSTreeDriver {

	public static void main(String[] args) {
		
		System.out.println("Int Binary Search Tree Tester!");
		System.out.println("Creating tree...");
		IntBSTree tree = new IntBSTree();
		
		System.out.println("Populating tree with values...");
		int [] intArr = {2, 4, 6, 8, 10, 1, 3, 5, 7, 9};
		for (int i : intArr)
		{
			tree.insert(i);
		}
		
		System.out.println("Testing insertion by in-order traversal...");
		tree.printInOrder();
		System.out.println("Testing breadth order traversal...");
		tree.breadth();
		System.out.println("Getting depth of 6");
		System.out.println(tree.getDepth(6));
		System.out.println("Getting depth of 14");
		System.out.println(tree.getDepth(14));
	}
}
