
public class GenDoubleLinkedList <T> 
{
	private class ListNode
	{
		private T data;
		private ListNode nextLink;
		private ListNode prevLink;
		
		public ListNode()
		{
			data = null;
			nextLink = null;
			prevLink = null;
		}
		
		public ListNode (T newData, ListNode newNextLink, ListNode newPrevLink)
		{
			data = newData;
			nextLink = newNextLink;
			prevLink = newPrevLink;
		}
	}
	
	private ListNode head;
	private ListNode curr;
	private ListNode prev;
	
	public GenDoubleLinkedList()
	{
		head = curr = prev = null;
	}
	
	public void goToNext ()
	{
		if (curr != null)
		{
			prev = curr;
			curr = curr.nextLink;
		}
	}
	
	public void goToPrev ()
	{
		if (curr != null)
		{
			curr = prev;
			curr.prevLink = curr;
		}
	}
	
	public T getDataAtCurrent () 
	{
		if (curr != null)
			return curr.data;
		else
			return null;
	}
	
	public void setDataAtCurrent (T newData)
	{
		if (curr != null)
			curr.data = newData;
	}
	
	public void insertNodeAfterCurrent (T newData)
	{
		ListNode newNode = new ListNode ();
		newNode.data = newData;
		if (curr != null)
		{
			newNode.nextLink = curr.nextLink;
			curr.nextLink = newNode;
		}
		else if (head != null)
		{
			System.out.println("Current iterator is past the end of the list.");
		}
		else
		{
			System.out.println("Cannot use this to insert into an empty list.");
		}
		
	}
	
	public void deleteCurrentNode ()
	{
		if (curr != null && prev != null)
		{
			prev.nextLink = curr.nextLink;
			curr = curr.nextLink;
		}
		else if (curr != null && prev == null)
		{
			head = curr.nextLink;
			curr = head;
		}
		else
		{
			System.out.println("Can't delete null current");
		}
	}
	
	public boolean inList ()
	{
		return curr != null;
	}
	public void resetInList ()
	{
		curr = head;
	}
	
	public void showList ()
	{
		resetInList();
		while (inList())
		{
			System.out.println(getDataAtCurrent());
			goToNext();
		}
		resetInList();
	}
}
