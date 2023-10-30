package utills;

import java.util.ArrayList;
import java.util.List;
import comm.Customer;
import comm.Plan;
import java.time.LocalDate;


import customerexception.InvalidInputException;
import customerexception.DuplicateCustomerException;
import customerexception.InvalidPlanException;

public class Customerutills {
	
	public static List<Customer> populateCustomerManagement(){
		List<Customer> list=new ArrayList<>();
		list.add(new Customer("abc","cde","abc@abc.com","1234",2000,LocalDate.parse("2000-10-11"), LocalDate.parse("2023-05-20"),Plan.GOLD));
		list.add(new Customer("wer","tyu","wer@abc.com","2233",2000,LocalDate.parse("2005-01-24"), LocalDate.parse("2023-03-19"),Plan.GOLD));
		list.add(new Customer("tyu","fgh","tyu@abc.com","abcd",2000,LocalDate.parse("2000-06-10"), LocalDate.parse("2023-08-14"),Plan.GOLD));
		list.add(new Customer("ghj","rty","ghj@abc.com","abab",2000,LocalDate.parse("1999-08-10"), LocalDate.parse("2023-07-29"),Plan.GOLD));
		list.add(new Customer("tyu","fff","iuy@abc.com","abcd",2000,LocalDate.parse("2002-06-10"), LocalDate.parse("2023-06-03"),Plan.GOLD));
		return list;
	}
	
	public static Customer findByEmail(String email,List<Customer> list) throws InvalidInputException {
		Customer cust=new Customer(email);
		int index = list.indexOf(cust);
		if(index==-1)
			throw new InvalidInputException("Invaild Email "); 
		return list.get(index);
	} 
	
	
	
	public static void authCustomer(String password,Customer cust) throws InvalidInputException
	{
		if(cust.getPassword().equals(password))
			System.out.println("---Login Successful---");
		else
			throw new InvalidInputException("Invaild Password "); 
	}
	
	public static void changePassword(String oldPass,String newPass,Customer cust) throws InvalidInputException {
		if(oldPass.equals(cust.getPassword()))
			cust.setPassword(newPass);
		else
			throw new InvalidInputException("Invaild Password "); 
	}
}