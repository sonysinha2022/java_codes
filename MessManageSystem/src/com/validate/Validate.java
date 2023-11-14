package com.validate;

import java.time.LocalDate;
import java.util.Map;

import com.core.*;
//import com.core.*;

import customExceptions.InvalidInputException;


public class Validate
{
	
	// duplication
	
	public static void duplictioncheck(Map<Integer,Customer> map, int id) throws InvalidInputException
	{
		Customer c1=new Customer(id);
		if(map.containsKey(c1))
				throw new InvalidInputException("duplicate email id");
		System.out.println("valid email");
	}
	
	//Emailformat check
	
	public static String emailformatcheck(String email) throws InvalidInputException
	{
		
	String pattern="[A-Za-z0-9._%)+@(A-za-z0-9.)+\\.[A-Za-z]";
	if (!email.matches(pattern))
				System.out.println("invalid email");
		return email;
		
	}
	
   
	
	// for login
	
	public static Customer validlogin(Map<Integer,Customer> map,String email, String password) throws InvalidInputException
	{
		
		for(Customer cc:map.values())
		{
			if(cc.getEmail().equals(email) &&  cc.getPassword().equals(password))
			{
				return cc;
			}
		}
		throw new InvalidInputException(" email id invalid");
	}
	
	// 

	// vlaidate plan amunt
	public static double validplanamt(MessPlan Plan, double amount) throws InvalidInputException
	{
		if(Plan.getmPlan()!=amount) throw new InvalidInputException(" registration amt do not match");
		return amount;
	}
	
	// valid phone
	public static void checkphone(String phoneno) throws InvalidInputException
	{
		String pattern="\\d{10}";
		if(phoneno.matches(pattern) && phoneno.length()==10)
			System.out.println(" phone no valid");
		else
			throw new InvalidInputException(" invalid phone no");
	}
	
	
	
	// parse plan
	
	public static MessPlan parseandvalidateplan( String plan) 
	{
		return MessPlan.valueOf(plan);
	}
	
	
	// register date
	
	public static LocalDate parseandvalidateregisterdate(String registerdate)
	{
		return LocalDate.parse(registerdate);
	}
	
	// enddate
	public static LocalDate parseandvalidateenddate(String enddate)
	{
		return LocalDate.parse(enddate);
	}
	
	
	public static Customer validateall( int id, String fName, String lName, String email, String password, String addr,
			String phoneno, String registerDate, String planEndDate, String plan, double final_amount ,Map<Integer,Customer> map)throws InvalidInputException
	{
		//emailformatcheck( email);
		duplictioncheck( map,id);
		checkphone(phoneno);
		LocalDate d1=parseandvalidateenddate(planEndDate);
		LocalDate d2=parseandvalidateregisterdate(registerDate);
		MessPlan pl=parseandvalidateplan(plan); 
		double m1=validplanamt(pl,final_amount);
		
		
	
		return new Customer(id,fName, lName, email, password,  addr,phoneno, d2,  d1,  pl,m1);
	
	}
	
}
	



