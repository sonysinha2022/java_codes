package com.code;

import java.time.LocalDate;

public class CustomerMangSys {
	
	private int id;
	private String fName;
	private String lName;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int idcounter;
	private LocalDate lastSubscriptionPaidDate;
	
	
	static {
		idcounter=0;
	}
	public CustomerMangSys(String fName, String lName, String email, String password, double registrationAmount,
			LocalDate dob, ServicePlan plan, LocalDate lastSubscriptionPaidDate) {
		super();
		idcounter=idcounter+1;
		id=idcounter;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
		this.lastSubscriptionPaidDate = lastSubscriptionPaidDate;
	}
	
	public CustomerMangSys(String email) {
		super();
		this.email = email;
	}

	@Override
	public String toString() {
		return "CustomerMangSys [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", password=" + password + ", registrationAmount=" + registrationAmount + ", dob=" + dob + ", plan="
				+ plan + ", lastSubscriptionPaidDate=" + lastSubscriptionPaidDate + "]";
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
	public LocalDate getLastSubscriptionPaidDate() {
		return lastSubscriptionPaidDate;
	}
	public void setLastSubscriptionPaidDate(LocalDate lastSubscriptionPaidDate) {
		this.lastSubscriptionPaidDate = lastSubscriptionPaidDate;
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
//	@Override
//	public boolean equals(Object o)
//	{
//		if(o instanceof CustomerMangSys)
//			return this.email.equals(((CustomerMangSys) o).email);
//					
//		return false;
//		
//	}
//	

	public CustomerMangSys(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	
	
	

}
