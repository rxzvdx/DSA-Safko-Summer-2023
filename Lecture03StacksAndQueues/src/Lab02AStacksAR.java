/*
 * Author: Antonio Rosado
 * Lab 02a: Stacks
 */
import java.util.Scanner;
public class Lab02AStacksAR 
{
	public static void main(String[] args)
	{
		Stack<Character> stk1 = new Stack<Character>();
		Scanner scan = new Scanner(System.in);
		final boolean DEBUG = true;
		String sChoice;
		int iChoice;
		char cData;
		
		// DEBUGGING OPTION FOR DEV
		if(DEBUG)
		{
			stk1.push('&');
			stk1.push('M');
			stk1.push('@');
			stk1.push('z');
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
					stk1.push(cData);
					System.out.println("Element added to the stack.");
					break;
					
				case 2:
					if(stk1.isEmpty())
					{
						System.out.println("The stack is empty.");
					}
					else
					{
						System.out.println("The top of the stack contains: " + stk1.top());
					}
					break;
					
				case 3:
					if (stk1.isEmpty())
					{
						System.out.println("Cannot pop: the stack is empty.");
					}
					else
					{
						stk1.pop();
						System.out.println("Element was popped.");
					}
					break;
					
				case 4:
					if (stk1.isEmpty())
					{
						System.out.println("The stack is empty.");
					}
					else
					{
						System.out.println("The stack is not empty.");
					}
					break;
					
				case 5:
					System.out.println("Stack size: " + stk1.getSize());
					break;
					
				case 6:
					if (stk1.isEmpty())
					{
						System.out.println("Nothing to print: the stack is empty.");
					}
					else
					{
						stk1.print();
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
		System.out.println("Welcome to the Stack Menu System");
		System.out.println("Author: Antonio Rosado");
		System.out.println("Using Linked Lists\n");
	} //end of method
	
	// end user choices
	public static void printMenu()
	{
		System.out.println("1. Push an element on the stack");
		System.out.println("2. Peek at an element on the stack");
		System.out.println("3. Pop an element from the stack");
		System.out.println("4. Check if the stack is empty");
		System.out.println("5. Get the size of the stack");
		System.out.println("6. Print the contents of the stack");
		System.out.println("7. Quit");

	} //end of method
} // end of class
