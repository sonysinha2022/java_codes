package Utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.ListIterator;

import com.code.Customer;

public class Notpaidsubscription {
	
	//how will you find out the complete names of the customers , who have not paid the subscription (reg amount) , for last 3 months ?
	public static void notpaidsubscimsg(List<Customer> cust) {
		ListIterator <Customer> itrcust=cust.listIterator();
		while(itrcust.hasNext())
		{
			long periodinmonth=Period.between(itrcust.next().getLastSubscriptionPaidDate(),LocalDate.now()).toTotalMonths();
			if(periodinmonth>3)
				System.out.println("Pay subcr amount");
		}
		
	}
	
	//display complete names of the customers , who have not paid the subscription (reg amount) , for last 3 months ?
	public static void subcriforgreaterthanthreemonth(List<Customer> cust)
	{
		for(Customer cms:cust)
		{
			long periodinmonth1=Period.between(cms.getLastSubscriptionPaidDate(), LocalDate.now()).toTotalMonths();
			if(periodinmonth1>3)
				System.out.println("Subcribtion is greater than 3 month");
		}
	}
	//How will you remove all those customer details whose subscription is pending for last 6 months?
	public static void subcriforgreaterthansixmonth(List<Customer> cust) {
		ListIterator<Customer> itrcust=cust.listIterator();
		while(itrcust.hasNext())
		{
			long periodinmonth2=Period.between(itrcust.next().getLastSubscriptionPaidDate(), LocalDate.now()).toTotalMonths();
			if(periodinmonth2>6) {
				itrcust.remove();
				System.out.println("Please pay subcription amount");
			}
				
		}
	}

}
