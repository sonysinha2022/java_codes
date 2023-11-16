package Utils;

import static java.time.LocalDate.parse;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.code.CustomerMangSys;
import com.code.ServicePlan;

public class CustomerRecords {
	
	public static Map<String,CustomerMangSys> populatecustomermap() {
		
		Map<String,CustomerMangSys> cms =new HashMap<>();
		
		System.out.println("Added"+cms.put("monikakardile@gmail.com",new CustomerMangSys("Monika", "Kardile", "monikakardile@gmail.com", "mnk@123", 1000, parse("2020-08-24"), ServicePlan.SILVER,parse("2021-05-05"))));
		System.out.println("Added"+cms.put("akanksa@gmail.com",new CustomerMangSys("Akan", "Gadge", "akanksa@gmail.com", "aka@123",2000, parse("2023-05-17"), ServicePlan.GOLD,parse("2022-06-15"))));
		System.out.println("Added"+cms.put("angha@gmail.com",new CustomerMangSys("Angha", "Thorat", "angha@gmail.com", "ang@123", 5000, parse("2022-06-07"), ServicePlan.DIAMOND,parse("2023-09-21"))));
		System.out.println("Added"+cms.put("divya@gmail.com",new CustomerMangSys("Divya", "Shiral", "divya@gmail.com", "dvy@123", 2000, parse("2021-12-13"), ServicePlan.GOLD,parse("2020-05-06"))));
		System.out.println("Added"+cms.put("hindavi@gmail.com",new CustomerMangSys("Hindavi", "Dhole", "hindavi@gmail.com", "hnd@123", 2000, parse("2022-09-28"), ServicePlan.GOLD,parse("2023-05-25"))));
		
		return cms;
	}

}
