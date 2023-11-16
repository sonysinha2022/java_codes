package Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.time.LocalDate.parse;
import com.code.Customer;

import com.code.ServicePlan;

public class CustomerRecord {
	
	public static List<Customer> populateList(){
		List<Customer> cust=new ArrayList<>();
		cust.add(new Customer("Monika", "Kardile", "monikakardile@gmail.com", "mnk@123", 1000, parse("2020-08-24"), ServicePlan.SILVER,parse("2023-03-05")));
		cust.add(new Customer("Akan", "Gadge", "akanksa@gmail.com", "aka@123",2000, parse("2020-08-24"), ServicePlan.GOLD,parse("2023-02-15")));
		cust.add(new Customer("Angha", "Thorat", "angha@gmail.com", "ang@123", 5000, parse("2022-06-07"), ServicePlan.DIAMOND,parse("2023-06-21")));
		cust.add(new Customer("Divya", "Shiral", "divya@gmail.com", "dvy@123", 2000, parse("2021-12-13"), ServicePlan.GOLD,parse("2023-05-06")));
		cust.add(new Customer("Hindavi", "Dhole", "hindavi@gmail.com", "hnd@123", 2000, parse("2022-09-28"), ServicePlan.GOLD,parse("2023-05-25")));
		
		return cust;
		
	}

}
