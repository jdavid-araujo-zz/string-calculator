import java.util.regex.Matcher;

public class StringCalculator {
	
	private final int NUMBER_LIMITER = 1000;

	/*
	 * Sum the numbers present in the string
	 */
	public int add(String number) {
		int sum = 0;
		int temp = 0;
		
		if(number.length() == 0) {
			return 0;
		}
		
		Matcher m = RegexUtil.getNumberByRegex(number);
		
		 while(m.find()) {
			 temp = Integer.parseInt(m.group());
			 
			 if(this.isNumberNegative(temp)) {
				 throw new NegativeNumberIsNotAllowException("Negatives not allowed: " + temp);
			 }
			 
			 if(!this.isBiggerThanLimiter(temp)) {
				 sum += temp;
			 }				 
		 }	
		 
		 return sum;
	}
	
	/*
	 * Check if a number is negative
	 */
	private boolean isNumberNegative(int number) {
		return number < 0;
	}
	
	/*
	 * Check if a number is bigger than NUMBER_LIMITER
	 */
	private boolean isBiggerThanLimiter(int number) {
		return number > NUMBER_LIMITER;
	}
}
