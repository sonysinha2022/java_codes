package Utils;
import static java.time.LocalDate.parse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.code.CustomerMangSys;
import com.code.ServicePlan;

public class CustomerRecords {
	
	public static List<CustomerMangSys> populateCustomer(){
		List<CustomerMangSys> customers=new ArrayList<>();
		
		customers.add(new CustomerMangSys("Monika", "Kardile", "monikakardile@gmail.com", "mnk@123", 1000, parse("2020-08-24"), ServicePlan.SILVER,parse("2023-05-05")));
		customers.add(new CustomerMangSys("Akan", "Gadge", "akanksa@gmail.com", "aka@123",2000, parse("2023-05-17"), ServicePlan.GOLD,parse("2023-06-15")));
		customers.add(new CustomerMangSys("Angha", "Thorat", "angha@gmail.com", "ang@123", 5000, parse("2022-06-07"), ServicePlan.DIAMOND,parse("2023-07-21")));
		customers.add(new CustomerMangSys("Divya", "Shiral", "divya@gmail.com", "dvy@123", 2000, parse("2021-12-13"), ServicePlan.GOLD,parse("2023-05-06")));
		customers.add(new CustomerMangSys("Hindavi", "Dhole", "hindavi@gmail.com", "hnd@123", 2000, parse("2022-09-28"), ServicePlan.GOLD,parse("2023-05-25")));
		
		return customers;
		
	}

}
