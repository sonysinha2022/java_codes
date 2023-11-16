package Utils;

import static java.time.LocalDate.parse;

import java.util.HashMap;
import java.util.Map;

import com.code.Customer;
import com.code.ServicePlan;

public class CustomerRecord {

	public static Map<String, Customer> populateMap() {
		Map<String, Customer> custMap = new HashMap<>();

		custMap.put("monikakardile@gmail.com", new Customer("Monika", "Kardile", "monikakardile@gmail.com", "mnk@123",
				1000, parse("2020-08-24"), ServicePlan.SILVER, parse("2023-03-05")));
		custMap.put("akanksa@gmail.com", new Customer("Akan", "Gadge", "akanksa@gmail.com", "aka@123", 2000,
				parse("2020-08-24"), ServicePlan.GOLD, parse("2023-02-15")));
		custMap.put("angha@gmail.com", new Customer("Angha", "Thorat", "angha@gmail.com", "ang@123", 5000,
				parse("2022-06-07"), ServicePlan.DIAMOND, parse("2023-06-21")));
		custMap.put("divya@gmail.com", new Customer("Divya", "Shiral", "divya@gmail.com", "dvy@123", 2000,
				parse("2021-12-13"), ServicePlan.GOLD, parse("2023-05-06")));
		custMap.put("hindavi@gmail.com", new Customer("Hindavi", "Dhole", "hindavi@gmail.com", "hnd@123", 2000,
				parse("2022-09-28"), ServicePlan.GOLD, parse("2023-05-25")));

		return custMap;

	}

}
