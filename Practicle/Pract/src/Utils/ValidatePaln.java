package Utils;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.code.CustomerMangSys;
import com.code.ServicePlan;

import custom.Exception.InvalidInputException;

public class ValidatePaln {

	public static void checkEmail(String email, Map<String, CustomerMangSys> cms) throws InvalidInputException {
		String pattern = "[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		if (!email.matches(pattern))
			throw new InvalidInputException("Email invalid");
		CustomerMangSys c1 = new CustomerMangSys(email);
		if (cms.containsKey(c1))
			;
		throw new InvalidInputException("Email already exists");
	}

	public static void checkPassword(String password, Map<String, CustomerMangSys> cms) throws InvalidInputException {
		CustomerMangSys c1 = new CustomerMangSys(password);
		if (password.equals(c1.getPassword()))
			System.out.println("succcesfulll login");
		else
			throw new InvalidInputException("please enter valid password");

	}

	public static CustomerMangSys forLogin(String email, String password, Map<String, CustomerMangSys> cms)
			throws InvalidInputException {

		checkEmail(email, cms);
		checkPassword(password, cms);
		return new CustomerMangSys(email, password);
	}

	public static LocalDate parseandvalidatedob(String dob) {
		return LocalDate.parse(dob);
	}

	public static LocalDate parselastSubscriptionPaidDate(String LSPD) {
		return LocalDate.parse(LSPD);
	}

	public static ServicePlan parseandvalidateplan(String plan) {
		return ServicePlan.valueOf(plan.toUpperCase());

	}

	public static double parseAndValidateAmount(ServicePlan plan, double resamt) throws InvalidInputException {
		if (plan.getsPlan() != resamt)
			throw new InvalidInputException("Reg amt and plan not match");
		else
			System.out.println("succedd");
		return resamt;
	}

	public static CustomerMangSys validateAllInput(String fName, String lName, String email, String password,
			double registrationAmount, String dob, String plan, String LSPD, Map<String, CustomerMangSys> cms)
			throws IllegalArgumentException, InvalidInputException {
		ServicePlan p = parseandvalidateplan(plan);
		double amount = parseAndValidateAmount(p, registrationAmount);
		LocalDate d1 = parseandvalidatedob(dob);
		checkEmail(email, cms);
		LocalDate d2 = parselastSubscriptionPaidDate(LSPD);
		return new CustomerMangSys(fName, lName, email, password, amount, d1, p, d2);

	}

}
