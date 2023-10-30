package utills;

import java.time.LocalDate;

import comm.Customer;
import comm.Plan;


import java.util.List;


import customerexception.InvalidInputException;

import customerexception.InvalidPlanException;
import customerexception.DuplicateCustomerException;

public class CustomerValidations {
	
	public static Plan parseAndValidatePlan(String plan) throws InvalidPlanException,IllegalArgumentException{
		return Plan.valueOf(plan.toUpperCase());
	}
	
	public static void validatePlanAmount (Plan plan,double regAmount) throws  InvalidPlanException{
		if(plan.getPlanCost()!=regAmount){
			throw new InvalidPlanException("Registration amount doesn't match");
		}
		System.out.println("Correct Ammount...");
	}
	
	public static LocalDate parseAndValidateDate(String dob)throws InvalidInputException{
		LocalDate validDOB=LocalDate.parse("2004-01-01");
		LocalDate userDOB=LocalDate.parse(dob);
		if(userDOB.isAfter(validDOB)){
			throw new InvalidInputException("User should be at least 18");
		}
		return userDOB;
	}
	
	public static void checkForDupEmail(String email,List<Customer> list) throws InvalidInputException{
		String pattern="[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		if (!email.matches(pattern))
			throw new InvalidInputException("Invalid Email...");
		if (list.contains(new Customer(email)))
			throw new InvalidInputException("Invalid Email...");
	}
	
	public static Customer validateAllInputs(String firstname, String lastname, String email, String password, double registration_Amount,
			String userDob,LocalDate lastSubscriptionPaidDate, String servicePlan,List<Customer> customers) throws InvalidPlanException,IllegalArgumentException,InvalidInputException
	{
		Plan plan=parseAndValidatePlan(servicePlan);
		LocalDate dob=parseAndValidateDate(userDob);
		checkForDupEmail(email,customers);
		return new Customer(firstname,lastname,email,password,registration_Amount,dob,lastSubscriptionPaidDate,plan);
		
	}
}