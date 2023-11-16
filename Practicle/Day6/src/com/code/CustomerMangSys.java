package com.code;

import java.time.LocalDate;

public class CustomerMangSys implements Comparable<CustomerMangSys> {
	
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
		idcounter = 0;
	}

	public CustomerMangSys(String fName, String lName, String email, String password, double registrationAmount,
			LocalDate dob, ServicePlan plan, LocalDate lastSubscriptionPaidDate) {
		super();
		idcounter = idcounter + 1;
		this.id = idcounter;
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

	public int compareTo(CustomerMangSys cms) {
		System.out.println("In comareTo method");
		return this.email.compareTo(cms.email);
	}

//	@Override
//	public String toString() {
//		return "CustomerMangSys [id=" + id + ",  fName=" + fName + ",  lName=" + lName + ",  email=" + email
//				+ ",   password=" + password + ",  " + " registrationAmount=" + (registrationAmount + plan.getsPlan())
//				+ ",  dob=" + dob + ", plan=" + plan + "]";
//	}
//	
	

	public String getfName() {
		return fName;
	}

	@Override
	public String toString() {
		return "CustomerMangSys [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", password=" + password + ", registrationAmount=" + registrationAmount + ", dob=" + dob + ", plan="
				+ plan + ", lastSubscriptionPaidDate=" + lastSubscriptionPaidDate + "]";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	

	public LocalDate getLastSubscriptionPaidDate() {
		return lastSubscriptionPaidDate;
	}
	

	public CustomerMangSys(LocalDate lastSubscriptionPaidDate) {
		super();
		this.lastSubscriptionPaidDate = lastSubscriptionPaidDate;
	}

	@Override
	public boolean equals(Object oObj) {
		System.out.println("you are in equals");
		if (oObj instanceof CustomerMangSys) {
			return this.email.equals(((CustomerMangSys) oObj).email);

		}
		return false;

	}

}
