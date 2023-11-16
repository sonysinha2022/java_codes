package validation_rules;

import java.time.LocalDate;
import java.util.List;

import com.code.Customer;

import com.code.ServicePlan;

import custom_exception.InvalidInputException;

public class Validation_rules {
	
	//4.1 no dup customers 
	//(i.e if the customer tries to register using existing email , throw exception)
	
	public static void parseandvalidateEmail(String email,List<Customer> cust) throws InvalidInputException
	{
		Customer c1=new Customer(email);
		if(cust.contains(c1))
			System.out.println("Email are already exists");
		
	}

	//4.2 Validate plan
	//plan must be of supported types
	public static ServicePlan parseandvalidatePlan(String plan)
	{
		return ServicePlan.valueOf(plan.toUpperCase());
	}

	//4.3 reg amount must match with the plan
	public static double parseandvalidateAmount(ServicePlan plan,double amount) throws InvalidInputException
	{
		if(plan.getsPlan()!=amount)
			throw new InvalidInputException("plan and amount not match");
			else
				System.out.println("succeed");
		return amount;
	}
	public static LocalDate parseandvalidateDate(String dob)
	{
		return LocalDate.parse(dob);
	}
	//login
	public static Customer forlogin(List<Customer> cust,String email,String password) throws InvalidInputException
	{
		Customer c1 = new Customer(email);
		int index = cust.indexOf(c1);
		if (index != -1)
			c1 = cust.get(index);
		else
			throw new InvalidInputException("please enter valid email");
		if (password.equals(c1.getPassword()))
			System.out.println("successfull login");
		else
			throw new InvalidInputException("please enter valid password");
		return c1;		
	}
	
	public static LocalDate parselastSubscriptionPaidDate(String lastSubscriptionPaidDate)
	{
		return LocalDate.parse(lastSubscriptionPaidDate);
	}
	
	public static Customer validateAllInput(String fName, String lName, String email, String password,
			double registrationAmount, String dob, String plan,String lastSubscriptionPaidDate,List<Customer> cust) throws InvalidInputException
	{
		ServicePlan p1=parseandvalidatePlan(plan);
		double amount=parseandvalidateAmount(p1,registrationAmount);
		LocalDate d1=parseandvalidateDate(dob);
		LocalDate d2=parselastSubscriptionPaidDate(lastSubscriptionPaidDate);
		return new Customer(fName,lName,email, password,amount,d1,p1,d2);
	}

}







