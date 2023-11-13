package utils;

import java.util.Scanner;

import core.Customer;
import core.Plan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

import  static core.Plan.*;


//public Customer(int id, String fname, String lname, String email, String password, String address,
		//LocalDate registerDate, double amt,  String phoneNo, Plan plan) 

public class UtilsPopulate
{
 public static Map<String,Customer>  populateCustomer()
 {
	 @SuppressWarnings("rawtypes")
	Map<String,Customer> map=new HashMap();
	 map.put("sony@gmail.com", new Customer(1,"sona","sin","sony@gmail.com","sona","Pune",LocalDate.parse("2023-12-08"),3000,"7696505407",MONTHLY));
	 map.put("sam@gmail.com", new Customer(2,"asam","sah","sam@gmail.com","sami","Pune",LocalDate.parse("2023-11-18"),11500,"7696505907",QUATERLY));
	 map.put("sama@gmail.com", new Customer(3,"asama","saha","sama@gmail.com","samm","Sangli",LocalDate.parse("2024-01-18"),17500,"7696505907",HALFYEARLY));
	 map.put("aam@gmail.com", new Customer(1,"esam","sah","aam@gmail.com","samy","Akurdi",LocalDate.parse("2023-11-18"),32000,"7696505907",QUATERLY));
	 return map;
 }
}
