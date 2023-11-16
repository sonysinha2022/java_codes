package Utils;

import java.util.List;
import java.util.Scanner;

import com.code.CustomerMangSys;

import custom.exception.InvalidInputException;

public class Login {
	
	public static CustomerMangSys forLogin(String email,String password,List<CustomerMangSys> customers) throws InvalidInputException
	{
		
		CustomerMangSys c1=new CustomerMangSys(email);
		int index=customers.indexOf(c1);
		if(index!=-1)
			c1=customers.get(index);
		else
			throw new InvalidInputException("please enter valid email");
	
		if(password.equals(c1.getPassword()))
			System.out.println("succcesfulll login");
		else
			throw new InvalidInputException("please enter valid password");
		return c1;	
	}

}
