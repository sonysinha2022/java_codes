package com.tester;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import com.code.Customer;
import com.code.MessPlan;

import static utils.CustomerCollection.*;
import static com.validate.ValidateRule.*;

import static utils.CustomerCollection.*;
import static java.time.LocalDate.parse;
import static utils.IO_utils.*;

public class MonthlyMessSystemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Customer> custMap = populateMap();
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			while (!false) {
				try {
					System.out.println("options:" + "1.Sign up Customer\n" + "2.If already register then sign in\n"
							+ "3.Change Password \n" + "4.Sort Customer\n"
							+ "5.Unsubscribe customer according plan duration (month wise (1, 3, 6, 12))\n"
							+ "6.display\n" + "7.Modify all customers first name \n"
							+ "8.Display email addresses of the customers who did registration in month of January\n"
							+ "9.Display count of the Customers who have register for plan: Monthly\n"
							+ "10.Search the Customer who lived in Akurdi\n"
							+ "11.Give the 20% discount to the customers who have selected plan for 1 year\n"
							+ "12.store customer record\n" + "13.restore customer record\n" + "0.exit\n");
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter customer_id,fName, lName, email, password,addr,phone_no,registerDate,planEndDate,plan,final_amount");
						Customer c = validateAllInput(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), custMap);
						custMap.put(c.getCustomer_id(), c);
						System.out.println("Record added successfully");
						break;
					case 2:
						System.out.println("Enter email_id and password");
						c = forLogin(custMap, sc.next(), sc.next());
						System.out.println("login success");
						break;
					case 3:
						System.out.println("Enter email_id and password");
						c = forLogin(custMap, sc.next(), sc.next());
						System.out.println("Enter new password");
						c.setPassword(sc.next());
						System.out.println("Password updated");
						break;
					case 4:
						System.out.println("Sorted as per first name");
						custMap.values().stream().sorted((c1, c2) -> c1.getfName().compareTo(c2.getfName()))
								.forEach(System.out::println);
						System.out.println("Sorted as per plan");
						custMap.values().stream().sorted((c1, c2) -> c1.getPlan().compareTo(c2.getPlan()))
								.forEach(System.out::println);
						System.out.println("Sorted as per date of registration");
						custMap.values().stream()
								.sorted((c1, c2) -> c1.getRegisterDate().compareTo(c2.getRegisterDate()))
								.forEach(System.out::println);
						break;
					case 5:
						// Unsubscribe customer according plan duration (month wise (1, 3, 6, 12))
						System.out.println("Unsubscribe customer according to month plan duration");
						custMap.values().removeIf(c3 -> c3.getPlan() == MessPlan.Monthly);
						custMap.values().forEach(System.out::println);
						System.out.println("Unsubscribe customer according to year plan duration ");
						custMap.values().removeIf(c3 -> c3.getPlan() == MessPlan.Yearly);
						custMap.values().forEach(System.out::println);
						System.out.println("Unsubscribe customer according to half year plan duration ");
						custMap.values().removeIf(c3 -> c3.getPlan() == MessPlan.Half_Year);
						custMap.values().forEach(System.out::println);
						System.out.println("Unsubscribe customer according to Quarterly plan duration ");
						custMap.values().removeIf(c3 -> c3.getPlan() == MessPlan.Quarterly);
						custMap.values().forEach(System.out::println);
						break;
					case 6:
						custMap.values().stream().forEach(s -> System.out.println(s));
						break;
					case 7:// Modify all customers first name (make first Letter capital of customers first
							// name)
						System.out.println("set name to customer");
						for (Customer cust : custMap.values()) {
							String firstname = cust.getfName().substring(0, 1).toUpperCase()
									+ cust.getfName().substring(1).toLowerCase();
							cust.setfName(firstname);
						}
						System.out.println("Name change successfully");
						break;
					case 8:// Display email addresses of the customers who did registration in month of
							// January
						custMap.values().stream().filter(s -> s.getRegisterDate().getMonthValue() == 1)
								.forEach(s -> System.out.println(s.getEmail()));
						break;
					case 9:// Display count of the Customers who have register for plan: Monthly
						int count = (int) custMap.values().stream().filter(c1 -> c1.getPlan().equals(MessPlan.Monthly))
								.count();
						System.out.println("Count is:" + count);
						break;
					case 10:
						// Search the Customer who lived in Akurdi.
						custMap.values().stream().filter(c2 -> c2.getAddr().equals("Akurdi"))
								.forEach(System.out::println);
						break;
					case 11:// Give the 20% discount to the customers who have selected plan for 1 year.
						for (Customer cust : custMap.values()) {
							if (cust.getPlan().equals(MessPlan.Yearly)) {
								double amount = cust.getFinal_amount() - (cust.getFinal_amount() * 0.2);
								cust.setFinal_amount(amount);
								System.out.println(cust);
							}
						}
						break;
					case 12:
						System.out.println("Enetr the file name");
						storeCustomerDetails(custMap, sc.next());
						System.out.println("Record store successfully");
						break;
					case 13:
						try {
						System.out.println("Enter file name");
						custMap = reStoreCustomerDetails(sc.next());
						System.out.println("Date restore successfully");
						custMap.forEach((k, v) -> System.out.println(v));
						} catch (Exception e) {
						e.printStackTrace();
						}
						break;
					case 0:
						exit = true;
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
