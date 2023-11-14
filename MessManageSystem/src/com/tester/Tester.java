package com.tester;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import com.core.Customer;
import com.core.MessPlan;
import static utils.Cusutils.populatecustomer;
import static com.validate.Validate.validlogin;

import static utils.Cusutils.*;
import static com.validate.Validate.*;
import static java.time.LocalDate.parse;
import static utils.IOUtils.*;
//import static utils.IO_utils.storeCustomerDetails;

//import static utils.IOUtils.storeCustomerDetails;
import java.util.stream.Stream;

import static com.validate.Validate.validateall;
import static com.validate.Validate.*;


public class Tester 
{

	public static void main(String[] args)
	{
	  Map<Integer,Customer> map =populatecustomer();
	  
	  try(Scanner sc= new Scanner(System.in))
	  {
		  
		 boolean exit=false;
		 while(!false)
		 {
			 try {
				 System.out.println("options:" + "1.\n Display" + "2.Sign up Customer\n"
							+ "3.Sign in \n" + "4.ChangePassword 5.Sort Customer-FirstName 6.Sort Customer-Plan 7.Sort Customer-registerDate"
							+ "8.Unsubscribe customer according plan duration (month wise (1, 3, 6, 12))\n"
							+ "1.display\n" + "9.Modify all customers first name \n"
							+ "10.Display email addresses of the customers who did registration in month of January\n"
							+ "11.Display count of the Customers who have register for plan: Monthly\n"
							+ "12.Search the Customer who lived in Akurdi\n"
							+ "13.Give the 20% discount to the customers who have selected plan for 1 year\n"
							+ "14.store customer record\n" + "15.restore customer record\n" + "0.exit\n");
				 switch(sc.nextInt())
				 {
				 case 1: System.out.println("display all");
				 map.values().stream().forEach(s->System.out.println(s));
				 break;
				 
//				 
				 
				 
				 case 2: System.out.println("sign up");
				 System.out.println(" enter  id, fName,  lName,  email,  password, addr,  phoneno,  registerDate, planEndDate, plan,  final_amount");
				 Customer cr=validateall(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),map);
				 map.put(cr.getCustomer_id(), cr);
				 System.out.println("sign up, record addded");
				 break;						
				 
				 case 3: System.out.println("sign in");
				 System.out.println("enter emailid and password");
				 Customer c=validlogin(map, sc.next(),sc.next());
				 System.out.println("sign success");
				 break;
				 
				 case 4: System.out.println("change password");
				 System.out.println("enter email id and password");
				 Customer c1= validlogin(map,sc.next(),sc.next());
				 System.out.println("enter new password");
				 c1.setPassword(sc.next());
				 System.out.println("changed password succes");
				 break;
				 
				 case 5: System.out.println("sort as per as first name");
				 map.values().stream().sorted((c3,c2)->c3.getfName().compareTo(c2.getfName()))
				 .forEach(s->System.out.println(s));
				 break;
				 
				 case 6: System.out.println("sort as per as plan");
				 map.values().stream().sorted((c4,c5)->c4.getPlan().compareTo(c5.getPlan()))
				 .forEach(System.out::println);
				 break;
				 case 7: System.out.println("sort as per as plan");
				 map.values().stream().sorted((c6,c7)->c6.getRegisterDate().compareTo(c7.getRegisterDate()))
				 .forEach(System.out::println);
				 break;
				 case 8:
					 System.out.println("unsribe plan as per as duration");
					 map.values().removeIf(c7->c7.getPlan()==MessPlan.MONTHLY);
					 map.values().forEach(System.out::println);
					 
					 map.values().removeIf(c7->c7.getPlan()==MessPlan.QUARTERLY);
					 map.values().forEach(System.out::println);

					 map.values().removeIf(c7->c7.getPlan()==MessPlan.HALFYEARLY);
					 map.values().forEach(System.out::println);
					 
					 map.values().removeIf(c7->c7.getPlan()==MessPlan.YEARLY);
					 map.values().forEach(System.out::println);
					 break;
					 
				 case 9: System.out.println("make uppercase the first letter of fname");
				 for(Customer c8 : map.values())
				 {
					 String newname= c8.getfName().substring(0,1).toUpperCase() +c8.getfName().substring(1).toLowerCase();
					 c8.setfName(newname);
				 }
				 
				 System.out.println("name modified");
				 break;
				 
				 case 10: System.out.println("Display email addresses of the customers who did registration in month of december");
				 map.values().stream().filter(a->a.getRegisterDate().getMonthValue()==12)
				 .forEach(a->System.out.println(a.getEmail()));
				 break;
				 
				 case 11: System.out.println("Display count of the Customers who have register for plan: Monthly");
				 int count=(int)map.values().stream().filter(b->b.getPlan().equals(MessPlan.MONTHLY)).count();
				 System.out.println("Display count of the Customers who have register for plan: Monthly" + count);
				 break;
				 
				 case 12:// Search the Customer who lived in Akurdi.
					
				map.values().stream().filter(c9->c9.getAddr().equals("akurdi"))
				.forEach(System.out::println);
				break; 
				
				 case 13: // Give the 20% discount to the customers who have selected plan for 1 year.
					 
					 for(Customer c10 :map.values())
					 {
						 if(c10.getPlan().equals(MessPlan.YEARLY))
						 {
							 double amount=c10.getFinal_amount()-(c10.getFinal_amount()*0.2);
							 c10.setFinal_amount(amount);
							 System.out.println(c10);
						 }
							 
					 }
					 
					break; 
				 case 14: // serialization
				 System.out.println("enter the file name");
				 storeCustomerDetails(map,sc.next());
				 System.out.println("record stored ");
				 break;
				 
					 
				 
				 case 15:System.out.println(" deserialization"); //deserialization
				 try {
				 System.out.println("enter the file name");
				 map=restoreCustomerDetails(sc.next());
				 System.out.println("record restored ");
				 map.forEach((k,v)->System.out.println(v));
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
					break;
				 
				 case 0: exit=true;
				        break;
				 }
				 
			     }
			     catch(Exception e)
			        {
				  System.out.println(e);
			        }
		 }
	  }
	  
			  
// e.printStackTrace()
	

	
	}

}
