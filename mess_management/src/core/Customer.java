package core;
import java.io.Serializable;
//import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDate;
import core.Plan;

public class Customer //implements Serializable 
{
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String address;
	private  transient LocalDate registerDate;
	private double amt;
	private transient LocalDate planEndDate;
	private String phoneNo;
	private Plan plan;
	
	
	public Customer(int id, String fname, String lname, String email, String password, String address,
			LocalDate registerDate, double amt, String phoneNo, Plan plan) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.registerDate = registerDate;
		this.amt = amt;
		//this.planEndDate = planEndDate;
		this.phoneNo = phoneNo;
		this.plan = plan;
			
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", address=" + address + ", registerDate=" + registerDate + ", amt=" + amt
				 + ", phoneNo=" + phoneNo + ", plan=" + plan + "]";
		
		
	}
		
		
	public Customer(String email) {
		super();
		this.email = email;
	}


	public Customer(int id) {
		//super();
		this.id = id;
	}
		


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public LocalDate getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}


	public double getAmt() {
		return amt;
	}


	public void setAmt(double amt) {
		this.amt = amt;
	}


	


	


	public LocalDate getPlanEndDate() {
		return planEndDate;
	}


	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public Plan getPlan() {
		return plan;
	}


	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	
	
	
	public void discount()
	{
		if (this.getPlan()==Plan.YEARLY)
			this.plan.setMesscharges(plan.getMesscharges()-(plan.getMesscharges()*0.2));
	}
	
	
	


	//public LocalDate setCalculatedEndDate()
	public LocalDate setCalculatedEndDate()
	{
		if(this.getPlan()==plan.MONTHLY)
		{
			return registerDate.plusMonths(1);
		}
		
		if(this.getPlan()==plan.QUATERLY)
		{
			return registerDate.plusMonths(4);
			
		}
		
		if(this.getPlan()==plan.HALFYEARLY)
		{
			return registerDate.plusMonths(6);
		}
		
		if(this.getPlan()==plan.YEARLY)
		{
			return registerDate.plusMonths(12);
		}
		return registerDate ;
		
	}


	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


