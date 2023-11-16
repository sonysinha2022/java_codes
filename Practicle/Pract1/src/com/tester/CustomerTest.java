package com.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import static Utils.Notpaidsubscription.*;
import static Utils.Io_utils.*;
import com.code.Customer;
import com.code.ServicePlan;

import custom_ordering.CustomerDateComaparator;

import static validation_rules.Validation_rules.*;
import static Utils.CustomerRecord.*;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner sc=new Scanner (System.in)){
			
			List<Customer> cust=populateList();
			boolean exit=false;
			while(!false) {
				try {
					System.out.println("Options: "+"1.Sign up"+"2. Sign in (login)"+"3.Change password"+
				"4.Un subscribe customer"+"5.Display all customers." +"6.sort by email\n" +"7.sort by date\n"+ 
	               "8.sort by date and last name\n"+"9.not paid subscription(last 3 month)\n" + 
					"10.subscription pending for last 3 month\n" +"11.subscription pending for last 6 month\n"
	               +"12.pay subcription amount\n"+"13.store data(txt)\n"+"14.read data(txt)\n"
	               +"15.store data(ser)\n"+"16.read data(desce)\n"
				+"0.exit");
			
					switch(sc.nextInt())
					{
					case 1:
						System.out.println("Enter fName,lName,email, password,registrationAmount,dob,plan,lastSubscriptionPaidDate");
						Customer c1=validateAllInput(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),sc.next(),cust);
						cust.add(c1);
						System.out.println("record added");
						break;
					case 2:
						System.out.println("Enter email,password");
						c1=forlogin(cust,sc.next(),sc.next());
						System.out.println("Sign in sucessfully");
						break;
					case 3:
						System.out.println("Enter email,password");
						c1=forlogin(cust,sc.next(),sc.next());
						System.out.println("Enter new password");
						c1.setPassword(sc.next());
						System.out.println("password change");
						break;
					case 4:
						System.out.println("Enetr email");
						String email=sc.next();
						parseandvalidateEmail(email,cust);
						Iterator <Customer> itrcust=cust.iterator();
						while(itrcust.hasNext()) {
							if(itrcust.next().getEmail().equals(email))
								itrcust.remove();
						}
						System.out.println("deleted customer details");
						break;
					case 5:
						for(Customer c:cust)
							System.out.println(c);
						break;
					case 6:
						Collections.sort(cust);
						break;
					case 7:
						Collections.sort(cust,new CustomerDateComaparator());
						break;
					case 8:
						Collections.sort(cust,new Comparator<Customer>() {
							@Override
							public int compare(Customer o1, Customer o2) {
								System.out.println("in campare: dob and Lastname");
								int ret=o1.getDob().compareTo(o2.getDob());
								if(ret==0) 
									return o1.getlName().compareTo(o2.getlName());
					
								return ret;
							}
						});
						break;
					case 9:
						notpaidsubscimsg(cust);
						break;
					case 10:
						subcriforgreaterthanthreemonth(cust);
						break;
					case 11:
						subcriforgreaterthansixmonth(cust);
						break;
					case 12:
						System.out.println("Enter email and password");
						c1=forlogin(cust,sc.next(),sc.next());

						parseandvalidateAmount(c1.getPlan(),c1.getRegistrationAmount());
						c1.setLastSubscriptionPaidDate(LocalDate.now());
						System.out.println(c1);
						break;
					case 13:
						System.out.println("Enetr file name");
						storecustomerdetails(cust,sc.next());
						System.out.println("stored successfully");
						break;
					case 14:
						System.out.println("Enter file anme");
						readcustomerdetails(sc.next());
						System.out.println("Read done");
						break;
					case 15:
						System.out.println("Enetr file name");
						storecustomerdetails1(cust,sc.next());
						System.out.println("stored successfully");
						break;
					case 16:
						System.out.println("Enter file anme");
						restorecustomerdetails1(sc.next());
						cust.forEach(p->System.out.println(p));
						System.out.println("Read done");
						break;
					case 0:
						break;
					}
					
				}catch(Exception e)
				{
					sc.nextLine();
					e.printStackTrace();
				}
			}
			
		}

	}

}
