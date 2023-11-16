package com.validate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


import com.code.Customer;

import com.code.MessPlan;


import custom_Exception.InvalidInputException;

public class ValidateRule {

	// Validate Customer check for Duplication
	public static void checkforDuplication(Map<Integer, Customer> custMap, int id) throws InvalidInputException {
		Customer c1 = new Customer(id);
		if (custMap.containsKey(c1))
			throw new InvalidInputException("Duplicateid");
		System.out.println("Valid customer id !");

	}
	// Validatecustomer login if not exist or invalid mail & invalid password
	// Email must be like regex provided in :

	public static String validatecustomerEmail(String email) throws InvalidInputException {
		String pattern = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
		if (!email.matches(pattern))
			System.out.println("Invalid email");
//		Customer c1 = new Customer(email);
//		if (custMap.containsValue(c1))
//			System.out.println("Email are already exists !");
		return email;
		
	}

	// ParseValidatePlan , registration amount must be match with plan
	public static double ParseValidatePlan(MessPlan Plan, double resamt) throws InvalidInputException {
		if (Plan.getmPlan() != resamt)
			throw new InvalidInputException("Reg amt and plan not match");
//		else
//			System.out.println("succedd");
		return resamt;
	}

	// Parse RegisterDate
	public static LocalDate parseandvalidateRegisterDate(String RegisterDate) {
		return LocalDate.parse(RegisterDate);
	}

	// parse planEndDate
	public static LocalDate parseandvalidateplanEndDate(String planEndDate) {
		return LocalDate.parse(planEndDate);
	}

	// parse messplan
	public static MessPlan parseandvalidatePlan(String plan) {
		return MessPlan.valueOf(plan);
	}
	

	// Phone number must be only 10 character and the number could be between 0 to
	// 9.
	public static void checkPhoneNo(String phone_no) throws InvalidInputException {
		String pattern = "\\d{10}";
		if (phone_no.matches(pattern) && (phone_no.length()==10))
			System.out.println("Valid phone no");
		else
			throw new InvalidInputException("InValid phone no");	
//		Customer c1 = new Customer(phone_no);
//		if (custMap.containsValue(c1))
//			System.out.println("phone no already exists !");
	}
	public static Customer forLogin(Map<Integer,Customer> custMap,String email,String password) throws InvalidInputException
	{
		for(Customer cust:custMap.values()) 
		{
			if(cust.getEmail().equals(email) && cust.getPassword().equals(password))
			{
				return cust;
			}
		}
		throw new InvalidInputException("Invalid email or password");	
	}

	public static Customer validateAllInput(int id, String fName, String lName, String email, String password,
			String addr, String phone_no, String registerDate, String planEndDate, String plan, double final_amount,
			Map<Integer, Customer> custMap) throws InvalidInputException {
		checkforDuplication(custMap, id);
		validatecustomerEmail(email);
		checkPhoneNo(phone_no);
		LocalDate d1 = parseandvalidateRegisterDate(registerDate);
		LocalDate d2 = parseandvalidateplanEndDate(planEndDate);
		MessPlan p1 = parseandvalidatePlan(plan);
		double m1=ParseValidatePlan(p1,final_amount);
		return new Customer(id, fName, lName, email, password, addr, phone_no, d1, d2, p1, m1);

	}

}
