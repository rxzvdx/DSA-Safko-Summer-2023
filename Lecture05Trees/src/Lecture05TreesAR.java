import java.util.Scanner;
// TO REMOVE TRAILING COMMA
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lecture05TreesAR 
{
	// DEBUGGER
	final static boolean DEBUG = true;
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		// USER INPUT PROMPTS
		String sChoice;
		int iChoice;
		char cData;		
		// TREE
		Tree BST = new Tree();
		// PRE POPULATED ARRAY W/ TEST VALS
		if(DEBUG)
		{
			int[] prePopulated = new int[] {61, 66, 48, 70, 75, 59, 60, 49, 51, 52};
			for(int item : prePopulated)
			{
				BST.add(item);
			}
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
				System.out.print("Enter the item you would like to add to the Tree: ");
				int input = scan.nextInt();
				if(BST.contains(input)) 
				{
					System.out.println("Item already exists on the tree! Enter a different value.");
				}

				else 
				{
					BST.add(input);
					System.out.println("Successfully added " + input);
				}
				break;

			case 2:
				System.out.print("Enter the item you would like to find in the Tree: ");
				int search = scan.nextInt();
				if(BST.contains(search)&& (BST.find(search) != null)) 
				{
					System.out.println("BST contains item " + "'" + search + "'.");
				}

				else 
				{
					System.out.println("BST does not contain item " + "'" + search + "'.");
				}
				break;

			case 3:
				System.out.print("Enter the item you would like to remove from the Tree: ");
				int removed = scan.nextInt();
				if(BST.contains(removed)) 
				{
					System.out.println("Item " +  "'" + removed + "'" + " successfully removed.");
					BST.remove(removed);
				}

				else 
				{
					System.out.println("BST does not contain item " + "' " + removed + "'");
				}

				if(BST.isEmpty()) 
				{
					System.out.println("BST is empty, no items to remove.");
				}
				break;

			case 4:
				System.out.println("Count of node is: " + BST.countNodes());
				break;

			case 5:
				System.out.println("BST height is: " + BST.getHeight()); 
				break;

			case 6:	
				System.out.println("Largest element on the tree is: " + BST.findMax());
				break;

			case 7:
				System.out.println("Sum of the elements: " + BST.getSum());
				break;

			case 8:
				System.out.println("Average of the elements: " + BST.findAverage());
				break;

			case 9:
				System.out.print("Enter the ancestor: ");
				int ancestor = scan.nextInt();
				System.out.print("Enter the descendent: ");
				int descendant = scan.nextInt();
				if(BST.findIfAncestor(ancestor, descendant)) 
				{
					System.out.println(ancestor + " IS an ancestor of " + descendant);
				}

				else 
				{
					System.out.println(ancestor + " IS NOT an ancestor of " + descendant);
				}
				break;

			case 10:
				System.out.println("Printing the Tree (Pre-Order):");
				String preOrder = getPreOrder(BST);
				System.out.println(preOrder);
				break;

			case 11:
				System.out.println("Printing the Tree (Post-Order):");
				String postOrder = getPostOrder(BST);
				System.out.println(postOrder);
				break;

			case 12:
				System.out.println("Printing the Tree (In-Order):");
				String inOrder = getInOrder(BST);
				System.out.println(inOrder);
				break;

			case 13:
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
		}while(true);
	}
	
	/*
	 * STORE INPUT PREORDER FOR TRAILING COMMAS
	 */
	private static String getPreOrder(Tree BST) 
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream oldOut = System.out;
		System.setOut(ps);
		BST.PreOrderTraversal();
		System.out.flush();
		System.setOut(oldOut);
		String result = baos.toString();
		return removeTrailingComma(result);
	}

	/*
	 * STORE INPUT POSTORDER FOR TRAILING COMMAS
	 */
	private static String getPostOrder(Tree BST) 
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream oldOut = System.out;
		System.setOut(ps);
		BST.postOrderTraversal();
		System.out.flush();
		System.setOut(oldOut);
		String result = baos.toString();
		return removeTrailingComma(result);
	}

	/*
	 * STORE INPUT INORDER FOR TRAILING COMMAS
	 */
	private static String getInOrder(Tree BST) 
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream oldOut = System.out;
		System.setOut(ps);
		BST.inOrderTraversal();
		System.out.flush();
		System.setOut(oldOut);
		String result = baos.toString();
		return removeTrailingComma(result);
	}

	private static String removeTrailingComma(String input) 
	{
		// Use regex to remove trailing comma
		Pattern pattern = Pattern.compile(",\\s*$");
		Matcher matcher = pattern.matcher(input);
		return matcher.replaceFirst("");
	}

	/*
	 * Display header
	 */
	public static void printHeader()
	{
		System.out.println("Welcome to Trees");
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
		System.out.println("1. Add an item to the tree.");
		System.out.println("2. Find an item on the tree.");
		System.out.println("3. Remove an item from the tree.");
		System.out.println("4. Count the nodes on the tree.");
		System.out.println("5. Compute the tree height.");
		System.out.println("6. Find the largest element on the tree.");
		System.out.println("7. Find the sum of the elements.");
		System.out.println("8. Find the average of the elements.");
		System.out.println("9. Find if one element is an ancestor of another.");
		System.out.println("10. Print the Tree (Pre-Order).");
		System.out.println("11. Print the Tree (Post-Order)");
		System.out.println("12. Print the Tree (In-Order).");
		System.out.println("13. Quit.");
	} //end of method
}
