package com.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import Utils.ValidatePlan;
import custom_ordering.CustomerDateComparator;
//import custom_exceptions.InvalidInputException;
import custom_ordering.CustomerDateComparator;

import com.code.CustomerMangSys;
import com.code.ServicePlan;
import com.code.Vehicle;
import static Utils.ValidatePlan.*;
import static Utils.Login.forLogin;
import static Utils.CustomerRecords.*;
import static Utils.Notpaidsubscription.*;

public class test_CustomerMangSys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner sc = new Scanner(System.in)){
			
		
		List<CustomerMangSys> customers=populateCustomer();
		boolean exit=false;
		while(!exit)
		try{
			System.out.println("Enter your choice\n" + "1.Sign up\n" + "2.Sign in\n" + 
		               "3.Change password\n" + "4.Remove customer by email\n"
					+ "5.Display customer\n" +"6.sort by email\n" +"7.sort by date\n"+ 
		               "8.sort by date and last name\n"+"9.calculateperiod and display msg\n" + 
					"10.subscription pending for last 3 month\n" +"11.subscription pending for last 6 month\n" +"0.Exit");
			switch(sc.nextInt())
			{
			case 1:
				System.out.println("Enter fName, lName, email, password, registrationAmount, dob, plan");
				CustomerMangSys c1=validateAllInput(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),sc.next(),customers);
				customers.add(c1);
				System.out.println("Customer Added successfully");
				break;
			case 2:
				System.out.println("enter email and password");
				c1=forLogin(sc.next(),sc.next(),customers);
				System.out.println("Login successfully");
				break;
			case 3:
				System.out.println("Enter email,password");
				c1=forLogin(sc.next(),sc.next(),customers);
				System.out.println("Enter new password");
				c1.setPassword(sc.next());
				System.out.println("Password updated");
				break;
			case 4:
				System.out.println("Enter email");
				String email=sc.next();
				 checkEmail(email,customers);
				 Iterator<CustomerMangSys> cmsitr=customers.iterator();
				 while(cmsitr.hasNext())
				 {
					 if(cmsitr.next().getEmail().equals(email))
						 cmsitr.remove();
				 }
				 System.out.println("deleted customer details");
				 break;
			case 5:
				for(CustomerMangSys c:customers)
					System.out.println(c);
				break;
			case 6:
				Collections.sort(customers);
				break;
			case 7:
				Collections.sort(customers, new CustomerDateComparator());
				break;
			case 8:
				Collections.sort(customers,new Comparator<CustomerMangSys>() {
					@Override
					public int compare(CustomerMangSys o1, CustomerMangSys o2) {
						System.out.println("in campare: dob and Lastname");
						int ret=o1.getDob().compareTo(o2.getDob());
						if(ret==0) 
							return o1.getlName().compareTo(o2.getlName());
			
						return ret;
					}
				});
				break;
			case 9:
				
				notpaidsubscimsg(customers);
					break;
			case 10:
				subcriforgreaterthanthreemonth(customers);
				break;
			case 11:
				subcriforgreaterthansixmonth(customers);
				break;
			case 0:
				exit = true;
				break;
			}
			
		}

		catch (Exception e) {
			System.out.println(e);
			System.out.println(sc.next());
			e.printStackTrace();
		}
	}
}
}
