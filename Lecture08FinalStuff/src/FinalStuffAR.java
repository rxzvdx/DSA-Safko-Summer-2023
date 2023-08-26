import java.util.Scanner;

public class FinalStuffAR 
{
	static final boolean DEBUG = true;
	static Scanner scan = new Scanner(System.in);
	static PriorityQueueAR<String> pq = new PriorityQueueAR<String>();
	static int choice;
	static String sChoice;
	static String data;

	public static void main(String[] args) 
	{
		printHeader();
		if(DEBUG) 
		{
			pq.push("Bob");
			pq.push("Tina");
			pq.push("Tina");
			pq.push("Andy");
			pq.push("Mort");
			pq.push("Linda");
			pq.push("Mort");
			pq.push("Tina");
			pq.push("Bob");
		}
		System.out.println("Final stuff...");
		do 
		{
			printMenu();
			System.out.print("Enter your choice: ");
			sChoice = scan.nextLine();
			choice = Integer.parseInt(sChoice);
			System.out.println("You have entered " + choice);
			switch(choice) 
			{
				case 1:
					System.out.print("Enter a String: ");
					data = scan.nextLine();
					pq.push(data);
					System.out.println(data + " added to the Priority Queue.");
					break;
				
				case 2:
					if(pq != null)
					{
						System.out.println("Item at front of Priority Queue is " + "'" + pq.peek() + "'.");
					}
					
					else 
					{
						System.out.println("Error: Priority Queue is null.");
					}
					break;
				
				case 3:
					if(pq != null)
					{
						System.out.println(data + " removed from the Priority Queue.");
						pq.pop();
					}
					
					else 
					{
						System.out.println("Error: Priority Queue is null.");

					}
					break;
				
				case 4:
					if(pq != null)
					{
						System.out.println("The contents are: ");
						System.out.println(pq);
					}
					
					else 
					{
						System.out.println("Error: Priority Queue is null.");
					}
					break;
				
				case 99:
					System.out.print("Are you sure you want to quit? \n" 
							+ "1. Yes \n" 
							+ "2. No \n");
					sChoice = scan.nextLine();
					int pos = Integer.parseInt(sChoice);
					if(pos == 1) 
					{
						System.out.println("Exiting the menu, goodbye.");
						scan.close();
						System.exit(0);
						break;
					}
					
					if(pos == 2) 
					{
						break;
					}
					break;
					
				default:
					System.out.println("Invalid choice. Try again.");
					break;
			}
		}while(true);	
	}
	
	public static void printHeader()
	{
		System.out.println("Final Exam Stuff.");
		System.out.println("Author: Antonio Rosado");
	} 
	
	public static void printMenu() 
	{
		System.out.println();
		System.out.println("A Priority Queue Menu System");
		System.out.println("Select from the following menu:");
		System.out.println("1. Push an item.");
		System.out.println("2. Peek an item.");
		System.out.println("3. Remove an item (pop).");
		System.out.println("4. Print the queue.");
		System.out.println("99. Quit.");
	}
}
