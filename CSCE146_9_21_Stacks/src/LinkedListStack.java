/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * Sep 21, 2017
 * 10:40:23 AM
 */

/**
 * @author aylanickerson
 *
 */
public class LinkedListStack <T> implements StackInterface{
	private class ListNode
	{
		private T data;
		private ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data=aData;
			link=aLink;
		}
	}
	private ListNode head;
	public LinkedListStack()
	{
		head=null;
	}
	public void push(Object data)
	{
		ListNode newNode=new ListNode((T)data,head);
		head=newNode;
	}
	public T pop()//remove last elemetn
	{
		if(head==null)
			return null;
		T retVal=head.data;
		head=head.link;
		return retVal;
	}
	public T peek()
	{
		if(head!=null)
			return head.data;
		return null;
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

}
