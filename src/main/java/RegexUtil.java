import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	
	public static final String POSITIVE_NEGATIVE_NUMBERS = "\\-?\\d+";
	
	public static Matcher getNumberByRegex(String number) {
		 Pattern p = Pattern.compile(POSITIVE_NEGATIVE_NUMBERS);
		 
		 Matcher m = p.matcher(number);
		 
		 return m;
	}

}
