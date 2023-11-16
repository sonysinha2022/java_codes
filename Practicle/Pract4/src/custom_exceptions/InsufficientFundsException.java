package custom_exceptions;

public class InsufficientFundsException extends Exception {
	public InsufficientFundsException(String mesg) {
		super(mesg);
	}
}
