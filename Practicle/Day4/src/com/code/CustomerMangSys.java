package com.code;

import java.time.LocalDate;

public class CustomerMangSys {
	
	//
	//state  : customer id(int) ,first name, last name (string),email(string),password(string),
	//registrationAmount(double),dob(LocalDate),plan(ServicePlan : enum)
	//Must generate customer ids automatically : auto increment)
	//PK(UID) : email
	
	private int id;
	private String fName;
	private String lName;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int idcounter;
	
	static {
		idcounter=0;
	}
	
	
	public CustomerMangSys(String fName, String lName, String email, String password, double registrationAmount,
			LocalDate dob, ServicePlan plan) {
		super();
		idcounter=idcounter+1;
		this.id = idcounter;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
		
		
	}
	


	public CustomerMangSys(String email) {
		super();
		this.email = email;
	}



	@Override
	public String toString() {
		return "CustomerMangSys [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", password=" + password + ", registrationAmount=" +(registrationAmount+plan.getsPlan()) +"dob=" + dob + ", plan="
				+ plan + "]";
	}
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public  boolean equals(Object oObj)
	{
		System.out.println("you are in equals");
		if(oObj instanceof CustomerMangSys)
		{
			return this.email.equals(((CustomerMangSys)oObj).email);
			
		}
		return false;
		
		
	}
	
	
	
	

}
