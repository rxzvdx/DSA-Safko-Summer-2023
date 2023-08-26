/*
 * Author: Antonio Rosado
 * Lab 02a: Stacks
 */
public class Stack <T>
{
	protected Node<T> head;
	protected Node<T> tail;
	public int size;
	
	// constructor
	public Stack() 
	{
		head = null; 
		tail = null;
		size = 0;
	}
	
	/*
	 * isEmpty() 			DONE
	 * getSize() 			DONE
	 * push/insertAtTail() 	DONE
	 * pop/deleteAtTail() 	DONE
	 * peek()				DONE
	 * top()				DONE
	 * print()				DONE
	 */
	
	public boolean isEmpty() 
	{
		return head == null;
	}
	
	public int getSize() 
	{
		return size;
	}
	
	// push/insertAtTail
	public void push(T data) 
	{
		Node<T> nptr = new Node<T>(data, null);
		if(head == null) 
		{
			head = nptr;
			tail = head;
		}
		else 
		{
			tail.setNext(nptr);
			tail = nptr;
		}
		size++;
	}
	
	// pop/deleteTail
	public void pop() 
	{
		if(head == tail) 
		{
			head = tail = null;
			size = 0;
			return;
		}
		
		Node<T> tmp = head;
		while(tmp.next != null) 
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
	
	// view top of stack
	public T peek() 
	{
		return tail.getData();
	}
	
	public T top() 
	{
		return peek();
	}
	
	public void print() 
	{
		if(size == 0) 
		{
			System.out.println("Stack is empty.");
			return;
		}
		System.out.println("Stack elements: ");
		Node<T> ptr = head;
		while(ptr != null) 
		{
			System.out.println(ptr.getData());
			if(ptr.getNext() != null) 
			{
				System.out.println(" - > ");
			}
			ptr = ptr.getNext();
		}
		System.out.println();
	}
}
