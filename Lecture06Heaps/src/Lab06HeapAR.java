import java.util.Scanner;

public class Lab06HeapAR 
{
	final static boolean DEBUG = true;
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		// USER INPUT PROMPTS
		String sChoice;
		int iChoice;
		char cData;	
		MaxPriorityQueue mpq = new MaxPriorityQueue();
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
				System.out.print("Enter the element you would like to add to the Heap: ");
				int input = scan.nextInt();
				mpq.add(input);
				System.out.println("Successfully added " + input);
				break;

			case 2:
				if(!mpq.isEmpty()) 
				{
					mpq.pop();
					System.out.println("Top element removed.");
				}

				else 
				{
					System.out.println("Nothing to find, heap is empty!");
				}
				break;

			case 3:
				System.out.print("Enter the element you would like to remove from the Heap: ");
				int removed = scan.nextInt();
				if(!mpq.isEmpty())
				{
					if (mpq.findElement(removed)) 
					{
						System.out.println("Element " + removed + " removed.");
						mpq.removeElement(removed);
					} 

					else 
					{
						System.out.println("Element " + removed + " not found in the heap.");
					}
				}

				else 
				{
					System.out.println("Nothing to remove, heap is empty!");
				}
				break;

			case 4:
				System.out.print("Enter the element you would like to find: ");
				int elementToFind = scan.nextInt();
				if(!mpq.isEmpty())
				{
					if(mpq.findElement(elementToFind))
					{
						System.out.println("Element " + elementToFind + " found.");
					}

					else 
					{
						System.out.println("Element " + elementToFind + " not found.");
					}
				}

				else 
				{
					System.out.println("Nothing to find, heap is empty!");
				}
				break;

			case 5:
				System.out.print("Enter an element: ");
				elementToFind = scan.nextInt();
				if(!mpq.isEmpty())
				{
					mpq.findChildren(elementToFind);
				}

				else 
				{
					System.out.println("Nothing to find, heap is empty!");
				}
				break;

			case 6:
				System.out.print("Enter an element: ");
				elementToFind = scan.nextInt();
				if(!mpq.isEmpty())
				{
					mpq.findParent(elementToFind);
				}

				else 
				{
					System.out.println("Nothing to find, heap is empty!");
				}
				break; 

			case 7:
				if(!mpq.isEmpty())
				{
					System.out.println("Heap content:");
					mpq.print();
				}

				else 
				{
					System.out.println("Heap is empty.");
				}
				break;

			case 8:
				if(!mpq.isEmpty()) 
				{
					mpq.clear();
					System.out.println("Heap cleared.");
				}

				else 
				{
					System.out.println("Heap is already clear.");
				}
				break;

			case 9:
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

			case 10:
				System.out.println("[Enter pass key]: ");
				cData = scan.next().toUpperCase().charAt(0);
				if (cData == '$')
				{
					debugger();					
				}		
				else 
				{
					System.out.println("Incorrect pass key.");
					System.out.println("Exiting the menu, goodbye.");
					scan.close();
					System.exit(0);
				}				
				break;

			default:
				System.out.println("Invalid choice. Try again.");
				break;
			}
		}while(true);
	}
	/*
	 * DEBUGGER FOR DEV
	 */
	private static void debugger() 
	{
		if(DEBUG) 
		{
			MaxPriorityQueue mpq = new MaxPriorityQueue();
			// 75, 65, 68, 42, 40, 38, 32, 11, 21
			// ADD ELEMENTS
			mpq.add(75);
			mpq.add(65);
			mpq.add(68);
			mpq.add(42);
			mpq.add(40);
			mpq.add(38);
			mpq.add(32);
			mpq.add(11);
			mpq.add(21);
			// DISPLAY
			mpq.print();
			// FIND CHILDREN/PARENT
			mpq.findChildren(68);
			mpq.findChildren(40);
			mpq.findChildren(400); // DNE
			mpq.findParent(42);
			mpq.findParent(9000);
			// REMOVE ROOT
			mpq.pop();
			mpq.print();
			// REMOVE ELEMENT
			mpq.removeElement(68);
			mpq.removeElement(904); // DNE
			mpq.print();
			// FIND ELEMENT
			mpq.findElement(100); // DNE
			mpq.findElement(42);
			// CLEAR
			mpq.clear();
			mpq.print();

		}
	}

	/*
	 * Display header
	 */
	public static void printHeader()
	{
		System.out.println("Welcome to the Max Heap Program");
		System.out.println("Author: Antonio Rosado");
	} //end of method
	// end user choices

	/*
	 * Display menu
	 */
	public static void printMenu()
	{
		System.out.println();
		System.out.println("Select from the following menu:");
		System.out.println("1. Add an element.");
		System.out.println("2. Remove the top (root).");
		System.out.println("3. Remove an element.");
		System.out.println("4. Find an element.");
		System.out.println("5. Find the children of an element.");
		System.out.println("6. Find the parent of an element");
		System.out.println("7. Print the heap.");
		System.out.println("8. Clear the heap.");
		System.out.println("9. Quit.");
		System.out.println("10. DEV MODE.");

	} //end of method
}
