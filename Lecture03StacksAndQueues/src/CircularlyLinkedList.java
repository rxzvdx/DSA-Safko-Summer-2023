public class CircularlyLinkedList<T> extends LinkedList<T> 
{
	public CircularlyLinkedList()
	{
		super();
	}
	
	@Override
	 public void insertAtTail(T val) // needs to be changed
	 {
		Node<T> nptr = new Node<T>(val, null);
	    // empty CLL
	    if (head == null) 
	    {
	    	head = nptr;
	        tail = head;
	        tail.next = head;
	    } 
	    else 
	    {
	        tail.setNext(nptr);
	        nptr.next = head;
	        tail = nptr;
	    }
	    size++;
	  }
}
