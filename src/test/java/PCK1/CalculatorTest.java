package PCK1;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
	int testNumber1 = (int) (Math.random() * 1000) + 1;
	int testNumber2 = (int) (Math.random() * 1000) + 1;
	
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
}
