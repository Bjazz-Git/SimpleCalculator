package PCK1;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {

	private static final Logger logger = LogManager.getLogger("SimpleCalculator");

	public static void main(String[] args) {
		int number1;
		String operation;
		int number2;
		int result = 0;
		String tempValue;
		Scanner input = new Scanner(System.in);
		
		while(true) {
			logger.info("Asking user for first number...");
			//First number
			System.out.print("What is the first number?: ");
			//This variable is used to prevent errors within the terminal when an exception occurs(Unexpected errors messages/infinite loop)
				tempValue = input.next();
			//Checks to see if value entered was a number, if not the program restarts
			try{
				logger.info("Converting user input (" + tempValue + ") to integer...");
				number1 = Integer.parseInt(tempValue);
				logger.info("User first number converted successfully");
			}
			catch(Exception ex){
				logger.warn("Converting " + tempValue + " to integer caused the error: " + ex.getMessage());
				System.out.println("Error, try again");
				continue;
			}
		
			//Operator
			logger.info("Asking user for operation sign...");
			System.out.print("What operation are you using? (+, -, *, /): ");
			operation = input.next();
			logger.info("User inputted (" + operation + ") as there operation sign");
		
			//Second number
			logger.info("Asking user for second number...");
			System.out.print("What is the second number?: ");
			//This variable is used to prevent errors within the terminal when an exception occurs(Unexpected errors messages/infinite loop)
			tempValue = input.next();
			//Checks to see if value entered was a number, if not the program restarts
			try{
				logger.info("Converting user input (" + tempValue + ") to integer...");
				number2 = Integer.parseInt(tempValue);
				logger.info("User second input converted successfully");
			}
			catch(Exception ex){
				logger.warn("Converting " + tempValue + " to integer caused the error: " + ex.getMessage());
				System.out.println("Error, try again");
				continue;
			}
		
			//Operator is plus
			if(operation.equals("+")) {
				try{
					result = addNumber(number1, number2);
				}catch(Exception ex){
					logger.error("The operation " + number1 + " " + operation + " " + number2 + " resulted in the error: " + ex.getMessage());
					break;
				}
			}
		
			//Operator is minus
			else if(operation.equals("-")) {
				try{
					result = subtractNumber(number1, number2);
				}catch(Exception ex){
					logger.error("The operation " + number1 + " " + operation + " " + number2 + " resulted in the error: " + ex.getMessage());
					break;
				}
			}
		
			//Operator is times sign
			else if(operation.equals("*")) {
				try{
					result = multiplyNumber(number1, number2);
				}catch(Exception ex){
					logger.error("The operation " + number1 + " " + operation + " " + number2 + " resulted in the error: " + ex.getMessage());
					break;
				}
			}
		
			//Operator is division sign
			else if(operation.equals("/")) {
				try{
					result = divideNumber(number1, number2);
				}catch(Exception ex){
					logger.error("The operation " + number1 + " " + operation + " " + number2 + " resulted in the error: " + ex.getMessage());
					break;
				}
			}
			
			//If operator wasn't one of the specified four operations the program restarts
			else {
				logger.error("The operation sign (" + operation + ") is not valid");
				System.out.println("Error, try again");
				continue;
			}
			
			//Operation result
			System.out.println("The result of the operation is: " + result);
			logger.info("Operation completed successfully. The result of the operation was " + result);
			
			//Determines if the calculator should continue running based on user response (yes or no)
			System.out.println("Do you want to do another operation? (yes or no): ");
			if(input.next().toLowerCase().equals("yes")) {
				logger.info("Users wants to do another operation. Restarting...");
				continue;
			}
			else {
				logger.info("Users doesn't want to do anymore operations. Closing...");
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