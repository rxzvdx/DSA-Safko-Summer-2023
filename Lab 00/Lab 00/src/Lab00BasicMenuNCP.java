import java.util.ArrayList;
import java.util.Scanner;

public class Lab00BasicMenuNCP 
{

	public static void main(String[] args) 
	{
		final boolean DEBUG = true;
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> myList = new ArrayList<Integer>();
		int choice; 
		int data;
		int pos;y
		if(DEBUG) 
		{
			myList.add(17);
			myList.add(19);
			myList.add(23);
			myList.add(11);
			myList.add(91);
		}
		do 
		{
			System.out.println("A Basic Menu System");
			System.out.println("1. Add an item");
			System.out.println("2. Change an item");
			System.out.println("3. Delete an item");
			System.out.println("4. Print the list");
			System.out.println("99. Quit\n");

			System.out.print("Enter your choice: ");
			choice = scan.nextInt();
			System.out.println("You have entered " + choice);
			
			switch(choice) 
			{
				case 1:
						System.out.print("Enter the integer you want to add: ");
						data = scan.nextInt();
						myList.add(data);
						break;
				
				case 2:
						System.out.print("Enter the integer you wish to change: ");
						pos = scan.nextInt();
						if(pos > myList.size() || pos < 0) 
						{
							System.out.println("Position does not exist. ");
							break;

						}
				
				case 3:
						System.out.print("Enter the integer you want to delete: ");
						pos = scan.nextInt();
						if(pos > myList.size() || pos < 0) 
						{
							System.out.println("Invalid position.");
							break;
						}
						myList.remove(pos);
						System.out.println("Data at position " + pos + " has been deleted.");
						break;
					
				case 4:
						System.out.println("The list is:");
						System.out.println(myList);
						break;
						
				case 99:
						System.out.println("Are you sure you want to quit?");
						System.out.print("1 for Yes, 2 for No");
						pos = scan.nextInt();
						if(pos == 1) 
						{
							System.out.println("Exiting the menu. Goodbye.");
							System.exit(0);
							break;
						}
						break;
				
				default:
						System.out.println("Invalid choice. Try again.");
						break;
			}
		}while (true);
	}// end of psvm
}// end of class
