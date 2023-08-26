import java.util.Random;
import java.util.Scanner;

public class Lab04SortSearchAR 
{
	// DEBUGGER
	final static boolean DEBUG = true;
	// ARRAY
	final static int ARRAY_SIZE = 15;
	final static int[] myArray = new int[ARRAY_SIZE];	
	final static int[] backupArr = myArray.clone();
	static boolean isSorted = false;
	static int mergeHits = 0;
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		// USER INPUT PROMPTS
		String sChoice;
		int iChoice;
		char cData;		
		printHeader();
		// USER CHOICE CASES 
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
					createArray();
					break;
					
				case 2:
					System.out.print("Enter the element to search for: ");
                    int searchElement = scan.nextInt();
                    int linearSearchHits = linearSearch(searchElement);
	                System.out.print("Linear searching... ");
                    if (linearSearchHits != -1) 
                    {
                        System.out.println("Element found at index: " + linearSearchHits);
                    } 
                    
                    else 
                    {
                        System.out.println("Element not found.");
                    }
					break;
					
				case 3:
					 if (!(isSorted)) 
					 {
	                        System.out.println("Warning: The array is unsorted. Sort the array first.");
	                        break;
	                 }
	                 System.out.print("Enter the element to search for: ");
	                 int binarySearchElement = scan.nextInt();
	                 int binarySearchHits = binarySearch(binarySearchElement);
	                 System.out.println("Binary searching...");
	                 if (binarySearchHits != -1) 
	                 {
	                	 System.out.println("Element found at index: " + binarySearchHits);
	                 } 
	                 
	                 else 
	                 {
	                        System.out.println("Element not found.");
	                 }

					break;
					
				case 4:
					// HITS != 196, HITS == 182
					System.out.println("After using selection sort:");
                    selectionSort(myArray);
                    break;
					
				case 5:
					// HITS != 196, HITS == 55 
					System.out.println("After using insertion sort:");
					insertionSort(myArray);
					break;
					
				case 6:
					// HITS != 196, HITS == 105 
					System.out.println("After using bubble sort:");
					bubbleSort(myArray);
					break;
					
				case 7:
					System.out.println("After using bubble sort w/ short circuit:");
					bubbleSortWithShortCircuit(myArray);
					break;
					
				case 8:
			        System.out.println("After using merge sort:");
					mergeSort(myArray, 0, myArray.length - 1);
					break;
					
				case 9:
					// HITS >= 196, HITS == 139
					System.out.println("After using lucky sort:");
					luckySort();
					break;
					
				case 10:
					System.out.println("After resetting collection:");
					resetArray();
					break;
					
				case 11:
					printArray(myArray);
					break;
					
				case 12:
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
					
