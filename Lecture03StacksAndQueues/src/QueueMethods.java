public interface QueueMethods<T> 
{
	public void push(T val);
	public void pop();
	public T peek();
	public T top();
	public void pushFront(T val);
	public void popFront();
	public T peekFront();
	public void pushBack();
	public void popBack();
	public T peekBack();	
}
