package Tester;

import java.util.Scanner;
import java.util.Map;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.*;

import static utils.UtilsPopulate.*;
import static utils.ValidationsClass.validateall;
import static utils.ValidationsClass.validatelogin;
//import static validate.ValidateCustomer.removeAccordingPlan;
import static utils.ValidationsClass.*;

//import utils.IOUtill;
import Tester.IOUt;
import Tester.Test1;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import core.Customer;

import core.Customer;
import core.Plan;
import exception.InputInvalidException;

public class Test2 
{

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			Map<String, Customer>map=populateCustomer();
			for(Customer c:map.values())
			{
				c.setPlanEndDate(c.setCalculatedEndDate());
			}
			boolean exit=false;
			while(!exit)
			{
				
			System.out.println("Enter options: \n 1 .Display all \n 2.Sign up \n 3 sign in \n 4 Change password \n 5 Sort as per as first name "
					+ "\n 6 sort as per as plan \n 7 sort as per as registration date \n 8 unscribe customer \n 9 modify first name to uppercase "
					+ "\n10 Display email addresses of the customers who did registration in month of January "
					+ "\n 11  Display count of the Customers who have register for plan: Monthly"
					+ "\n 12 Search the Customer who lived in Akurdi "
			        + "\n 13 Give the 20% discount to the customers who have selected plan for 1 year"
					+ "\n 14 Serialization"
			        + "\n 15 deserialization");
			System.out.println("Enter choice:");
			
			
			
				switch(sc.nextInt())
				{
				case 1: System.out.println("display");
					map.values().forEach(c->System.out.println(c));
					break;
				
					
					
				case 2:System.out.println("Sign up");
				System.out.println("enter details:id,fname,lname,email,password, address,registerdate,amount,phoneno, plan ");
				Customer customer= validateall(map,sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next());
				map.put(customer.getEmail(),customer);
		        customer.setPlanEndDate(customer.setCalculatedEndDate());
		        System.out.println("sign up success");
				break;
				
         		case 3: System.out.println(" Enter mail and password to Sign in");
         		String emal=sc.next();
         		String passw=sc.next();
         		validatelogin(map,emal,passw);
         		System.out.println("sign in success");
         		break;
         		
         		case 4:System.out.println("enter email and password to change the password");
         		String eal=sc.next();
         		String pasw=sc.next();
         		validatelogin(map,eal,pasw);
         		System.out.println("enter new password");
         		Customer cr=map.get(eal);
         		cr.setPassword(sc.next());
         		System.out.println("updated password success");
         		break;
         		
         		case 5: System.out.println("Sort as per as first name");
         		map.values().stream().sorted((c1,c2)->c1.getFname().compareTo(c2.getFname()))
         		.forEach(c->System.out.println(c));
         		break;
                
         		case 6: System.out.println("Sort as per as plan");
         		map.values().stream().sorted((c1,c2)->c1.getPlan().name().compareTo(c2.getPlan().name()))
         		.forEach(c->System.out.println(c));
         		break;
				
         		case 7: System.out.println("Sort as per as registration date");
         		map.values().stream().sorted((c1,c2)->c1.getRegisterDate().compareTo(c2.getRegisterDate()))
         		.forEach(c->System.out.println(c));
         		break;
         		
         		case 8:removeaccplan(map);
         		System.out.println(" Customer unscribed");
         		break;
         		
         		case 9: System.out.println(" modify first name to uppercase");
         		for(Customer cc:map.values())
         		{
         			String s=cc.getFname();
         			String newname=Character.toUpperCase(s.charAt(0))+s.substring(1);
         			cc.setFname(newname);
         		}
         		System.out.println("First name modified");
         		break;
         		
        		case 10:  System.out.println("Display email addresses of the customers who did registration in month of January");
         		map.values().stream()
         		.filter(s->s.getRegisterDate().getMonthValue()==1)
         		.map(s->s.getEmail()).forEach(s->System.out.println(s));
        		break;
         		
        		case 11: System.out.println("Display count of the Customers who have register for plan: Monthly");
       		    long count=map.values().stream()
        	    .filter(s->s.getPlan()==Plan.MONTHLY).count();
         		System.out.println("Display count of the Customers who have register for plan: Monthly"+count);
        		break;
         		
         		case 12: System.out.println("Search the Customer who lived in Akurdi");
        		map.values().stream().filter(s->s.getAddress().equals("Akurdi"))
       	    	.forEach(s->System.out.println(s));
         		break;
         		
         		case 13: System.out.println("Give the 20% discount to the customers who have selected plan for 1 year");
       	    	for (Customer c:map.values())
          		{
        			c.discount();         		}
        		System.out.println("Discount applied successfully!");
     			break;
        		
//      
//         		case 14: System.out.println("Enetr the file name"); //xyz.ser
//				storeCustomerDetails(map, sc.next());
//				System.out.println("Record store successfully");
//			    break;
//				
//         		case 15: 
//         			try
//         			{
//         				System.out.println("Enter file name");
//    					Map<Integer, Customer> cust = reStoreCustomerDetails(sc.next());
//    					System.out.println("Date restore successfully");
//    					cust.forEach((k, v)-> System.out.println(v));
//    					} 
//         			    catch (Exception e) 
//         			    {
//    					e.printStackTrace();
//    					}
//    					break;
         			
					
				case 0:
					exit=true;
					System.out.println("exit");
				}
			}
			
		}
		catch(Exception e)
		{
			//sc.nextLine();
			System.out.println(e);
		}

	

}
}
