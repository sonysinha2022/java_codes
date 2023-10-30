package customerexception;

public class InvalidPlanException extends Exception{
	public InvalidPlanException(String errMesg)
	{
		super(errMesg);
	}
}

