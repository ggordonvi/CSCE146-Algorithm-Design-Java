
public class LinkedListQueue <T> {

	private class ListNode
	{
		T data;
		ListNode link;
		
		public ListNode (T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	
	ListNode head;
	ListNode tail;
	
	public LinkedListQueue ()
	{
		head = tail = null;
	}
	
	public void enqueue (Object data)
	{
		ListNode newNode = new ListNode((T)data, null); //Create a new node
		if (head == null)
		{
			head = newNode;
			tail = newNode;
			return;
		}
		tail.link = newNode;
		tail = newNode;
	}
	
	//If error, return object not type T
	public T dequeue ()
	{
		ListNode temp = head;
		head = head.link;
		return temp.data;
	}
	
	public T peek ()
	{
		if (head != null)
			return head.data;
		else
			return null;
	}
	
	public void print ()
	{
		//Can check for equals, remove if equals, search, etc,
		// iterate through a linked structure, list, etc
		ListNode temp = head;
		while (temp != null)
		{
			System.out.println(temp.data.toString());
			temp = temp.link;
		}
	}
}
