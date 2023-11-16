package com.tester;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import com.code.Customer;
import com.code.ServicePlan;
import java.util.stream.Stream;
import static Utils.IO_Utils.*;

import static Utils.CustomerRecord.*;
import static validation_rules.ValidationRules.*;
public class CustomerSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Customer> custMap = populateMap();
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			while (!false) {
				try {
					System.out.println("--------------");
					System.out.println("Options: " + "1.Sign up" + "2. Sign in (login)" + "3.Change password"
							+ "4.Un subscribe customer" + "5.Display all customers." + "6.sort by email\n"
							+ "7.sort by date\n" + "8.sort by date and last name\n"
							+ "9.not paid subscription(last 3 month)\n" + "10.subscription pending for last 3 month\n"
							+ "11.subscription pending for last 6 month\n" + "12.pay subcription amount\n"
							+ "13.store data(txt)\n" + "14.read data(txt)\n" + "15.store data(ser)\n"
							+ "16.read data(desce)\n" + "0.exit");
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter fName,lName,email,password,registrationAmount,dob,plan,lastSubscriptionPaidDate");
						Customer c1=validateAllInput(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),sc.next(),custMap);
						custMap.put(c1.getEmail(), c1);
						System.out.println("Record added");
						break;
					case 2:
						System.out.println("Enter email and password");
						c1=forLogin(custMap,sc.next(), sc.next());
						System.out.println("Sign in sucessfully");
						break;
					case 3:
						System.out.println("Enter eamil and password");
						c1=forLogin(custMap,sc.next(),sc.next());
						System.out.println("enter password");
						c1.setPassword(sc.next());
						System.out.println("password cahnge successfullly");
						break;
					case 4:
						System.out.println("Enter custmer id");
						int cn=sc.nextInt();
						custMap.values().removeIf(s -> s.getCustomer_id()==cn);
						System.out.println("remove successfully");
						break;
					case 5:
//						for(Customer c:custMap.values())
//							System.out.println(c);
						custMap.values().stream().forEach(p->System.out.println(p));
						break;
					case 6:
						Stream <Customer>cust=custMap.values().stream()
						.sorted((c,c2)->c.getEmail().compareTo(c2.getEmail()));
						cust.forEach(System.out::println);
						break;
					case 7:
						Stream<Customer> cust1=custMap.values().stream()
						.sorted((c4,c5)->c4.getDob().compareTo(c5.getDob()));
						cust1.forEach(System.out::println);
						break;
					case 8:
						Stream<Customer> cust2=custMap.values().stream()
						.sorted((c4,c5)->c4.getDob().compareTo(c5.getDob()))
						.sorted((c4,c5)->c4.getlName().compareTo(c5.getlName()));
						cust2.forEach(System.out::println);
						
						break;
					case 13:
						System.out.println("Enter file name");
						storeCustomerdetails(custMap,sc.next());
						System.out.println("data store");
						break;
					case 14:
						System.out.println("Enter file name");
						readCustomerdetails(sc.next());
						System.out.println("Read success");
						break;
					case 15:
						System.out. 
						println("Enter file name");
						storeCustomerdetails1(custMap,sc.next());
						System.out.println("date store");
						break;
					case 16:
						System.out.println("Enter file name");
						restoreCustomerdetails1(sc.next());
						custMap.forEach((k,v)->System.out.println(v));
						System.out.println("read success");
						break;

					}

				} catch (Exception e) {
					sc.nextLine();
					e.printStackTrace();
				}
			}

		}

	}

}
