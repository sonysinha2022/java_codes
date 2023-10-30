package comm;

import java.time.LocalDate;

public class Customer implements Comparable<Customer>{
	private int cust_id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private double registration_Amount;
	private LocalDate dob;
	private LocalDate lastSubscriptionPaidDate;
	private Plan plan;
	//static id generator
	private static int idGenerator;
	
	static {idGenerator=0;}
	
	public Customer(String firstname, String lastname, String email, String password, double registration_Amount,
			LocalDate dob, LocalDate lastSubscriptionPaidDate, Plan plan) {
		super();
		this.cust_id=++idGenerator;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.registration_Amount = registration_Amount;
		this.dob = dob;
		this.lastSubscriptionPaidDate=lastSubscriptionPaidDate;
		this.plan = plan;
	}
	
	//Overloaded constructor for email
	public Customer(String email)
	{
		super();
		this.email=email;
	}
	
	//Overloaded constructor for date
	public Customer(LocalDate lastSubscriptionPaidDate)
	{
		super();
		this.lastSubscriptionPaidDate=lastSubscriptionPaidDate;
	}
	
	@Override
	public String toString() {
		return "Customer [Id=" + cust_id + ", Firstname=" + firstname + ", Lastname=" + lastname + ", Email="
				+ email + ", Password=" + password + ", Registration Amount=" + registration_Amount + ", Date of Birth=" + dob
				+ ", Last Subscription Paid Date=" + lastSubscriptionPaidDate+ ", Plan=" + plan + "]";
	}
	

	@Override
	public boolean equals(Object anotherObj)
	{
		System.out.println("in customer eq");
		if (anotherObj instanceof Customer)
		{
			return this.email.equals(((Customer)anotherObj).email);
		}
		return false;
	}

	//getters and setters
	public int getCust_id() {
		return cust_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public double getRegistration_Amount() {
		return registration_Amount;
	}

	public void setRegistration_Amount(double registration_Amount) {
		this.registration_Amount = registration_Amount;
	}
	
	public LocalDate getDob() {
		return dob;
	}

	public LocalDate getLastSubscriptionPaidDate() {
		return lastSubscriptionPaidDate;
	}

	public void setLastSubscriptionPaidDate(LocalDate lastSubscriptionPaidDate) {
		this.lastSubscriptionPaidDate = lastSubscriptionPaidDate;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	//compare 
	@Override
	public int compareTo(Customer o) {
		System.out.println("Comparable email");
		return this.email.compareTo(o.email);
	}

}