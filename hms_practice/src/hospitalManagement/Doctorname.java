package hospitalManagement;



public enum Doctorname {
	RAM(400),ROHAN(500),SARA(350),JOHN(450);
	
	private double consultationalcharges;

	private Doctorname(double consultationalcharges) {
		this.consultationalcharges = consultationalcharges;
	}

	public double getConsultationalcharges() {
		return consultationalcharges;
	}

	public void setConsultationalcharges(double consultationalcharges) {
		this.consultationalcharges = consultationalcharges;
	}
	
	

}
