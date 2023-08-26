/*
 * Author: Antonio Rosado
 * Date: 7/10/23
 * Lecture 2: Linked Lists
 */
import java.util.Scanner;
public class Lecture02LinkedListsAR {
	
	public static void main(String[] args) 
	{
		final boolean DEBUG = true;
		Scanner scan = new Scanner(System.in);
		Node<Integer> iNode = new Node<Integer>();
		Node<Character> cNode = new Node<Character>();
		linkedList<Character> ll = new linkedList<Character>();
		String sChoice;
		int iChoice;
		char cData;
		int pos;
		printHeader();
	
		do 
		{
			printMenu();
			System.out.print("Enter your choice: ");
			sChoice = scan.nextLine();
			iChoice = Integer.parseInt(sChoice);
			System.out.println("You have entered " + iChoice);
			switch(iChoice) 
			{
				case 1:
					System.out.print("Enter the character to add: ");
					sChoice = scan.nextLine();
					cData = sChoice.charAt(0);
					ll.insertAtHead(cData);
					System.out.println("Element " + "'" + cData + "'" + " has been added to the head.");
					break;
					
				case 2:
					System.out.print("Enter the character to add: ");
					sChoice = scan.nextLine();
					cData = sChoice.charAt(0);
					ll.insertAtTail(cData);
					System.out.println("Element " + "'" + cData + "'" + " has been added to the tail.");
					break;
					
				case 3:
					ll.deleteHead();
					System.out.println("Head element of list has been removed.");
					break;
					
				case 4:
					ll.deleteTail();
					System.out.println("Tail element of list has been removed.");
					break;

				case 5:
					cData = (char) ll.getAtPos(0);
					System.out.println("Item at head is " + "'" + cData + "'");
					break;

				case 6:
					char tailData = ll.getAtPos(ll.size - 1);
					System.out.println("Item at tail is " + "'" + tailData + "'");
					break;

				case 7:
					System.out.print("Enter the character to add: ");
					sChoice = scan.nextLine();
					System.out.print("Enter the position to add the element in: ");
					String position = scan.nextLine();
					pos = Integer.parseInt(position);
					cData = sChoice.charAt(0);
					ll.insertAtPos(cData, pos);
					System.out.println("Element " + "'" + cData + "'" + " has been added to position " 
					+ pos + " in the Linked List.");
					break;

				case 8:
					System.out.print("Enter the position to remove an element from: ");
					sChoice = scan.nextLine();
					pos = Integer.parseInt(sChoice);
					cData = sChoice.charAt(pos);
					System.out.println("Element at position " + cData + " has been removed.");
					ll.deleteAtPos(pos);
					break;

				case 9:
					System.out.print("Enter the position to examine an element at: ");
					sChoice = scan.nextLine();
					pos = Integer.parseInt(sChoice);
					cData = sChoice.charAt(pos);
					char posChar = ll.getAtPos(pos);
					System.out.println("Element " + "'" + posChar + "'" + " is at position " + pos + ".");
					break;

				case 10:
					if(ll.isEmpty()) 
					{
						System.out.println("Linked List is empty.");
					}
					
					else 
					{
						System.out.println("Linked List is not empty.");
					}
					break;

				case 11:
					if(!ll.isEmpty()) 
					{
						int size = ll.getSize();
						System.out.println("Size of Linked List is: " + size);
					}
					else 
					{
						System.out.println("Linked List is empty.");
					}
					break;

				case 12:
					System.out.println("Clearing content of Linked List...");
					ll = null;
					if (ll == null) 
					{
						System.out.println("Linked List cleared.");
					}
					break;

				case 13:
					if(ll.isEmpty()) 
					{
						System.out.println("Linked List is empty.");
					}
					else 
					{
						ll.printList();
					}
					break;

				case 14:
					System.out.print("Are you sure you want to quit? [Y/N]");
					cData = scan.nextLine().toUpperCase().charAt(0);
					if(cData == 'Y') 
					{
						System.out.println("Quitting...");
						scan.close();
						System.exit(0);
					}
					break;
				
				default:
					System.out.println("Invalid selection, try again.");
					break;

			}
		} while(true);
	} // end of psvm
	
	public static void printHeader() 
	{
		System.out.println("Welcome to the Linked List Menu System \n"
				+ "Author: Antonio Rosado \n"
				+ "Using Singly Linked Lists \n");
	}
	
	public static void printMenu() 
	{
		System.out.println("Select from the following menu: \n"
				+ "1. Place an element at the head of the Linked List \n"
				+ "2. Place an element at the tail of the Linked List \n"
				+ "3. Remove an element from the head of the Linked List \n"
				+ "4. Remove an element from the tail of the Linked List \n"
				+ "5. Examine the element at the head of the Linked List \n"
				+ "6. Examing the element at the tail of the Linked List \n"
				+ "7. Place an element at a given position in the Linked List \n"
				+ "8. Remove an element at a given position in the Linked list \n"
				+ "9. Examine an element at a given position in the Linked List \n"
				+ "10. Check if the Linked List is empty. \n"
				+ "11. Get the current size of the Linked List. \n"
				+ "12. Clear the contents of the Linked List \n"
				+ "13. Print the contents of the Linked List \n"
				+ "14. Quit");
	}
} // end of class