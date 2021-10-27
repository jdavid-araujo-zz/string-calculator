import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class StringCalculatorTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void checkEmptyString() {
		StringCalculator stringCalculator = new StringCalculator();
		
		assertEquals(0, stringCalculator.add(""));
	}
	
	@Test
	public void checkSumSeparetedByComma() {
		StringCalculator stringCalculator = new StringCalculator();
		
		assertEquals(8, stringCalculator.add("1,2,5"));
	}
	
	@Test
	public void checkSumSeparetedByCommaAndNewLine1() {
		StringCalculator stringCalculator = new StringCalculator();
		
		assertEquals(6, stringCalculator.add("1\n,2,3"));
	}
	
	@Test
	public void checkSumSeparetedByCommaAndNewLine2() {
		StringCalculator stringCalculator = new StringCalculator();
		
		assertEquals(7, stringCalculator.add("1,\n2,4"));
	}


	@Test
	public void checkSumCustomDelimiter1() {
		StringCalculator stringCalculator = new StringCalculator();
		
		assertEquals(8, stringCalculator.add("//;\n1;3;4"));
	}
	
	@Test
	public void checkSumCustomDelimiter2() {
		StringCalculator stringCalculator = new StringCalculator();
		
		assertEquals(6, stringCalculator.add("//$\n1$2$3"));
	}
	
	@Test
	public void checkSumCustomDelimiter3() {
		StringCalculator stringCalculator = new StringCalculator();
		
		assertEquals(13, stringCalculator.add("//@\n2@3@8"));
	}

	@Test()
	public void checkWhenTheStringHaveNegativeValue() {
		StringCalculator stringCalculator = new StringCalculator();
		
	    exceptionRule.expect(NegativeNumberIsNotAllowException.class);
	    exceptionRule.expectMessage("Negatives not allowed: -3");
		
		stringCalculator.add("//@\n2@-3@8");
	}
	
	@Test
	public void checkSumWithNumberMoreThan1000() {
		StringCalculator stringCalculator = new StringCalculator();
		
		assertEquals(2, stringCalculator.add("2,1001"));
	}

	@Test
	public void checkSumWithStringUsingDelimitersArbitraryLength() {
		StringCalculator stringCalculator = new StringCalculator();
		
		assertEquals(6, stringCalculator.add("//***\n1***2***3"));
	}

	@Test
	public void checkSumWithStringUsingMultipleDelimiters() {
		StringCalculator stringCalculator = new StringCalculator();
		
		assertEquals(6, stringCalculator.add("//$,@\n1$2@3"));
	}

	@Test
	public void checkSumWithStringUsingMultipleDelimitersAndArbitraryLength() {
		StringCalculator stringCalculator = new StringCalculator();
		
		assertEquals(6, stringCalculator.add("//$,@\n1$$$$$2@@@3"));
	}
}