				case 13:
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
		} 
		while (true);
	} // end of psvm
	
	/*
	 * Display array
	 */
	public static void printArray(int[] arr) 
	{
		for(int i = 0; i < arr.length; i++) 
		{
			System.out.print(arr[i] + " | ");
		}
	}
	
	/*
	 * Bubble Sort Algorithm FROM CLASS
	 */
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
				if(DEBUG) 
				{
					printArray(arr);
					System.out.println();
				}
			}
		}
		isSorted = true;
		printArray(arr);
		System.out.println();
		System.out.println("The number of hits " +  hits);
	}

    /*
     * FOUND VIA GEEKSFORGEEKS.ORG
     * Bubble Sort with Short-Circuit Algorithm
     */
    public static void bubbleSortWithShortCircuit(int[] arr) 
    {
        int hits = 0;
        int temp;
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) 
        {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) 
            {
                hits++;
                if (arr[j] > arr[j + 1]) 
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                if(DEBUG) 
    			{
    				printArray(arr);
    				System.out.println();
    			}
            }
            if (!swapped) 
            {
                break;
            }
            
        }
		isSorted = true;
        printArray(arr);
		System.out.println();
		System.out.println("The number of hits " +  hits);
    }

    /*
     * VARIATION OF OLD METHOD FROM DSA LAB 9
     * Implements the selection sort algorithm to sort an integer array in ascending order.
     */
    public static void selectionSort(int[] arr) 
    {
        int hits = 0;
        int n = arr.length;
        for(int i = 0; i < n -1; i++) 
        {
        	int minIndex = i;
        	for(int j = i + 1; j < n; j++) 
        	{
        		hits++;
        		if(arr[j] < arr[minIndex]) 
        		{
        			minIndex = j;
        		}
        		if(DEBUG) 
    			{
    				printArray(arr);
    				System.out.println();
    			}
        	}
        	int temp = arr[i];
        	arr[i] = arr[minIndex];
        	arr[minIndex] = temp;
        }
		isSorted = true;
        printArray(arr);
		System.out.println();
		System.out.println("The number of hits " +  hits);
    }
    
    /*
     * VARIATION OF OLD METHOD FROM DSA LAB 9
     * Merge Sort Algorithm
     */
    public static void mergeSort(int[] arr, int start, int end) 
    {
        if (start < end) 
        {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
    		isSorted = true;
        }
        printArray(arr);
        System.out.println();
    }

    /*
     * VARIATION OF OLD METHOD FROM DSA LAB 9
     * Merge Helper Method
     */
    public static void merge(int[] arr, int start, int mid, int end) 
    {
        int[] leftArray = new int[mid - start + 1];
        int[] rightArray = new int[end - mid];

        // FIRST HALF
        for (int i = 0; i < leftArray.length; i++) 
        {
            leftArray[i] = arr[start + i];
            mergeHits++;
        }
        
        // SECOND HALF
        for (int i = 0; i < rightArray.length; i++) 
        {
            rightArray[i] = arr[mid + 1 + i];
            mergeHits++;
        }

        int leftIndex = 0, rightIndex = 0;
        int currentIndex = start;
        int mergeHits = 0; // Initialize hit counter for this merging process

        // ITERATION OF LEFT, RIGHT, MID INDICES
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) 
        {
        	mergeHits++;
            if (leftArray[leftIndex] <= rightArray[rightIndex]) 
            {
                arr[currentIndex] = leftArray[leftIndex];
                leftIndex++;
            } 
            else 
            {
                arr[currentIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }

        while (leftIndex < leftArray.length) 
        {
            mergeHits++;
            arr[currentIndex] = leftArray[leftIndex];
            leftIndex++;
            currentIndex++;
        }

        while (rightIndex < rightArray.length) 
        {
            mergeHits++;
            arr[currentIndex] = rightArray[rightIndex];
            rightIndex++;
            currentIndex++;
        }
        System.out.println("The number of hits " + mergeHits); // Print the hit count for this merging process
    }
    
    /* FOUND VIA GEEKSFORGEEKS.ORG / Gregory Safko Pseudocode
     * Lucky Sort Algorithm
     */
    public static void luckySort() 
    {
        int hits = 0;
        int start = 0;
        int stop = myArray.length - 1;

        for (int n = start; n <= stop; n++) 
        {
            while (true) 
            {
                hits++;
                mixArrayRange(n, stop);
                if (myArray[n] == getMinValueInArrayRange(myArray, n, stop)) 
                {
                    break;
                }
                if(DEBUG) 
    			{
    				printArray(myArray);
    				System.out.println();
    			}
            }
        }
        printArray(myArray);
		System.out.println();
		System.out.println("The number of hits " +  hits);
    }
    
    /*
     * LUCKY SORT HELPER
     * Randomizes indices
     */
    public static void mixArrayRange(int start, int end) 
    {
        Random rand = new Random();
        for (int i = start; i <= end; i++) 
        {
            int randomIndex = rand.nextInt(end - start + 1) + start;
            int temp = myArray[i];
            myArray[i] = myArray[randomIndex];
            myArray[randomIndex] = temp;
        }
    }

    /*
     * LUCKY SORT HELPER
     * Retrieves Min Val in Array
     */
    public static int getMinValueInArrayRange(int[] arr, int start, int end) 
    {
        int min = arr[start];
        for (int i = start + 1; i <= end; i++) 
        {
            if (arr[i] < min) 
            {
                min = arr[i];
            }
        }
        return min;
    }
    
    /*
     * VARIATION OF OLD METHOD FROM DSA LAB 9
     * Insertion Sort Algorithm
     */
    public static void insertionSort(int[] arr) 
    {
        int hits = 0;
        int n = arr.length;

        for (int i = 1; i < n; i++) 
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) 
            {
                hits++;
                arr[j + 1] = arr[j];
                j--;
                if(DEBUG) 
    			{
    				printArray(arr);
    				System.out.println();
    			}
            }
            arr[j + 1] = key;
        }
		isSorted = true;
        printArray(arr);
		System.out.println();
		System.out.println("The number of hits " +  hits);
    }
    
    /*
     * VARIATION OF OLD METHOD FROM DSA LAB 9
     * Linear Search Algorithm
     */
    public static int linearSearch(int target) 
    {
        int hits = 0;
        for (int i = 0; i < myArray.length; i++) 
        {
            hits++;
            if (myArray[i] == target) 
            {
                System.out.println("The number of hits: " + hits);
                return i;
            }
        }
        System.out.println("The number of hits: " + hits);
        return -1;
    }

    /*
     * VARIATION OF OLD METHOD FROM DSA LAB 9
     * Binary Search Algorithm 
     */
    public static int binarySearch(int target) 
    {
        int hits = 0;
        int left = 0;
        int right = myArray.length - 1;

        while (left <= right) 
        {
            hits++;
            int mid = left + (right - left) / 2;
            // SPLIT ARRAY INTO SECTS.
            if (myArray[mid] == target) 
            {
                System.out.println("The number of hits: " + hits);
                return mid;
            } 
            
            else if (myArray[mid] < target) 
            {
                left = mid + 1;
            } 
            
            else 
            {
                right = mid - 1;
            }
        }
        System.out.println("The number of hits: " + hits);
        return -1;
    }
    
    /*
     * Create an array of 15 random elements from 10 to 99
     */
    public static void createArray() 
    {
        Random rand = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) 
        {
        	// generate random number between 10 and 99
            int randomNum = rand.nextInt(90) + 10; 
            myArray[i] = randomNum;
            backupArr[i] = randomNum;
        }
        System.out.println("New array created.");
    }

    /*
     * Reset the array to the original elements generated from Choice 1
     */
    public static void resetArray() 
    {
        for (int i = 0; i < ARRAY_SIZE; i++) 
        {
            myArray[i] = backupArr[i];
        }
        System.out.println("Array reset to the original elements.");
    }

    /*
     * DEBUGGER FOR DEV
     */
    public static void debugger() 
    {
    	if(DEBUG) 
		{
			createArray();
			// ARRAY CREATION
			System.out.println("ARRAY BEFORE SORT(S):");
			printArray(myArray);
			System.out.println();

			// SELECTION
			System.out.println("AFTER SELECTION SORT:");
			selectionSort(myArray);
			System.out.println();
			
			// INSERTION
			System.out.println("AFTER INSERTION SORT:");
			insertionSort(myArray);
			System.out.println();
			
			// BUBBLE
			System.out.println("AFTER BUBBLESORT:");
			bubbleSort(myArray);
			System.out.println();
			
			// BUBBLE W/ SHORT CIRCUIT
			System.out.println("AFTER BUBBLESORT SHORT-CIRCUITED:");
			bubbleSortWithShortCircuit(myArray);
			System.out.println();
			
			// MERGE
			System.out.println("AFTER MERGE SORT:");
			mergeSort(myArray, 0, myArray.length - 1);
			System.out.println("The number of hits " +  mergeHits);
			System.out.println();
			
			// LUCKY
			System.out.println("AFTER LUCKY SORT:");
			luckySort();
			System.out.println();
		}				
    }
	/*
	 * Display header
	 */
	public static void printHeader()
	{
		System.out.println("Welcome to the Sorting & Searching System");
		System.out.println("Author: Antonio Rosado");
		System.out.println("Using Sorting Algorithms\n");
	} //end of method
	// end user choices
	
	/*
	 * Display menu
	 */
	public static void printMenu()
	{
		System.out.println();
		System.out.println("Select from the following menu:");
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
		System.out.println("13. DEV MODE");
	} //end of method
}
