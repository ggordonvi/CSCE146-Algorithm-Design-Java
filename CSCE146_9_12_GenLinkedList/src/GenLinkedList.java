/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * @author aylanickerson
 * Sep 12, 2017
 * 10:05:55 AM
 */
public class GenLinkedList <T>{ //T is the generic type, can pass in any type and everything just works!! wow
	//Internal class of the node
	private class ListNode {
		private T data; //int was the type that existed before, now T replaces it and you can fill in anything
		private ListNode link;
		private ListNode()
		{
			data=null;
			link=null;
		}
		public ListNode(T aData, ListNode aLink)
		{
			data=aData;
			link=aLink;
		}
	}
	//pointer mode
	private ListNode head;//first element
	private ListNode current;//moveable pointer that points to stuff
	private ListNode previous;//points to one node behind the current
	
	//Constructors
	public GenLinkedList()
	{
		head=current=previous=null;
	}
	public T getCurrent()
	{
		if(current!=null)
			return current.data;
		else
			return null;
	}
	//Modify the current node
	public void setCurrent(T aData)
	{
		if(current!=null)
			this.current.data=aData;
	}
	//Inserts new element to the end of the list
	public void insert(T newData)
	{
		//create a new node
		ListNode newNode=new ListNode(newData,null);
		if(head==null)//list is empty
		{
			head=newNode;//points head to memory address @ newNode
			current=head;
			return;
		}
		ListNode temp=head;//temp node to point to head
		while(temp.link!=null)
		{
			//move the temp node forward
			temp=temp.link;
		}
		//Now we are at the end of the list
		temp.link=newNode;
	}
	public void insertAfterCurrent(T newData)
	{
		//create a new node
		ListNode newNode=new ListNode(newData,null);
		if(current!=null)
		{
			newNode.link=current.link;
			current.link=newNode;
		}
		//what if current is null?
		else if(head!=null)
			//so the current is null, but the head is not. Means current is outside the linked list
			System.out.println("Current is outside of the linked list");
		else
			System.out.println("List is empty");
	}
	//Move current forward
	public void goToNext()
	{
		if(current!=null)
		{
			if(current.link==null)
				current=head;
			else
			{
				previous=current;
				current=current.link;	
			}
		}
	}
	public void resetCurrent()
	{
		current=head;
		previous=null;
	}
	public void print()
	{
		ListNode temp=head;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.link;
		}
	}
	public void deleteCurrent()
	{
		if(current !=null && previous !=null)//Current is in the middle
		{
			previous.link=current.link;
			current=current.link;
		}
		else if(current !=null && previous ==null)
		{
			head=head.link;//or head=current.link
			current=head;
		}
	}
	public boolean hasMore()
	{
		return current!=null;
	}
}
