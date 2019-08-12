
public class ToDoList {

	private static ToDoList head;
	private static ToDoList current;
	private static ToDoList previous;
	private ListNode listData;
	
	private class ListNode {
		String data;
		ListNode link;
	}
	
	public ToDoList goToNext() {
		return ToDoList.head;
	}
	
	public ToDoList gotoPrev() {
		return ToDoList.previous;
	}
	
	public ListNode getDataAtCurrent() {
		return this.listData;
	}
	
	public void setDataAtCurrent(ListNode newData) {
		this.listData = newData;
	}
	
	private void addItem(ListNode listData) {
		if (head != null) {
			ListNode newNode = null;
			newNode = new ListNode();
			newNode.setDataAtCurrent(listData);
			this.linkAfter(this.getHead(), newNode);
		}
	}
	
	public void insertAfterCurrent(ListNode baseNode, ListNode newNode) {
		newNode.setNext(baseNode.getNext());
		newNode.setDataAtCurrent(baseNode);
		baseNode
	}
	public void deleteCurrentNode(ListNode node) {
		node.goToNext().setDataAtCurrent(node.gotoPrev());

	}
	
	public static void main(String[] args) {
		head = null;
		previous = head;
		current = head;
	}
}
