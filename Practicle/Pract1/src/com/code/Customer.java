package com.code;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Comparable<Customer>,Serializable{
	
//	Customer class (core class)
//	state  : customer id(int) ,first name, last name (string),email(string),password(string),registrationAmount(double),dob(LocalDate),plan(ServicePlan : enum)
//	Must generate customer ids automatically : auto increment)
//	PK(UID) : email
	
	private int customer_id;
	private String fName,lName,email,password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int idcounter;
	private  LocalDate lastSubscriptionPaidDate;
	
	static {
		idcounter=0;
	}

	public Customer(String fName, String lName, String email, String password,
			double registrationAmount, LocalDate dob, ServicePlan plan,LocalDate lastSubscriptionPaidDate) {
		super();
		idcounter=idcounter+1;
		this.customer_id = idcounter;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
		this.lastSubscriptionPaidDate=lastSubscriptionPaidDate;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRegistrationAmount() {
		return registrationAmount;
	}

	public void setRegistrationAmount(double registrationAmount) {
		this.registrationAmount = registrationAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	public static int getIdcounter() {
		return idcounter;
	}

	public static void setIdcounter(int idcounter) {
		Customer.idcounter = idcounter;
	}

	public Customer(String email) {
		super();
		this.email = email;
	}

	
	public boolean equals(Object o)
	{
		if(o instanceof Customer)
		{
			Customer c=(Customer) o;
			return this.email.equals(c.email);
		}
		return false;
		
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", password=" + password + ", registrationAmount=" + registrationAmount + ", dob=" + dob + ", plan="
				+ plan + ", lastSubscriptionPaidDate=" + lastSubscriptionPaidDate + "]";
	}

	public int compareTo(Customer cms)
	{
		
		return this.email.compareTo(cms.email);
		
	}

	public LocalDate getLastSubscriptionPaidDate() {
		return lastSubscriptionPaidDate;
	}

	public void setLastSubscriptionPaidDate(LocalDate lastSubscriptionPaidDate) {
		this.lastSubscriptionPaidDate = lastSubscriptionPaidDate;
	}
	


	
	

}
