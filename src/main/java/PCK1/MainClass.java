package PCK1;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		int number1;
		String operation;
		int number2;
		int result = 0;
		String tempValue;
		Scanner input = new Scanner(System.in);
		
		while(true) {
			//First number
			System.out.print("What is the first number?: ");
			//This variable is used to prevent errors within the terminal when an exception occurs(Unexpected errors messages/infinite loop)
				tempValue = input.next();
			//Checks to see if value entered was a number, if not the program restarts
			try{
				number1 = Integer.parseInt(tempValue);
			}
			catch(Exception ex){
				System.out.println("Error, try again");
				continue;
			}
		
			//Operator
			System.out.print("What operation are you using? (+, -, *, /): ");
			operation = input.next();
		
			//Second number
			System.out.print("What is the second number?: ");
			//This variable is used to prevent errors within the terminal when an exception occurs(Unexpected errors messages/infinite loop)
			tempValue = input.next();
			//Checks to see if value entered was a number, if not the program restarts
			try{
				number2 = Integer.parseInt(tempValue);
			}
			catch(Exception ex){
				System.out.println("Error, try again");
				continue;
			}
		
			//Operator is plus
			if(operation.equals("+")) {
				result = addNumber(number1, number2);
			}
		
			//Operator is minus
			else if(operation.equals("-")) {
				result =subtractNumber(number1, number2);
			}
		
			//Operator is times sign
			else if(operation.equals("*")) {
				result =multiplyNumber(number1, number2);
			}
		
			//Operator is division sign
			else if(operation.equals("/")) {
				result =divideNumber(number1, number2);
			}
			
			//If operator wasn't on of the specified four the program restarts
			else {
				System.out.println("Error, try again");
				continue;
			}
			
			//Operation result
			System.out.println("The result of the operation is: " + result);
			
			//Determines if the calculator should continue running based on user response (yes or no)
			System.out.println("Do you want to do another operation? (yes or no): ");
			if(input.next().toLowerCase().equals("yes")) {
				continue;
			}
			else {
				input.close();
				break;
			}
		}
	}
	
	//Method that handles addition
	public static int addNumber(int number1, int number2) {
		int result = number1 + number2;
		return result;
	}
	
	//Method that handles subtraction
	public static int subtractNumber(int number1, int number2) {
		int result = number1 - number2;
		return result;
	}
	
	//Method that handles multiplication
	public static int multiplyNumber(int number1, int number2) {
		int result = number1 * number2;
		return result;
	}
	
	//Method that handles division
	public static int divideNumber(int number1, int number2) {
		int result = number1 / number2;
		return result;
	}
}