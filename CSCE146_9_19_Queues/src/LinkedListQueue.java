/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * Sep 19, 2017
 * 10:47:43 AM
 */

/**
 * @author aylanickerson
 *
 */
public class LinkedListQueue <T> implements QueueInterface{
	private class ListNode
	{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data=aData;
			link=aLink;
		}
		
	}
	ListNode head;
	ListNode tail;
	public LinkedListQueue()
	{
		head=tail=null;
	}
	public void enqueue(Object data)
	{
		ListNode newNode=new ListNode((T)data, null);//create new node
		if(head==null)
		{
			head=newNode;
			tail=newNode;
			return;
		}
		tail.link=newNode;
		tail=newNode;
	}
	public T dequeue()
	{
		ListNode temp=head;
		head=head.link;
		return temp.data;
	}
	public T peek()
	{
		if(head!=null)
			return head.data;
		else
			return null;
	}
	public void print()
	{
		ListNode temp=head;
		while(temp!=null)
		{
			System.out.println(temp.data.toString());
			temp=temp.link;
		}
	}
}
