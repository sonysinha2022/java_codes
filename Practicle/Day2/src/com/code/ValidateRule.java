package com.code;
import java.util.Date;
import static com.code.Vehicle.sfd;
import com.code.Vehicle;
import com.code.Mfdisnotvalid;
import java.text.SimpleDateFormat;
import  java.text.ParseException;


public class ValidateRule {
	private static Date d2;
	static Date d1;
	static 
	{
		try {
			d1=sfd.parse("2021-01-01");
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static Date parseandValidatemanufdate (String s) throws ParseException,Mfdisnotvalid
	{
		System.out.println("Date is ");
	  	d2=sfd.parse(s);
	  	
	  	if(d2.after(d1))
	  		throw new Mfdisnotvalid("Mfd is valid !");
	  	else
	  		throw new Mfdisnotvalid("Mfd Date is invalid !");
	  
	}

	

}
