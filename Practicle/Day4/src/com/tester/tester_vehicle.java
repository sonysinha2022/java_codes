package com.tester;
import com.code.Mfdisnotvalid;
import com.code.Vehicle;
import static com.code.ValidateRule.parseandValidatemanufdate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import static com.code.Vehicle.sfd;
import com.code.Color;
import com.code.ValidateRule;

public class tester_vehicle {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		Color cols;
//		System.out.println("Enter Color:");
//		String str = sc.next();
//		// converting String value into enum type valueOf(String)
//		cols = Color.valueOf(str);
//		System.out.println("Color:" + cols);
//		System.out.println("Enter the chasis no,price,company");
//		String chasisno=sc.next();
//		double price=sc.nextDouble();
//		String company=sc.next();
         
		
		
		
		//Date d1=null;
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Date !");
			String str2 = sc.next();
		  parseandValidatemanufdate(str2);
		  System.out.println("dATE");
		}
		catch(Mfdisnotvalid m)
		{
			System.out.println(m);
		}
		catch(Exception e)
		{
			System.out.println("Failed");
		}
		
		
		//Vehicle v1=new Vehicle(chasisno,cols,price,d1,company);
		
		
	}

}
