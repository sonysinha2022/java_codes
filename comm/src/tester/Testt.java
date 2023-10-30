package tester;

import java.util.Scanner;

import comm.Customer;
import static utills.CustomerValidations.validateAllInputs;

public class Testt {
	public static void main(String[] args) {
	try (Scanner sc=new Scanner(System.in)){
		System.out.println("Firstname, lastname, email, password, registration_Amount, userDob, servicePlan");
		//Customer cust=validateAllInputs(sc.next(),sc.next(),sc.next(), sc.next(),sc.nextDouble(),sc.next(),sc.next());
		//System.out.println(cust);
	}
	catch(Exception e)
	{
		System.out.println(e);
		
	}
	}
}
