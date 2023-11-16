package com.code;

public enum MessPlan {
	 Monthly(3000),Quarterly(11700), Half_Year (17500),Yearly(32000);
	
	private int mPlan;

	private MessPlan(int mPlan) {
		this.mPlan = mPlan;
	}

	public int getmPlan() {
		return mPlan;
	}

	public void setmPlan(int mPlan) {
		this.mPlan = mPlan;
	}




	
	
	
	

}
