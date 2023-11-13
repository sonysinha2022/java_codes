package Tester;

import java.time.LocalDate;
import java.util.Scanner;

import core.Plan;
public class Test1
{ 
	public static void main (String [] args)
	{
	 try(Scanner sc=new Scanner(System.in))
	 {
		 System.out.println("id, fname, lname, email, password, address,registerDate,  amt, phoneNo,  plan");
	 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
	}

}
