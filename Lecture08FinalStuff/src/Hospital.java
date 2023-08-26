import java.util.Scanner;

public class Hospital 
{
	static final boolean DEBUG = true;
	static Scanner scan = new Scanner(System.in);
	static HospitalPriorityQueue<Patient> hpq = new HospitalPriorityQueue<Patient>();
	static int choice;
	static String sChoice;
	static String data;

	public static void main(String[] args) 
	{
		printHeader();
		if(DEBUG) 
		{
			Patient einstein = new Patient("Einstein", 32979, "Indigestion", 20);
			Patient jack = new Patient("Jack", 23231, "Broken Arm", 50);
			Patient jill = new Patient("Jill", 323216, "Concussion", 10);
			Patient beethoven = new Patient("Beethoven", 77735552, "Heart Attack", 1);
			Patient curie = new Patient("Curie", 920340, "Uranium Poisoning", 25);
			Patient presley = new Patient("Presley", 7777777, "Heart Attack", 1);
			Patient neumann = new Patient("Von Neumann", 1234321, "Uranium Poisoning", 25);
			hpq.push(einstein);
			hpq.push(jack);
			hpq.push(jill);
			hpq.push(beethoven);
			hpq.push(curie);
			hpq.push(presley);
			hpq.push(neumann);
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
					// CREATE NEW PATIENT
					System.out.print("Enter the patient's name: ");
					String name = scan.nextLine();
					
					System.out.print("Enter the patient's ailment: ");
					String ailment = scan.nextLine();
					
					System.out.print("Enter the patient's ID: ");
					int ID = scan.nextInt();

					System.out.print("Enter the patient's priority: ");
					int priority = scan.nextInt();
					scan.nextLine();  
					
					Patient patient = new Patient(name, ID, ailment, priority);
					hpq.push(patient);
					System.out.println(name + " added to the Hospital Queue.");
					break;
				
				case 2:
					if(hpq != null)
					{
						System.out.println("Item at front of Priority Queue is " + "'" + hpq.peek() + "'.");
					}
					
					else 
					{
						System.out.println("Error: Priority Queue is null.");
					}
					break;
				
				case 3:
					if(hpq != null)
					{
						System.out.println(hpq.peek() + " removed from the Priority Queue.");
						hpq.pop();
					}
					
					else 
					{
						System.out.println("Error: Priority Queue is null.");

					}
					break;
				
				case 4:
					if(hpq != null)
					{
						System.out.println("The patients are: ");
		                hpq.print();
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
		System.out.println("Hospital Menu System");
		System.out.println("Select from the following menu:");
		System.out.println("1. Check a patient in (push).");
		System.out.println("2. Check patient queue (peek).");
		System.out.println("3. Check out a patient (pop).");
		System.out.println("4. Print the patient queue.");
		System.out.println("99. Quit.");
	}
}
