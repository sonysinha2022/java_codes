package com.banking;

public enum AcType {
	SAVING(10000), CURRENT(5000), FD(50000);
	private double minBalance;

	private AcType(double minBalance) {
		//super(name(),ordinal());
		this.minBalance = minBalance;
	}
	public double getMinBalance() {
		return minBalance;
	}
	
}
