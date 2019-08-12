
//T is the generic type, so it's every type
public class GenLinkedList <T> {
	
	//Internal class of the node
	private class ListNode
	{
		private T data;
		private ListNode link;
		
		//Default Constructor
		public ListNode ()
		{
			data = null;
			link = null;
		}
		//Parameterized
		public ListNode (T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	
	//Pointer nodes
	private ListNode head; //First element
	private ListNode current; //Movable pointer that points to stuff. Used by the programmer
	private ListNode previous; //One node behind the current

	//Constructors
	public GenLinkedList ()
	{
		head = current = previous = null;
	}
	
	//Access for current Node
	public T getCurrent ()
	{
		if(current != null)
			return current.data;
		else
			return null;
	}
	
	//Modify the current node
	public void setCurrent (T aData)
	{
		if (current != null)
			this.current.data = aData;
	}
	
	//Insert new element to the end of the list
	public void insert (T newData)
	{
		//Create a new node
		ListNode newNode = new ListNode(newData, null);
		if (head == null) //List is empty
		{
			head = newNode; //Points head to the new node
			current = head; //Point current to the first element
			return;
		}
		ListNode temp = head; //Temp node to point to the head
		while (temp.link !=null) //As long as the node is pointing to something
		{
			//Mode the temp node forward
			temp = temp.link;
		}
		//Now we are at the end of the list
		temp.link = newNode; //Points to the new node
	}
	
	public void insertAfterCurrent (T newData)
	{
		//Create a new node
		ListNode newNode = new ListNode(newData, null);
		if (current != null)
		{
			newNode.link = current.link;
			current.link = newNode;
		}
		else if (head != null)
		{
			System.out.println("Current is outside the linked list!");
		}
		else
		{
			System.out.println("List is empty.");
		}
	}
	
	//Move current forward
	public void goToNext ()
	{
		if (current != null)
		{
			//if (current.link == null) //Current is at the end of the list
			//{
			//	current = head;
			//	previous = null;
			//}
			//else
			//{
			previous = current;
			current = current.link;
			//}
		}
	}
	
	public void resetCurrent ()
	{
		current = head;
		previous = null;
	}
	
	public boolean hasMore ()
	{
		return current != null;
	}
	
	public void print ()
	{
		ListNode temp = head;
		while (temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	public void deleteCurrent ()
	{
		if (current != null && previous != null) //Current is in the middle
		{
			previous.link = current.link;
			current = current.link;
		}
		else if (current != null && previous == null)
		{
			head = head.link; //Or head = current.link
			current = head;
		}
	}
	
}
