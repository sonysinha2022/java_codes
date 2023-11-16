package com.banking;

import java.time.LocalDate;

import custom_exceptions.InsufficientFundsException;
import custom_exceptions.transactiondenied;

import static utils.BankingValidationRules.validateBalance;

/*
 * acctNo, customer name , type , balance , creation date ,
 *  last tx date , isActive
 */
public class BankAccount {
	private int acctNo;
	private String customerName;
	private AcType acctType;
	private double balance;
	private LocalDate creationDate;
	private LocalDate lastTxDate;
	private boolean isActive;

	public BankAccount(int acctNo, String customerName, AcType acctType, double balance, LocalDate creationDate ) {
		super();
		this.acctNo = acctNo;
		this.customerName = customerName;
		this.acctType = acctType;
		this.balance = balance;
		this.creationDate = creationDate;// in real app : LocalDate.now()
		this.isActive = true;
		this.lastTxDate = LocalDate.parse(this.creationDate.toString());// in real app : LocalDate.now()
	}

	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", customerName=" + customerName + ", acctType=" + acctType
				+ ", balance=" + balance + ", creationDate=" + creationDate + ", lastTxDate=" + lastTxDate
				+ ", isActive=" + isActive + "]";
	}

	// B.L methods
	public void deposit(double amount) throws transactiondenied {
		if(!this.isActive)
			throw new transactiondenied("transaction denied");
		this.lastTxDate=LocalDate.now();
		balance += amount;
	}

	public void withdraw(double amount) throws InsufficientFundsException {
		validateBalance(this.acctType, balance - amount);
		balance -= amount;
	}

	public void transferFunds(BankAccount dest, double transferAmount) throws InsufficientFundsException, transactiondenied {
		if(!this.isActive)
			throw new transactiondenied("transaction denied");
		this.withdraw(transferAmount);
		dest.deposit(transferAmount);
	}
	//apply simple interest
	public void applySimpleInterest(double rate,int periodInYrs) throws transactiondenied
	{
		this.deposit((balance*periodInYrs*rate)/100);
	}
	//getters

	public int getAcctNo() {
		return acctNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public AcType getAcctType() {
		return acctType;
	}

	public double getBalance() {
		return balance;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public LocalDate getLastTxDate() {
		return lastTxDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
