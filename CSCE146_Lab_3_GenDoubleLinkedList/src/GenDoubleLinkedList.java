public class GenDoubleLinkedList <T> {
		
		//Internal class of the node
		private class ListNode
		{
			T data;
			ListNode nextLink;
			ListNode prevLink;
			
			//Default Constructor
			public ListNode ()
			{
				data = null;
				nextLink = null;
				prevLink = null;
			}
			//Parameterized
			public ListNode (T aData, ListNode nextNode, ListNode prevNode)
			{
				data = aData;
				nextLink = nextNode;
				prevLink = prevNode;
			}
		}
		
		//Pointer nodes
		private ListNode head; //First element
		private ListNode current; //Movable pointer that points to stuff. Used by the programmer

		//Constructors
		public GenDoubleLinkedList ()
		{
			//Initialize head to an empty list node
			head = new ListNode();
			//Set current at front
			current = head;
		}
		
		//Move current forward
		public void goToNext ()
		{
			if (current.nextLink != null)
			{
				//if (current.link == null) //Current is at the end of the list
				//{
				//	current = head;
				//	previous = null;
				//}
				//else
				//{
				current = current.nextLink;
				//}
			}
		}
		
		//Move current back
		public void goToPrev ()
		{
			if(current.prevLink != null)
			{
				current = current.prevLink;
			}
		}
		
		//Access for current Node
		public T getDataAtCurrent ()
		{
			if(current != null)
				return current.data;
			else
				return null;
		}
		
		//Modify the current node
		public void setDataAtCurrent (T aData)
		{
			if (current != null)
				this.current.data = aData;
		}
		
		//Insert node after current
		public void insertNodeAfterCurrent (T newData)
		{
			
			//Create a new node
			//								data		nextNode		prevNode
			ListNode newNode = new ListNode(newData, current.nextLink, current);
			if (current != null)
			{
				newNode.nextLink = current.nextLink;
				current.nextLink = newNode;
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
		
		public void deleteCurrentNode ()
		{
			current.prevLink.nextLink = current.nextLink;
			current = current.nextLink;
		}		
		
		public boolean inList (T aData)
		{
			//Set temp to head, run through
			ListNode temp = head;
			//While temp is not empty (still in list)
			while (temp != null)
			{
				//Found data?
				if(temp.data == aData)
					return true;
				//Move forward
				temp = temp.nextLink;
			}
			//Else not found
			return false;
		}
		
		public void showList ()
		{
			//Set temp to head
			ListNode temp = head;
			//While in list
			while (temp != null)
			{
				//Print and move
				System.out.println(temp.data);
				temp = temp.nextLink;
			}
		}
		
		
	}