package customerexception;

public class InvalidInputException extends Exception{
	public InvalidInputException(String errMesg){
		super(errMesg);
	}
}
