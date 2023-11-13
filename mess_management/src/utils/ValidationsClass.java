package utils;

import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

import java.time.LocalDate;
import static java.time.LocalDate.parse;
import java.time.LocalTime;
import java.time.Period;

import  core.Customer;
import core.Plan;

import   core.Plan.*;
import exception.InputInvalidException;
//import validate.CustomerException;


public class ValidationsClass 
//validate customer check for duplication
{ 
	public static void checkduplication( Map<String, Customer> map ,String email) throws InputInvalidException, IllegalArgumentException
	
	{
		if(map.containsKey(email))
		{
			throw new InputInvalidException("duplicate customer");
		}
	}
	
	
	// validtae customer login
	
	public static void validatelogin(Map<String,Customer> map, String email, String Password) throws  InputInvalidException
	{
		for(Customer c:map.values())
		{
			if(c.getEmail().equals(email))
			{
				if(c.getPassword().equals(Password))
				{
					System.out.println("sign in successful");
					
				}
				else
					throw new InputInvalidException(" do not match");
			}
		}
	}
	
// valid email format
	
	public static String checkemailformat(String email) throws InputInvalidException
	{
		if(email.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"))
				{
			       return email;
				}
		else
		{
			throw new InputInvalidException("invalid email");
		}
	}
	


	//parse validate plan
	public static double validateplan(Plan plan ,double messcharges) throws InputInvalidException
	{
		if(plan.getMesscharges()!=messcharges)
			throw new InputInvalidException("Registrartion amount do not match");
		else
		{
			return messcharges;
		}
	}
	
	
	
	//}// CHECK phone no
	
	public static void checkphone(String phn)
	{
		if(phn.length()!=10)
		{
			System.out.println(" phone no of 10 digits");
		}
	}
	
	
	
// validate emailpassword
	public static void emailpassword(Map<String,Customer>map,String email, String password) throws InputInvalidException
	{
		for(Customer c:map.values())
		{
			if(c.getEmail().equals(email))
			{
				if(c.getPassword().equals(password))
				{
					System.out.println("Sign in successfull");
				}
				else
				{
					throw new InputInvalidException("try again");
				}
					
			}
		}
	}
	
	//calculate months
	
	public static long calmonths(LocalDate Startdate, LocalDate Enddate)
	{
		long month=Period.between(Startdate,Enddate).toTotalMonths();
		return month;
	}
	
	
	// remove according to plan
	public static void removeaccplan(Map<String,Customer>map)
	{
		Iterator<Customer> itr =map.values().iterator();
		while(itr.hasNext())
		{
			Customer c=map.get(itr.next().getEmail());
			if( c.getPlanEndDate().isBefore(LocalDate.now()))
					{
				      itr.remove();
				      
					}
					
		}
		
	}
	


	
	public static void validateDate(LocalDate registerDate) throws InputInvalidException
	{
		//registration date can be only todays date or after todays date and end date must be depend on plan selected
		if(!(registerDate.isAfter(LocalDate.now())||registerDate.isEqual(LocalDate.now())))
		{
			
			throw new InputInvalidException("Registration date can be only todays date or after todays date ");

		}	
	}
	

public static Customer validateall(Map<String,Customer>map,int id, String fname, String lname, String email, String password, String address,
		String registerDate, double amount, String phoneNo, String  plan) throws InputInvalidException
{
	checkduplication(map , email);
	checkphone(phoneNo);
	String emails=checkemailformat(email);
	
	Plan pal=Plan.valueOf(plan.toUpperCase());
	
	LocalDate regdate=LocalDate.parse(registerDate);
	
	
    validateDate(regdate);
	
    double amt = validateplan(Plan.valueOf(plan.toUpperCase()), amount);
	
	return new Customer(id,fname,lname,emails,password,address,regdate,amt,phoneNo,pal);
	
	
	
}

}