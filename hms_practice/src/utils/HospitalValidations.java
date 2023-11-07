package utils;

import customexceptions.InvalidChoiceException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import customexceptions.InvalidInputException;
import customexceptions.DuplicateEmailException;
import hospitalManagement.Doctorname;
import hospitalManagement.Hospital;
//import validate.CustomerException;

public class HospitalValidations {
	
	
	public static Doctorname parseAndValidatechoice( String dname) throws InvalidChoiceException,IllegalArgumentException
	
	{return Doctorname.valueOf(dname.toUpperCase());
		
	}
	
	public static LocalDate parseAndValidate(String patdayofvisit, String docdayofvisit) throws InvalidInputException
	{
		LocalDate validvisitingday=LocalDate.parse("2023-11-11");
		LocalDate userpatdayofvisit=LocalDate.parse(patdayofvisit);
		LocalDate userdocdayofvisit=LocalDate.parse(docdayofvisit);
		if(userpatdayofvisit.isEqual(validvisitingday))
		{
			throw new InvalidInputException(" Doctor is available");
		}
		return userpatdayofvisit;
		
		
	}

	
	public static void validateChoice(Doctorname dname, double consultationalcharges) throws InvalidChoiceException
	{
		
		if(dname.getConsultationalcharges()!=consultationalcharges)
		{
			throw new InvalidChoiceException("consultationalcharges do not match");
		}
		
		System.out.println("correct consultationalcharges");
	}
	
	
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	
	
//	public static void checkForDupEmail(String email,List<Customer> list) throws InvalidInputException{
//		String pattern="[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
//		if (!email.matches(pattern))
//			throw new InvalidInputException("Invalid Email...");
//		if (list.contains(new Customer(email)))
//			throw new InvalidInputException("Invalid Email...");
//	}
	
	
//	public static String validateEmailFormat(String email) throws CustomerException
//	{
//		 		 
//			 if(email.matches("[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)"))
//			 {
//				 return email;
//				 	 
//			 }
//			 else
//			 {
//				
//				 throw new CustomerException("Invalid email format!");		
//			 }
//		  
//	}
	
	public static String DuplicateEmailCheck(String email) throws InvalidInputException
	{
		 if(email.matches("[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)"))
		 {
			 return email;
			 
		 }
		 else
		 {
			 throw new InvalidInputException("Invalid email format!");
		 }
		
	}
	
	
//	public static void DuplicateEmailCheck(String email,List<Hospital>list1) throws InvalidInputException
//	{
//		String pattern =("[a-z]+[a-z0-9]+@[a-z]*.\\(com/org/net)");
//		if (!email.matches(pattern)) throw new InvalidInputException("invalid email");
//		if (list1.contains(new Hospital(email)))
//			throw new InvalidInputException("invalid email");
//		//Hospital h=new Hospital(email);
//		if(list1.contains(new Hospital(email)))
//			throw new InvalidInputException("invalid Email");
//	}
	
	//String patientname, int pid, String email, String password, int departmentid, String departmentname,
	//LocalDate patdayofvisit,LocalDate docdayofvisit, double hospitalcost, Doctorname dname
	
	public static Hospital validateAllInputs(String patientname, int pid, String email, String password, int departmentid, String departmentname,
			String patdayofvisit,String docdayofvisit, double hospitalcost, String dname, List<Hospital>hospitals) throws
	InvalidInputException,IllegalArgumentException,InvalidChoiceException
	{
		Doctorname docname =parseAndValidatechoice(dname);
		DuplicateEmailCheck(email);
		return new Hospital(patientname, pid,  email, password, departmentid, departmentname,LocalDate.parse(patdayofvisit),LocalDate.parse(docdayofvisit) ,hospitalcost,docname);
		
	}
  
}
