/*
 * Author: Antonio Rosado
 * Lab 02b: Queues
 */
public class Queue<T> implements QueueMethods<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue() 
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() 
    {
        return size == 0;
    }

    // Method to get the size of the queue
    public int getSize() 
    {
        return size;
    }

    // Method to push an element to the tail of the queue
    @Override
    public void push(T val) 
    {
        // push method
    }

    // Method to pop an element from the head of the queue
    @Override
    public void pop() 
    {
        // pop method
    }

    // Method to peek (examine but not remove) the element at the head of the queue
    @Override
    public T peek() 
    {
        // peek method
		return null;
    }
    
    public T top() 
    {
		return peekBack();
    }

    // Method to push an element st the head of the queue (pushFront)
    public void pushFront(T val) 
    {
    	// Adds the element after the tail
    	Node<T> nptr = new Node<T>(val, null);
    	if(head == null) 
    	{
    		head = nptr;
    		tail = head;
    	}
    	else
    	{
    		nptr.setNext(head);
    		head = nptr;
    	}
    	size++;
    }   
    
    // Pushes an element at the head
    @Override
    public void pushBack() 
	{
		// Adds the element at the head
	}
    
    // Pops an element from the tail
	public void popFront() 
	{
		// The same as pop (re-use this by calling it in popBack)
	}
	
	@Override
    // Method to pop an element from the head of the queue (popBack)
    public void popBack() 
    {
		// Makes sure the node exists
    	if (head == tail) 
    	{
    		head = tail = null;
    		size = 0;
    		return;
    	}
    	Node<T> tmp = head;
    	while (tmp.next != null) 
    	{
    		if(tmp.next.next == null) 
    		{
    			tmp.next = null;
    			tail = tmp;
    			size--;
    			return;
    		}
    		tmp = tmp.next;
    	}
    	return;
    }

	@Override
	// Method to peek (examine but not remove) the element at the tail of the queue (peekFront)
	public T peekFront() 
	{
		// The same as peek (re-use this by calling it in peekBack)
		return peek();
	}

    // Method to peek (examine but not remove) the element at the head of the queue (peekBack)
    public T peekBack() 
    {
    	// Make sure the node exists
        if (!isEmpty()) 
        {
            return tail.getData();
        }
        return null;
    }

    // Method to print the elements of the queue
    public void print() 
    {
    	if(size == 0) 
		{
			System.out.println("Queue is empty.");
			return;
		}
    	System.out.println("Queue elements: ");
        Node<T> ptr = head;
        while (ptr != null) 
        {
            System.out.print(ptr.getData());
            if(ptr.getNext() != null) 
            {
            	System.out.print(" -> ");
            }
            ptr = ptr.getNext();
        }
        System.out.println();
    }

}
