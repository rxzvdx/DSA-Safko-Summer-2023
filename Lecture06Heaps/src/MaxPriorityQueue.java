import java.util.ArrayList;
import java.util.Collections;

/*
 * isEmpty()				SOURCE: SELF
 * add(int val)				SOURCE: SELF
 * heapifyUp(int index)		SOURCE: GEEKFORGEEKS.ORG
 * pop()					SOURCE: SELF/CLASS
 * top()					SOURCE: SELF/CLASS
 * findElement(int val)		SOURCE: SELF/CLASS
 * removeElement(int val)	SOURCE: SELF
 * print()					SOURCE: HELP FROM GEEKSFORGEEKS.ORG PROGRAM
 * clear()					SOURCE: SELF
 * findChildren(int val)	SOURCE: SELF/STACKOVERFLOW.COM
 * findParent(int val)		SOURCE: SELF/STACKOVERFLOW.COM
 */
/**
 * A class representing a Max Priority Queue.
 */
public class MaxPriorityQueue 
{
	private ArrayList<Integer> maxpq = new ArrayList<>();

	/**
	 * Constructs an empty MaxPriorityQueue.
	 */
	public MaxPriorityQueue()
	{

	}

	/**
	 * Checks if the priority queue is empty.
	 *
	 * @return True if the priority queue is empty, otherwise false.
	 */
	public boolean isEmpty() 
	{
		return maxpq.isEmpty();
	}

	/**
	 * Adds the specified integer value to the priority queue.
	 *
	 * @param val The integer value to be added to the priority queue.
	 */
	public void add(int val) 
	{
		maxpq.add(val);
		heapifyUp(maxpq.size() - 1);
	}

	/**
	 * Performs the heapify-up operation on the heap, starting from the given index.
	 * This operation ensures that the heap property is maintained by moving the element up the heap,
	 * as long as it is larger than its parent.
	 *
	 * @param index The index of the element that needs to be heapified-up.
	 */
	private void heapifyUp(int index) 
	{
		int parentIndex = (index - 1) / 2;
		while (index > 0 && maxpq.get(index) > maxpq.get(parentIndex)) 
		{
			Collections.swap(maxpq, index, parentIndex);
			index = parentIndex;
			parentIndex = (index - 1) / 2;
		}
	}

	/**
	 * Removes the maximum element from the priority queue.
	 */
	public void pop() // remove at pos 0
	{
		if (!maxpq.isEmpty()) 
		{
			maxpq.remove(0);
		}
	}

	/**
	 * Returns the maximum element in the priority queue without removing it.
	 *
	 * @return The maximum element in the priority queue, or -99 if the queue is empty.
	 */
	public int top() // return at pos 0
	{
		if (!maxpq.isEmpty()) 
		{
			return maxpq.get(0);
		}
		return -99; // Return some appropriate default value when the queue is empty
	}

	/**
	 * Checks if a given element exists in the priority queue.
	 *
	 * @param val The element to be searched for.
	 * @return True if the element exists, otherwise false.
	 */
	public boolean findElement(int val)
	{
		return maxpq.contains(val);
	}

	/**
	 * Removes the first occurrence of the specified value from the Max Priority Queue.
	 * If the value is found, it is removed and the heap property is restored.
	 * If the value is not found, a message indicating its absence is printed.
	 *
	 * @param val The value to be removed from the Max Priority Queue.
	 */
	public void removeElement(int val) 
	{
		if(maxpq.contains(val))
		{
			maxpq.remove(maxpq.indexOf(val));
		}

		else 
		{
			System.out.println("Element " + val + " is not in the heap.");
		}
	}

	/**
	 * Prints the elements of the priority queue in a tree-like structure.
	 */
	public void print() 
	{
		if (maxpq.isEmpty()) 
		{
			System.out.println("The heap is empty.");
			return;
		}

		int level = 0;
		int elementsInLevel = 1;
		int elementsPrinted = 0;

		for (int i = 0; i < maxpq.size(); i++) 
		{
			if (elementsPrinted == elementsInLevel) 
			{
				System.out.println(); // Print a new line after each level
				level++;
				elementsInLevel = (int) Math.pow(2, level);
				elementsPrinted = 0;
			}

			System.out.print(maxpq.get(i) + " ");
			elementsPrinted++;
		}
		System.out.println(); // Print a new line at the end
	}

	/**
	 * Removes all elements from the priority queue.
	 */
	public void clear() 
	{
		maxpq.clear();
	}

	/**
	 * Finds and prints the children of a specified element in the priority queue.
	 *
	 * @param val The element whose children are to be found.
	 */
	public void findChildren(int val) 
	{
		int parentIndex = maxpq.indexOf(val);

		if (parentIndex == -1) 
		{
			System.out.println("Element is not in heap.");
			return;
		}

		int leftChildIndex = 2 * parentIndex + 1;
		int rightChildIndex = 2 * parentIndex + 2;

		if (leftChildIndex >= maxpq.size()) 
		{
			System.out.println("There are no children.");
			return;
		}

		System.out.print("The child" + (rightChildIndex < maxpq.size() ? "ren are: " : " is: "));

		System.out.print(maxpq.get(leftChildIndex));

		if (rightChildIndex < maxpq.size()) 
		{
			System.out.print(" and " + maxpq.get(rightChildIndex));
		}
		System.out.println();
	}


	/**
	 * Finds and prints the parent of a specified element in the priority queue.
	 *
	 * @param val The element whose parent is to be found.
	 * @return True if the element has a parent, otherwise false.
	 */
	public int findParent(int val) {
		int childIndex = maxpq.indexOf(val);

		if (childIndex == -1) 
		{
			System.out.println("Element is not in heap.");
			return -1; // Return a sentinel value to indicate not found
		}

		int parentIndex = (childIndex - 1) / 2;
		if (parentIndex >= 0 && parentIndex < maxpq.size()) 
		{
			int parentValue = maxpq.get(parentIndex);
			System.out.println("The parent is " + parentValue);
			return parentValue; // Return the parent value
		} 
		else 
		{
			System.out.println("There is no parent.");
			return -1; // Return a sentinel value if parent index is out of bounds
		}
	}

}
