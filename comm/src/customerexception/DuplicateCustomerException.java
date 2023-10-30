package customerexception;


public class DuplicateCustomerException extends Exception{
	DuplicateCustomerException(String errMesg)
	{
		super(errMesg);
	}
}

