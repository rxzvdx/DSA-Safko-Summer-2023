import java.util.ArrayList;

// DOUBLY ENDED QUEUE
public class Deque<T>
{
	private ArrayList<T> dq;
	
	public Deque() 
	{
		dq = new ArrayList<T>();
	}
	
	// push/pop/top/size/isEmpty/print-display
	
	public void pushFront(T item) 
	{
		dq.add(0, item);
	}	
	
	public void pushBack(T item) 
	{
		dq.add(item);
	}
	
	public boolean popFront() 
	{
		if(!dq.isEmpty())
		{
			dq.remove(0);
			return true;
		}
		return false;
		
	}
	
	public boolean popBack() 
	{
		if(!dq.isEmpty())
		{
			dq.remove(dq.size() - 1);
			return true;
		}
		return false;
	}
	
	public T topFront() 
	{
		if(!dq.isEmpty()) 
		{
			return dq.get(0);
		}
		return null;
	}
	
	public T topBack() 
	{
		if(!dq.isEmpty()) 
		{
			return dq.get(dq.size() - 1);
		}
		return null;
	}
	
	public T peekFront() 
	{
		return topFront();
	}
	
	public T peekBack() 
	{
		return topBack();
	}
	
	public int size() 
	{
		return dq.size();
	}
	
	public boolean isEmpty() 
	{
		return dq.isEmpty();
		
	}
	
	public void print() 
	{
		System.out.print(toString());
	}
	
	@Override
	public String toString() 
	{
		return "Front -> " + dq + " <- Back";
	}
	
}
