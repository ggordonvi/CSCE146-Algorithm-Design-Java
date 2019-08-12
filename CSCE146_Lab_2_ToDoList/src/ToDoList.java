
public class ToDoList {
	
	private class ListNode //Internal class
	{
		private String data; //This box contains data
		private ListNode link;
		
		public ListNode () //Default constructor
		{
			data = "";
			link = null;
		}
		
		public ListNode (String aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	
	private ListNode head; //First element of the linked list
	private ListNode current; //Movable ListNode that gets what's currently interest
	private ListNode previous; //One node behind the current
	
	public ToDoList ()
	{
		head = current = previous = null;
	}
	
	//Access the data
	public String getCurrent ()
	{
		if (current != null)
			return current.data;
		else
			return null;
	}
	
	public void setDataAtCurrent (String newData)
	{
		if (current != null)
		current.data = newData;
	}
	
	//Adding a new element to the END of the list
	public void insert (String newData)
	{
		//Create a new node, set the data, link to null
		ListNode newNode = new ListNode(newData, null);
		//IF empty list, set new node to head
		if (head == null)
		{
			head = newNode;
			current = head;
			return;
		}
		//List not empty
		ListNode temp = head; //Temporary node that moves through the list (int i = 0)
		while (temp.link != null) //While not at the end of the list (boolean exp.)
		{
			temp = temp.link; //Moves temp ahead by one (i++)
		}
		temp.link = newNode;		
	}
	
	//Adding a new element in the MIDDLE of the list
	public void insertAfterCurrent (String newData)
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
			System.out.println("Current is outside of the list");
		}
		else
		{
			System.out.println("The list is empty");
			insert(newData); //Optional!!
		}
	}
	
	//Iterate (or move) forward
	public void goToNext ()
	{
		if (current != null)
		{
			if (current.link == null)
			{
				resetCurrent();
				return;
			}
			previous = current;
			current = current.link;
		}
	}
	public void resetCurrent ()
	{
		current = head;
		previous = null;
	}
	
	//Iterate back
	public void goToPrev ()
	{
		if (current != null)
		{
			if(current != head)
				current = previous;
		}
	}
	
	//Removing the current element
	public void deleteCurrent ()
	{
		if (current != null && previous != null)
		{
			previous.link = current.link;
			current = current.link;
		}
		else if (current != null && previous == null)
		{
			head = current.link;
			current = head;
		}
		else
		{
			System.out.println("List is empty! Noooooooo!");
		}
	}
	
	//Prints list by iterating through
	public void printList ()
	{
		ListNode temp = head;
		int i = 1;
		while (temp != null)
		{
			System.out.println(i + ". " + temp.data);
			i++;
			temp = temp.link;
		}
	}

}
