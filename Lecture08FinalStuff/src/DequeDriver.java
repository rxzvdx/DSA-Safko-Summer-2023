
public class DequeDriver 
{

	public static void main(String[] args) 
	{
		Deque<String> SP = new Deque<String>();
		SP.print();
		
		System.out.println();
		SP.pushFront("Kyle");
		SP.print();
		
		System.out.println();
		SP.pushFront("Kenny");
		SP.print();
		
		System.out.println();
		SP.pushBack("Cartman");
		SP.print();
		
		System.out.println();
		System.out.println(SP.topBack());
		
		SP.print();
		System.out.println();
		
		SP.pushFront("Bart");
		SP.print();
		
		System.out.println();
		SP.pushBack("Butters");
		SP.print();
		
		System.out.println();
		SP.pushFront("Stan");
		SP.print();
		
		System.out.println();
		SP.pushBack("Wendy");
		SP.print();
		System.out.println();
		
        // loop thorugh and empty the list from the front
		// display each removed item
		System.out.println();
//		// REMOVE FRONT
//		System.out.println("Removing front items...");
//		SP.print();
//		System.out.println();
//		while(SP.topFront() != null)
//		{
//			System.out.println("Item: " + SP.topFront() + " removed.");
//			SP.popFront();
//			SP.print();
//			System.out.println();
//		}
		
		// FIND MIDDLE WHILE REMOVING SURROUNDING ELEMENTS
		while((SP.topFront() != null) && (SP.topBack() != null))
		{
			if(SP.size() != 1)
			{
				System.out.println("Item: " + SP.topFront() + " removed.");
				SP.popFront();
				System.out.println("Item: " + SP.topBack() + " removed.");
				SP.popBack();
				SP.print();
				System.out.println();
			}
			else 
			{
				System.out.println("Middle -> " + SP.peekFront());
				break;
			}
		}
	}
}
