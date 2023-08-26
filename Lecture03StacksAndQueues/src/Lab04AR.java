/*
 * Author: Antonio Rosado
 * Lab 04: RPN Calculator
 */
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Lab04AR 
{
    public static void main(String[] args) 
    {
    	Stack<Double> stk2 = new Stack<>();
    	boolean DEBUG;
		String sChoice;
		int iChoice;
    	printHeader();
    	do 
    	{
	    	printMenu();
			Scanner scan = new Scanner(System.in);
	    	sChoice = scan.next();
			iChoice = Integer.parseInt(sChoice);
			System.out.println("You have entered " + iChoice);
			switch(iChoice) 
			{
				case 1:
			        System.out.println("Enter your RPN string: ");
			        String sInput = scan.next();
			        double expected = evaluateRPN(sInput);
					testRpn(sInput, expected);
					break;
				
				case 2:
					DEBUG = true;
					if(DEBUG)
					{
						// Test the calculator with sample data
						testRpnCalculator();
					}
					break;
					
				case 3:
					System.out.println("Exiting program...goodbye.");
					break;
				
				default:
					System.out.println("Invalid choice. Try again.");
					break;
			}
    	}
    	while(true);
    }

    public static void testRpnCalculator() 
    {
        testRpn("3.25 5 * 2 2 * /", 4.0625);
        testRpn("3 2 * 5 +", 11.0);
        testRpn("3 2 5 + *", 21.0);
        testRpn("4 2 ^ 3 2 ^ + sqrt", 5.0);
        testRpn("2 2 ^ recip", 0.25);
        testRpn("8.2 8.2 plusminus +", 0.0);
        testRpn("1, 4, -, 6,2 - /", -0.75);
        testRpn("16 sqrt RECIP plusMinus", -0.25);
        testRpn("27", 27.0);
        testRpn("4.5 + 4.5", Double.NaN); // Error case
        testRpn("3.1 3.1 3.1 +", Double.NaN); // Error case
    }

    public static void testRpn(String input, double expected) 
    {
        double result = evaluateRPN(input);
        System.out.println("You have entered: " + input);
        if (result == expected) 
        {
            System.out.println("The answer is: " + result);
        } 
        else 
        {
            System.out.println("The answer is: " + result);
        }
        System.out.println("----------------------------");
    }

    public static double evaluateRPN(String input) 
    {
        Stack<Double> stack = new Stack<>();
        String[] tokens = input.split("[,\\s]+");

        for (String token : tokens) 
        {
            if (isNumber(token)) 
            {
                stack.push(Double.parseDouble(token));
            } 
            else if (isOperator(token)) 
            {
                if (stack.size() < 2) 
                {
                    return Double.NaN; 
                    // Error: Not enough operands for binary operation
                }
                double rhs = stack.pop();
                double lhs = stack.pop();
                switch (token) 
                {
                    case "+":
                        stack.push(lhs + rhs);
                        break;
                    case "-":
                        stack.push(lhs - rhs);
                        break;
                    case "*":
                        stack.push(lhs * rhs);
                        break;
                    case "/":
                        stack.push(lhs / rhs);
                        break;
                    case "^":
                        stack.push(Math.pow(lhs, rhs));
                        break;
                }
            } 
            
            else if (isUnaryOperator(token)) 
            {
                if (stack.isEmpty()) 
                {
                    return Double.NaN; 
                    // Error: Not enough operands for unary operation
                }
                double operand = stack.pop();
                switch (token.toLowerCase()) 
                {
                    case "sqrt":
                        stack.push(Math.sqrt(operand));
                        break;
                    case "recip":
                        stack.push(1.0 / operand);
                        break;
                    case "plusminus":
                        stack.push(-operand);
                        break;
                }
            } 
            else 
            {
                return Double.NaN; // Error: Invalid token
            }
        }

        if (stack.size() != 1) 
        {
            return Double.NaN; // Error: More than one value left on the stack
        }

        return stack.pop();
    }

    public static void printHeader()
	{
		System.out.println("Welcome to the Stack Menu System");
		System.out.println("Author: Antonio Rosado");
		System.out.println("RPN Calculator \n");
	} //end of method
	
	// end user choices
	public static void printMenu()
	{
		System.out.println("Here are your choices: ");
		System.out.println("1. Enter an RPN String");
		System.out.println("2. DEV MODE");
		System.out.println("3. Quit");
		System.out.print("Enter your choice: ");
	} //end of method
	
    public static boolean isNumber(String token) 
    {
        try 
        {
            Double.parseDouble(token);
            return true;
        } 
        catch (NumberFormatException e) 
        {
            return false;
        }
    }

    public static boolean isOperator(String token) 
    {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
    }

    public static boolean isUnaryOperator(String token) 
    {
        return token.equalsIgnoreCase("sqrt") || token.equalsIgnoreCase("recip") || token.equalsIgnoreCase("plusminus");
    }
}
