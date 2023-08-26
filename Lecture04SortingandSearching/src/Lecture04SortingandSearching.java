import java.util.Random;
public class Lecture04SortingandSearching 
{
	final static boolean DEBUG = true;
	public static void main(String[] args) 
	{
		int[] myArray = new int[10];
		Random rand = new Random();
		int temp;
		for(int i = 0; i < myArray.length; i++) 
		{
			temp = rand.nextInt(10, 100);
			myArray[1] = temp;
		}
		printArray(myArray);
		System.out.println();
		System.out.println("Using Bubble Sort");
		bubbleSort(myArray);
		System.out.println();
		// create integer array of size 10
		// pop with two digit random numbers
	} // end of psvm
	
	public static void printArray(int[] arr) 
	{
		for(int i = 0; i < arr.length; i++) 
		{
			System.out.println(arr[i] + " | ");
		}
	}
	
	public static void bubbleSort(int[] arr) 
	{
		int hits = 0;
		int temp;
		int n = arr.length;
		for(int i = 0; i < n; i++) 
		{
			for(int j = 0; j < n - 1 - i; j++) 
			{
				hits++;
				if(arr[j] > arr[j + 1]) 
				{
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if(DEBUG) 
			{
				printArray(arr);
				System.out.println();
			}
		}
		printArray(arr);
		System.out.println();
		System.out.println("The number of hits " +  hits);
	}
	
	public static void printHeader()
	{
		System.out.println("Welcome to the Sorting & Searching System");
		System.out.println("Author: Antonio Rosado");
		System.out.println("Using Sorting Algorithms\n");
	} //end of method
	
	// end user choices
	public static void printMenu()
	{
		System.out.println("1. Create an array of 15 random elements from 10 to 99.");
		System.out.println("2. Search for an element using linear search.");
		System.out.println("3. Search for an element using binary search.");
		System.out.println("4. Sort the array using Selection Sort.");
		System.out.println("5. Sort the array using Insertion Sort.");
		System.out.println("6. Sort the array using Bubble Sort.");
		System.out.println("7. Sort the array using Bubble Sort with Short-Circuit.");
		System.out.println("8. Sort the array using Merge Sort.");
		System.out.println("9. Sort the array using Lucky Sort");
		System.out.println("10. Reset the array.");
		System.out.println("11. Print the array.");
		System.out.println("12. Quit.");


	} //end of method
}
