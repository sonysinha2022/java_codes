package com.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable
{

	private int customer_id;
	private String fName, lName, email, password, addr, phone_no;
	private transient LocalDate RegisterDate, planEndDate;
	private MessPlan plan;
	private double final_amount;
	
	
	public Customer(int customer_id, String fName, String lName, String email, String password, String addr,
			String phone_no, LocalDate registerDate, LocalDate planEndDate, MessPlan plan, double final_amount) {
		super();
		this.customer_id = customer_id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.addr = addr;
		this.phone_no = phone_no;
		RegisterDate = registerDate;
		this.planEndDate = planEndDate;
		this.plan = plan;
		this.final_amount = final_amount;
		
		
		
	}

	
	public Customer(String email) {
		super();
		this.email = email;
	}

	public Customer(int customer_id) {
		//super();
		this.customer_id = customer_id;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", password=" + password + ", addr=" + addr + ", phone_no=" + phone_no + ", RegisterDate="
				+ RegisterDate + ", planEndDate=" + planEndDate + ", plan=" + plan + ", final_amount=" + final_amount
				+ "]";
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


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getPhone_no() {
		return phone_no;
	}


	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}


	public LocalDate getRegisterDate() {
		return RegisterDate;
	}


	public void setRegisterDate(LocalDate registerDate) {
		RegisterDate = registerDate;
	}


	public LocalDate getPlanEndDate() {
		return planEndDate;
	}


	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}


	public MessPlan getPlan() {
		return plan;
	}


	public void setPlan(MessPlan plan) {
		this.plan = plan;
	}


	public double getFinal_amount() {
		return final_amount;
	}


	public void setFinal_amount(double final_amount) {
		this.final_amount = final_amount;
	}
	
	
	
	
}
