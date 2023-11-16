package com.tester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.code.CustomerMangSys;
import static Utils.CustomerRecords.populatecustomermap;
import static Utils.ValidatePaln.*;
public class TestCustomerMangSys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner sc=new Scanner(System.in)){
			Map<String,CustomerMangSys> cms=populatecustomermap();
			boolean exit=false;
			while(!exit)
			try
				{
				System.out.println("Enter your choice\n" + "1.Sign up\n" + "2.Sign in\n" + 
			               "3.Change password\n" + "4.Remove customer by email\n"
						+ "5.Display customer\n" +"6.sort by email\n" +"7.sort by date\n"+ 
			               "8.sort by date and last name\n"+"9.calculateperiod and display msg\n" + 
						"10.subscription pending for last 3 month\n" 
			               +"11.subscription pending for last 6 month\n" +"0.Exit");
					switch(sc.nextInt()) {
					case 1:
						System.out.println("Enter fName, lName, email, password, registrationAmount, dob, plan,LSPD");
						CustomerMangSys c1=validateAllInput(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),sc.next(),cms);
						System.out.println(c1);
						System.out.println("Customer Added successfully");
						break;
					case 2:
						System.out.println("Enter email and password");
						checkEmail(sc.next(),cms);
						System.out.println("Login successfully");
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						for(CustomerMangSys c:cms.values())
							System.out.println(c);
						break;
					case 0:
						exit = true;
						break;
						
					
					}
					
				}catch(Exception e)
				{
					System.out.println(e);
					e.printStackTrace();
				}
				
			}
		}

	}


