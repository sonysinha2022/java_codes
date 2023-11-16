package utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.code.Customer;
import com.code.MessPlan;
import static java.time.LocalDate.parse;

public class CustomerCollection {
	
	public static Map<Integer,Customer> populateMap() {
		Map<Integer,Customer> customerMap=new HashMap<>();
		
		customerMap.put(1, new Customer(1,"monika","Kardile","mnk@gmail.com","1234","pune","123456",parse("2023-11-05"),parse("2024-12-05"),MessPlan.Yearly,32000));
		customerMap.put(2, new Customer(2,"akanksha","Gadge","ak1@gmail.com","abcde","Mumbai","2345607",parse("2024-11-04"),parse("2024-12-04"),MessPlan.Monthly,3000.0));
		customerMap.put(3, new Customer(3,"hindavi","Dhole","hnd1@gmail.com","abcde","Nashik","345667",parse("2024-01-04"),parse("2024-07-04"),MessPlan.Half_Year,3000.0));
		customerMap.put(4, new Customer(4,"sang","Gadge","san@gmail.com","abcde","Akurdi","456734",parse("2024-11-04"),parse("2024-12-04"),MessPlan.Quarterly,3000.0));
		
		return customerMap;
		
		
	}

}