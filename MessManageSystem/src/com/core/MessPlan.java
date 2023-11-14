package com.core;

public enum MessPlan 
{
MONTHLY(3000),QUARTERLY(11700), HALFYEARLY (17500),YEARLY(32000);
	
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
