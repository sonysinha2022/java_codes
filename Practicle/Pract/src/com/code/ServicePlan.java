package com.code;

public enum ServicePlan {
	
SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	
	private int sPlan;	
	
	private ServicePlan(int Plan)
	{
		this.sPlan=sPlan;
	}

	public int getsPlan() {
		return sPlan;
	}

	public void setsPlan(int sPlan) {
		this.sPlan = sPlan;
	}
	

}
