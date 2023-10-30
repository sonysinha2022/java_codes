package tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;
import java.util.Iterator;
import java.time.Period;

import comm.Customer;
import comm.Plan;

import customerexception.InvalidInputException;
import customerordering.CustomerdobComparator;
import utills.CustomerValidations;

import static utills.CustomerValidations.validateAllInputs;
import static utills.Customerutills.*;



public class Testter {

	public static void main(String[] args)
	{
		try(Scanner sc=new Scanner(System.in)){
			List<Customer> customers= populateCustomerManagement(); 
			boolean exit =false;
			while(!exit) {
				System.out.println("Options:\n1.Sign up \n2.Sign in \n3.Change password \n4.Un-subscribe customer \n5.Display All \n6.Sort by Email \n7.Sort by DOB \n8.Sort by DOB and Lastname"
						+ " \n9.Renew Plan \n10.Customer Names(Expired Subscription) \n11.Remove Customve(Expired Subscription) \n0.Exit");
				System.out.println("---------------------------");
				try {
					switch(sc.nextInt()) {
					
						case 1:
							System.out.println("----Sign Up----");
							//firstname,lastname,email,password,registration_Amount,dob,plan
							System.out.println("Enter: \nFirstname, Lastname,Email,Password,Registration Amount,Dob,Service Plan:");
							Customer customer=validateAllInputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),LocalDate.now(),sc.next(),customers);
							customers.add(customer);
							break;
						
						case 2:
							System.out.println("---Login---");
							System.out.print("Enter Email:");
							Customer cust1=findByEmail(sc.next(),customers);
							System.out.print("Enter Password:");
							authCustomer(sc.next(),cust1);
			
							break;
							
						case 3:
							System.out.println("---Change Password---");
							System.out.print("Enter Email:");
							cust1=findByEmail(sc.next(),customers);
							System.out.println("Enter: Old Password,New Password");
							changePassword(sc.next(),sc.next(),cust1);
							break;
							
						case 4:
							System.out.println("---Un subscribe---");
							System.out.print("Enter Email:");
							boolean removed=customers.remove(new Customer(sc.next()));
							if(removed)
								System.out.println("Un Subscribed");
							else
								throw new InvalidInputException("Inavaild Email");
							break;
							
						case 5:
							System.out.println("---Display All---");
							for(Customer cust2:customers) {
								System.out.println(cust2);
							}
							break;
							
						case 6:
							System.out.println("---Sort by Email---");
							Collections.sort(customers);
							break;
							
						case 7:
							System.out.println("---Sort by DOB---");
							Collections.sort(customers, new CustomerdobComparator());
							break;
							
						case 8:
							System.out.println("---Sort by DOB and Lastname---");
							Collections.sort(customers, new Comparator<Customer>() {

								@Override
								public int compare(Customer o1, Customer o2) {
									int ret=o1.getDob().compareTo(o2.getDob());
									if(ret==0)
									{
										return o1.getLastname().compareTo(o2.getLastname());
									}
									return ret;
								}			
							});
							break;
							
						case 9:
							System.out.println("---Renew Plan---");
							System.out.print("Enter Email:");
							cust1=findByEmail(sc.next(),customers);
							System.out.print("Enter Password:");
							authCustomer(sc.next(),cust1);
							for(Plan e:Plan.values())
							{System.out.println(e);}
							System.out.println("--------------");
							System.out.println("Select Plan:");
							cust1.setPlan(CustomerValidations.parseAndValidatePlan(sc.next()));
							System.out.print("Enter Amount:");
							cust1.setRegistration_Amount(sc.nextDouble());
							cust1.setLastSubscriptionPaidDate(LocalDate.now());
							break;
							
						case 10:
							System.out.println("----Customer Names(Expired Subscription)----");
							Iterator<Customer> CustItr= customers.iterator();
							System.out.println("---Names---");
							while(CustItr.hasNext())
							{
								Customer c1=CustItr.next();
								Period P=Period.between(c1.getLastSubscriptionPaidDate(), LocalDate.now());
								if( P.toTotalMonths()>=4 ) {
									System.out.println(c1.getFirstname()+" "+c1.getLastname());
								}
							}
							System.out.println("--------------------");
							break;
							
						case 11:
							System.out.println("----Remove Customve(Expired Subscription)----");
							Iterator<Customer> CustItr1= customers.iterator();
							while(CustItr1.hasNext())
							{
								Customer c2=CustItr1.next();
								Period P=Period.between(c2.getLastSubscriptionPaidDate(), LocalDate.now());
								if( P.toTotalMonths()>=4 ) {
									CustItr1.remove();
								}
							}
							System.out.println("--------------------");
							break;
						case 0:
							exit=true;
							System.out.println("Exiting...");
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