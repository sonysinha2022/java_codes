package validation_rules;

import java.time.LocalDate;
import java.util.Map;

import com.code.Customer;
import com.code.ServicePlan;

import custom_exception.InvalidInputException;

public class ValidationRules {

	// no dup customers
	// (i.e if the customer tries to register using existing email , throw
	// exception)
	public static void checkDup(String email, Map<String, Customer> custMap) {
		if (custMap.containsKey(email))
			System.out.println("Email already exit");

	}

	// Validate plan
	// plan must be of supported types
	public static ServicePlan parseandvalidatePlan(String plan) {
		return ServicePlan.valueOf(plan.toUpperCase());
	}

	// 4.3 reg amount must match with the plan
	public static double parseandvalidateAmount(ServicePlan Plan, double amount) throws InvalidInputException {
		if (Plan.getsPlan() != amount)
			throw new InvalidInputException("plan and amount not match");
		return amount;

	}

	// parse dob
	public static LocalDate parseandvalidateDate(String dob) {
		return LocalDate.parse(dob);
}
	// parse LSPD
	public static LocalDate parseandvalidatelastSubscriptionPaidDate(String LSPD) {
		return LocalDate.parse(LSPD);
	}
	public static Customer forLogin(Map<String,Customer> custMap,String email,String password) throws InvalidInputException
	{
		for(Customer c1:custMap.values())
		{
			if(c1.getEmail().equals(email) && (c1.getPassword().equals(password)))
				return c1;
		}
		throw new InvalidInputException("Invalid email or password");	
			
	}

	public static Customer validateAllInput(String fName, String lName, String email, String password,
			double registrationAmount, String dob, String plan, String lastSubscriptionPaidDate,Map<String,Customer>custMap)
			throws InvalidInputException {
		LocalDate d1 = parseandvalidateDate(dob);
		ServicePlan p1 = parseandvalidatePlan(plan);
		double amount = parseandvalidateAmount(p1, registrationAmount);
		LocalDate d2 = parseandvalidatelastSubscriptionPaidDate(lastSubscriptionPaidDate);
		return new Customer(fName, lName, email, password, amount, d1, p1, d2);

	}

}
