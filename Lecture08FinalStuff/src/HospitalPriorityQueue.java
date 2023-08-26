import java.util.ArrayList;

public class HospitalPriorityQueue<T extends Comparable<T>>
{
	/*
	 * Use an ArrayList as the collection vehicle
	 * Position 0 is max value, pos (size - 1) is min
	 * pop/peek at 0, push at (size - 1)
	 * This is Min Value Priority Queue (max at left, lower at right)
	 * EX: 31, 26, 17, 0, -4
	 * EX: "Br", "Xn", "ae", "etz", "xyz" -> ascii (66, 88, 97, 101, 120 {roughly})
	 */
	private ArrayList<T> pq = new ArrayList<T>();

	public HospitalPriorityQueue()
	{

	}

	public void push(T patient) 
	{
		// if the list is empty, just add the patient
		if(pq.isEmpty()) 
		{
			pq.add(patient);
			return;
		}

		// if the patient is larger than pos(0), add it to pos(0)
		if(patient.compareTo(pq.get(0)) < 0) 
		{
			pq.add(0, patient);
			return;
		}

		// if the patient is smaller than pos (size - 1), add to end
		if(patient.compareTo(pq.get(pq.size() - 1)) > 0) 
		{
			pq.add(patient);
			return;
		}

		// otherwise, traverse from back to front (size - 1) to 0
		// and place it where p(x) >= patient > p(x - 1)
		for(int i = pq.size() - 1; i > 0; i--) 
		{
			if(patient.compareTo(pq.get(i)) <= 0 && patient.compareTo(pq.get(i - 1)) > 0) 
			{
				pq.add(i, patient);
			}
		}
	}

	public void pop()
	{
		pq.remove(0);
	}

	public T top()
	{
		return pq.get(0);
	}

	public T peek()
	{
		return top();
	}

	public void print()
	{

		for (T patient : pq) 
		{
			System.out.print(patient);
		}
	}
}
