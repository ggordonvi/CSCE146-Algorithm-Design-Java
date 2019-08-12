//Single linked list of ints
public class LinkedLists {
/*
 * Data structures used to group together like data with rules
 * Linked lists have nodes that contain DATA and LINKS TO OTHER NODES, they are RESIZEABLE but no random access
 * 
 * 
 */
	private class ListNode //internal class, can only be used within this class
	{
		private int data; //this node now has info 
		private ListNode link; //reference to class that you are already in, ok in Java
		public ListNode()
		{
			data=0;
			link=null;
		}
		public ListNode(int aData, ListNode aLink)
		{
			data=aData;
			link=aLink;
		}
		
	}
	private ListNode head;//first element of the linked list
	private ListNode current; //moveable list node that gets whats currently interesting
	private ListNode previous;//one node behind current
	
	public LinkedLists()
	{
		head=current=previous=null;
	}
	//Access the data
	public int getCurrent()
	{
		if(current !=null)
			return current.data;
		else
			return 0;
	}
	//Adding a new element to the end of the list
	/*
	 * Adding to the linked list requires changing links to point to the new data
	 */
	public void insert(int newData)
	{
		//create a new node, set the data, link to null 
		ListNode newNode=new ListNode(newData,null);
		if(head==null)//empty list
		{
			head=newNode;
			current=head;
			return;
		}
		//List not empty
		//best friend of a linked list is a WHILE LOOP
		ListNode temp=head; //point temp variable to the head, start from the beginning
		while(temp.link!=null)//once it is equal to null, you are at the end of the list (boolean exp)
		{
			temp=temp.link; //moves temp ahead by one (i++)
		}
		temp.link=newNode; //adds element to END of list
		
	}
	//Adding an element to the MIDDLe of a list
	public void insertAfterCurrent(int newData)
	{
		ListNode newNode=new ListNode(newData,null);
		if(current!=null)
		{
			newNode.link=current.link;
			current.link=newNode;
		}
		else if(head!=null)
		{
			System.out.println("Current is outside of the list");
		}
		else
		{
			System.out.println("The list is empty");
			insert(newData);
		}
	}
	//iterate (move) forward in the list
	public void gotoNext()
	{
		if(current!=null)
		{
			if(current.link==null)
			{
				resetCurrent();
				return;
			}
			previous=current;
			current=current.link;
		}
	}
	public void resetCurrent()
	{
		current=head;
		previous=null;
	}
	
	public void deleteCurrent()
	{
		if(current !=null && previous !=null)
		{
			previous.link=current.link;
			current=current.link;
		}
		else if(current !=null && previous!=null)
		{
			head=current.link;
			current=head;
		}
		else
		{
			System.out.println("list is empty");
		}
	}
	public void printList()
	{
		ListNode temp=head;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.link;
		}
	}
	

	
}















