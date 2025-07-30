package PCK1;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
	int testNumber1 = (int) (Math.random() * 2147483647);
	int testNumber2 = (int) (Math.random() * 2147483647);
	//The highest int allowed in java
	int precisionTestNumber = 2147483647;
	
    @Test
	public void testAddition() {
    	int expectedResult = testNumber1 + testNumber2;
		int methodResult = MainClass.addNumber(testNumber1, testNumber2);
		
		assertTrue(expectedResult == methodResult);	
	}
    
    @Test
	public void testSubraction() {
    	int expectedResult = testNumber1 - testNumber2;
		int methodResult = MainClass.subtractNumber(testNumber1, testNumber2);
		
		assertTrue(expectedResult == methodResult);
	}
    
    @Test
	public void testMultiplication() {
    	int expectedResult = testNumber1 * testNumber2;
		int methodResult = MainClass.multiplyNumber(testNumber1, testNumber2);
		
		assertTrue(expectedResult == methodResult);
	}
    
    @Test
	public void testDivision() {
    	int expectedResult = testNumber1 / testNumber2;
		int methodResult = MainClass.divideNumber(testNumber1, testNumber2);
		
		assertTrue(expectedResult == methodResult);
	}

	@Test
	public void testGetPrecisionErrors(){
		int testNumber3 = (int) (Math.random() * 2147483647) + 1;
		int testNumber4 = (int) (Math.random() * 2147483647) + 1;
		int result = 0;
		
		// Picks a random number to be the precision number
		int numToSetPrecisionNumberTo = (int) (Math.random() * 2);
		if(numToSetPrecisionNumberTo == 0){
		    testNumber3 = precisionTestNumber;
		}
		else{
			testNumber4 = precisionTestNumber;
		}

		//Picks Random operation
		String[] operationSigns = {"+", "-", "*"};
		int randomOperation = (int) (Math.random() * 3);
		String operationSign = operationSigns[randomOperation];


		// Randomly make numbers negative
		do{
		int numToSetNegative = (int) (Math.random() * 4); 
		if(numToSetNegative == 0 && operationSign != "+"){
		    testNumber3 = -(testNumber3);
			break;
		}
		else if(numToSetNegative == 1 && operationSign != "+"){
			testNumber4 = -(testNumber4);
			break;
		}
		else if(numToSetNegative == 2 && operationSign != "-"){
			 testNumber3 = -(testNumber3);
			 testNumber4 = -(testNumber4);
			 break;
		}
		else if(operationSign == "-"){
			continue;
		}
		else{
			break;
		}
		}while(true);
		
		
		switch (operationSign) {
			case "+":
				result = MainClass.addNumber(testNumber3, testNumber4);
				break;
			case "-":
				result = MainClass.subtractNumber(testNumber3, testNumber4);
				break;
			case "*":
				result = MainClass.multiplyNumber(testNumber3, testNumber4);
				break;
		}
		assertTrue(MainClass.hasPrecisionErrors(testNumber3, operationSign, testNumber4, result));
	}
}
