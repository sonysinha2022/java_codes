package utils;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.core.Customer;
import com.core.MessPlan;

import static java.time.LocalDate.parse;


//(int customer_id, String fName, String lName, String email, String password, String addr,
//String phone_no, LocalDate registerDate, LocalDate planEndDate, MessPlan plan, double final_amount) 

public class Cusutils 
{
	public static Map<Integer,Customer> populatecustomer()
	{
		Map<Integer,Customer> map=new HashMap<>();
		
		map.put(1, new Customer(1,"sa","si","son@gmail.com","asd","pun","7696505407",parse("2023-11-14"),parse("2023-12-14"),MessPlan.MONTHLY,3000));
		map.put(2, new Customer(2,"ma","ap","mna@gmail.com","sdf","ert","7696505403",parse("2023-11-23"),parse("2024-03-23"),MessPlan.QUARTERLY,11700));
		map.put(3, new Customer(3,"we","ws","qa@gmail.com","wsx","akurdi","7697504308",parse("2023-11-28"),parse("2024-05-28"),MessPlan.HALFYEARLY,17500));
		map.put(4, new Customer(4,"er","ws","asd@gmail.com","edf","akurdi","7697406302",parse("2023-12-27"),parse("2024-12-27"),MessPlan.YEARLY,32000));
		
		
		
		return map;
	}

}
