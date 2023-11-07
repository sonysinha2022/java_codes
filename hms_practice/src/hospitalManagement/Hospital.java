package hospitalManagement;

import java.time.LocalDate;
import java.time.LocalTime;

public class Hospital implements Comparable<Hospital> {
	private String patientname;
	private  int pid;
	private String email;
	private String password;
    private int departmentid;
    private String departmentname;
    private LocalDate patdayofvisit;
    private LocalDate docdayofvisit;
    private double hospitalcost;
    private Doctorname dname;
    static private int registrationid;
    private  boolean isAvailable ;
    
    static
    {
    	registrationid=0;
    }
    


public Hospital(String patientname, int pid, String email, String password, int departmentid, String departmentname,
			LocalDate patdayofvisit,LocalDate docdayofvisit, double hospitalcost, Doctorname dname) {
		super();
		this.patientname = patientname;
		this.pid = pid;
		this.email = email;
		this.password = password;
		this.departmentid = departmentid;
		this.departmentname = departmentname;
		this.patdayofvisit = patdayofvisit;
		this.docdayofvisit = docdayofvisit;
		this.hospitalcost = hospitalcost;
		this.dname = dname;
		isAvailable=true;
	}

//overloaded constructor

public Hospital(String email)
{
	super();
	this.email=email;
}


	
	
	@Override
	public boolean equals(Object anoobj)
	{
		System.out.println("in customer equal");
		if (anoobj instanceof Hospital)
		{
			return this.email.equals(((Hospital)anoobj).email);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Hospital [patientname=" + patientname + ", pid=" + pid + ", email=" + email + ", password=" + password
				+ ", departmentid=" + departmentid + ", departmentname=" + departmentname + ", patdayofvisit="
				+ patdayofvisit + ", docdayofvisit=" + docdayofvisit + ", hospitalcost=" + (hospitalcost+dname.getConsultationalcharges()) + ", dname="
				+ dname + ", isAvailable=" + isAvailable + "]";
	}

	 
	//compare
	@Override
	public int compareTo(Hospital o)
	{
		System.out.println("comparable email");
		return this.email.compareTo(o.email);
	}
	
	


	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}


	


	public int getDepartmentid() {
		return departmentid;
	}


	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}




	public double getHospitalcost() {
		return hospitalcost;
	}


	public void setHospitalcost(double hospitalcost) {
		this.hospitalcost = hospitalcost;
	}


	public Doctorname getDname() {
		return dname;
	}


	public void setDname(Doctorname dname) {
		this.dname = dname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPatientname() {
		return patientname;
	}

	public int getPid() {
		return pid;
	}

	public String getEmail() {
		return email;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public LocalDate getPatdayofvisit() {
		return patdayofvisit;
	}

	public LocalDate getDocdayofvisit() {
		return docdayofvisit;
	}

	public static int getRegistrationid() {
		return registrationid;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
    
	
	
	
	
	
}
