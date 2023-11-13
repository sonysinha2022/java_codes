package core;

public enum Plan
{ 
	MONTHLY(3000),QUATERLY(11700),HALFYEARLY(17500),YEARLY(30000);
	 public  double messcharges;

	private Plan(double messcharges) {
		this.messcharges = messcharges;
	}

	public  double getMesscharges() {
		return messcharges;
	}

	public void setMesscharges(double messcharges) {
		this.messcharges = messcharges;
	}

//	public String UpperCase() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public String UpperCase()
	{
		return null;
	}
	 
	 

}
