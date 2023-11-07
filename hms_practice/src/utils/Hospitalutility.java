package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import customexceptions.InvalidInputException;
import hospitalManagement.Doctorname;
import hospitalManagement.Hospital;


//String patientname, int pid, String email, String password, int departmentid, String departmentname,
//LocalDate dayofvisit, double hospitalcost, Doctorname dname) 

//String patientname;
//private  int pid;
//private String email;
//private String password;
//private int departmentid;
//private String departmentname;
//private LocalDate dayofvisit;
//private double hospitalcost;
//private Doctorname dname;
//static private int registrationid;
//private  boolean isAvailable ;

public class Hospitalutility {
	
	public static List<Hospital> populateHospitalManagement()
	{
		List<Hospital> list1=new ArrayList<>();
		list1.add(new Hospital("joe",201,"joe@gmail.com","joe123",101,"Ortho",LocalDate.parse("2023-11-05"),LocalDate.parse("2023-11-05"),200,Doctorname.SARA));
		list1.add(new Hospital("soee",222,"soee@gmail.com","soe@123",110,"Dental",LocalDate.parse("2023-11-08"),LocalDate.parse("2023-11-08"),100,Doctorname.JOHN));
		list1.add(new Hospital("jonny",234,"jon@gmail.com","jon@123",102,"Medicine",LocalDate.parse("2023-11-06"),LocalDate.parse("2023-11-06"),300,Doctorname.ROHAN));
		list1.add(new Hospital("jack",245,"jack@gmail.com","jack@12",106,"PMR",LocalDate.parse("2023-11-07"),LocalDate.parse("2023-11-08"),150,Doctorname.RAM));
		return list1;
		
	}
	
	public static Hospital findbyEmail(String email,List<Hospital>list1) throws InvalidInputException
	{
		Hospital hosp=new Hospital(email);
		int index=list1.indexOf(hosp);
		if(index==-1)
			throw new InvalidInputException("Invalid Email");
		return list1.get(index);
	}
	
	

	public static void authLogin(String password1,Hospital hosp) throws InvalidInputException
	{
		if(hosp.getPassword().equals(password1))
			System.out.println("login successful");
		else
			throw new InvalidInputException("Invalid Password");
	}
	
	public static void changePassword(String oldpassword, String newPassword,Hospital hosp)throws InvalidInputException
	{
		if (oldpassword.equals(hosp.getPassword()))
			hosp.setPassword(newPassword);
		else
			throw new InvalidInputException("Invalid Password");
	}
	
}
