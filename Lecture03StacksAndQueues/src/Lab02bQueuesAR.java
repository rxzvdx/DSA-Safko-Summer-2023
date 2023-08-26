/*
 * Author: Antonio Rosado
 * Lab 02b: Queues
 */
import java.util.Scanner;
public class Lab02bQueuesAR 
{
	public static void main(String[] args)
	{
		Queue<Character> que1 = new Queue<Character>();
		Scanner scan = new Scanner(System.in);
		final boolean DEBUG = true;
		String sChoice;
		int iChoice;
		char cData;
		
		// DEBUGGING OPTION FOR DEV
		if(DEBUG)
		{
			que1.pushFront('&');
			que1.pushFront('M');
			que1.pushFront('@');
			que1.pushFront('z');
		}
		printHeader();
		
		do
		{
			printMenu();
			System.out.print("Enter your choice: ");
			sChoice = scan.next();
			iChoice = Integer.parseInt(sChoice);
			System.out.println("You have entered " + iChoice);
			switch(iChoice)
			{
				case 1:
					System.out.println("Enter the character to add: ");
					sChoice = scan.next();
					cData = sChoice.charAt(0);
					que1.pushFront(cData);
					System.out.println("Element added to the queue.");
					break;
					
				case 2:
					if(que1.isEmpty())
					{
						System.out.println("The queue is empty.");
					}
					else
					{
						System.out.println("The top of the queue contains: " + que1.top());
					}
					break;
					
				case 3:
					if (que1.isEmpty())
					{
						System.out.println("Cannot pop: the queue is empty.");
					}
					else
					{
						que1.popBack();
						System.out.println("Element was popped.");
					}
					break;
					
				case 4:
					if (que1.isEmpty())
					{
						System.out.println("The queue is empty.");
					}
					else
					{
						System.out.println("The queue is not empty.");
					}
					break;
					
				case 5:
					System.out.println("queue size: " + que1.getSize());
					break;
					
				case 6:
					if (que1.isEmpty())
					{
						System.out.println("Nothing to print: the queue is empty.");
					}
					else
					{
						que1.print();
					}
					break;
					
				case 7:
					System.out.println("Are you sure you want to quit? [Y/N]");
					cData = scan.next().toUpperCase().charAt(0);
					if (cData == 'Y')
					{
						System.out.println("Exiting the menu, goodbye.");
						scan.close();
						System.exit(0);
						break;
					}
					break;
					
				default:
					System.out.println("Invalid choice. Try again.");
					break;
			}
		} 
		while (true);
	} //end of psvm

	public static void printHeader()
	{
		System.out.println("Welcome to the queue Menu System");
		System.out.println("Author: Antonio Rosado");
		System.out.println("Using Linked Lists\n");
	} //end of method
	
	// end user choices
	public static void printMenu()
	{
		System.out.println("1. Push an element onto the queue");
		System.out.println("2. Peek at an element on the queue");
		System.out.println("3. Pop an element from the queue");
		System.out.println("4. Check if the queue is empty");
		System.out.println("5. Get the size of the queue");
		System.out.println("6. Print the contents of the queue");
		System.out.println("7. Quit");

	} //end of method
} // end of class
