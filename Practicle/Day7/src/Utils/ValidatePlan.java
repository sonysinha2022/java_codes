package Utils;

import java.time.LocalDate;
import java.util.List;

import com.code.CustomerMangSys;
import com.code.ServicePlan;

import custom.exception.InvalidInputException;

public class ValidatePlan {
	
	
	//Validate plan:plan must be of supported types
	
	public static ServicePlan parseAndValidatePlan(String plan) 
	{
		return ServicePlan.valueOf(plan.toUpperCase());
	}
	
	//reg amount must match with the plan
	public static double parseAndValidateAmount(ServicePlan plan,double resamt) throws InvalidInputException
	{
		if(plan.getsPlan()!=resamt)
			throw new InvalidInputException("Reg amt and plan not match");
		else
			System.out.println("succedd");
		return resamt;
		
	}
	
	public static LocalDate parseAndValidateDate(String dob)
	{
		return LocalDate.parse(dob);
	}
	
	public static LocalDate parselastSubscriptionPaidDate(String LSPD)
	{
		return LocalDate.parse(LSPD);
	}
	//add static method to validate email
		//1.well formed email "[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)"
		//2.no duplicate
	public static void checkEmail(String email,List<CustomerMangSys> customers) throws InvalidInputException
	{
		String pattern="[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		if(!email.matches(pattern))
			throw new InvalidInputException("Email invalid");
		CustomerMangSys c=new CustomerMangSys(email);
		if(customers.contains(c))
			throw new InvalidInputException("Email are already exists !");
	}

	
	public static CustomerMangSys validateAllInput (String fName, String lName, String email, String password, 
			double registrationAmount,String dob, String plan,String LSPD,List<CustomerMangSys> customers) throws IllegalArgumentException,InvalidInputException
	{
		ServicePlan p=parseAndValidatePlan(plan);
		double amount=parseAndValidateAmount(p,registrationAmount);
		LocalDate d1=parseAndValidateDate(dob);
		checkEmail(email,customers);
		LocalDate d2=parselastSubscriptionPaidDate(LSPD);
		return new CustomerMangSys(fName, lName, email,password, amount,d1, p,d2);
		
	}
		
	
}














