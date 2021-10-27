public class NegativeNumberIsNotAllowException extends RuntimeException {

	private static final long serialVersionUID = -3841531787315368581L;

	public NegativeNumberIsNotAllowException(String errorMessage) {
        super(errorMessage);
    }
	
	public NegativeNumberIsNotAllowException() {
        super();
	}
}
