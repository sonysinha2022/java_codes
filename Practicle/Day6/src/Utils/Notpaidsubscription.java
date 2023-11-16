package Utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.code.CustomerMangSys;

import custom.exception.InvalidInputException;

public class Notpaidsubscription {

	public static void notpaidsubscimsg(List<CustomerMangSys> customers) throws InvalidInputException {

		ListIterator<CustomerMangSys> cms = customers.listIterator();
		while (cms.hasNext()) {
			long periodInMonth = Period.between(cms.next().getLastSubscriptionPaidDate(), LocalDate.now())
					.toTotalMonths();
			System.out.println("period is !" + periodInMonth);
			if (periodInMonth > 3)
				System.out.println("Please pay subcription amount");

		}

	}

	public static void subcriforgreaterthanthreemonth(List<CustomerMangSys> customers) throws InvalidInputException {
		for(CustomerMangSys cms:customers)
		{
		Long periodInMonth1 = Period.between(cms.getLastSubscriptionPaidDate(), LocalDate.now()).toTotalMonths();
		System.out.println("period is !" + periodInMonth1);
		if (periodInMonth1 > 3)
		System.out.println("Subcribtion is greater than 3 month");
			
	}
	}
	
	public static void subcriforgreaterthansixmonth(List<CustomerMangSys> customers) throws InvalidInputException {
		ListIterator<CustomerMangSys> cms = customers.listIterator();
		while(cms.hasNext())
		{
			Long periodInMonth2 = Period.between(cms.next().getLastSubscriptionPaidDate(), LocalDate.now()).toTotalMonths();
			System.out.println("period is !" + periodInMonth2);
			if (periodInMonth2 > 6) {
				cms.remove();
				System.out.println("Please pay subcription amount");
			}
			
		}
		
	}
}

