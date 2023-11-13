package Tester;

import static utils.UtilsPopulate.populateCustomer;

import java.util.Map;
import java.util.Scanner;

import Tester.IOUt;

import core.Customer;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import core.Customer;

// SERIALIZATION
//Serialization (Store)(Hint:-JAVA App->OOS->FOS)
//De-serialization (Restore)(Hint:-JAVA App<-OIS<-FIS)




public class Test3 {
	
	public static void  storeCustomerDetails(Map< String,Customer> map, String fName) throws IOException
	{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fName)))
		{
			out.writeObject(map);
		}
	}
	
	public static Map<String, Customer> restoreCustomerDetails(String fName)
	{
		try(ObjectInputStream in =new ObjectInputStream(new FileInputStream(fName)))
		{
			return (Map<String, Customer>)in.readObject();
		}
		catch(Exception e)
		{
			return new HashMap<>();
		}
	}

	public static void main(String[] args) throws IOException {
		try(Scanner sc=new Scanner(System.in))
		{
			Map<String, Customer>map=populateCustomer();
			for(Customer c:map.values())
			{
				c.setPlanEndDate(c.setCalculatedEndDate());
			}
			boolean exit=false;
			while(!exit)
			{
				
			System.out.println("Enter options: \n 1 .Display all \n 2.Sign up \n 3 sign in \n 4 Change password \n 5 Sort as per as first name "
					+ "\n 6 sort as per as plan \n 7 sort as per as registration date \n 8 unscribe customer \n 9 modify first name to uppercase "
					+ "\n10 Display email addresses of the customers who did registration in month of January "
					+ "\n 11  Display count of the Customers who have register for plan: Monthly"
					+ "\n 12 Search the Customer who lived in Akurdi "
			        + "\n 13 Give the 20% discount to the customers who have selected plan for 1 year"
					+ "\n 14 Serialization"
			        + "\n 15 deserialization");
			System.out.println("Enter choice:");
			
			
			
				switch(sc.nextInt())
				{
				
				case 14: System.out.println("Enetr the file name"); //xyz.ser
				storeCustomerDetails(map, sc.next());
				System.out.println("Record store successfully");
			    break;
				
         		case 15: 
         			try
         			{
         				System.out.println("Enter file name");
    					Map<String, Customer> map1 = restoreCustomerDetails(sc.next());
    					System.out.println("Date restore successfully");
    					map1.forEach((k, v)-> System.out.println(v));
    					} 
         			    catch (Exception e) 
         			    {
    					e.printStackTrace();
    					}
    					break;
         			
					
				case 0:
					exit=true;
					System.out.println("exit");
					
				}

	            }

}
}

	
}
