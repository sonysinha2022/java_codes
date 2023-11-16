package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

import com.banking.AcType;
import com.banking.BankAccount;


import custom_exceptions.InsufficientFundsException;
import custom_exceptions.InvalidInputException;

public class BankingValidationRules {
	// add a method to validate min balance
	public static void validateBalance(AcType type, double balance) throws InsufficientFundsException {
		if (balance <= type.getMinBalance())
			throw new InsufficientFundsException("Balance too low!!!!");
	}

	// validate a/c type
	public static AcType parseAndValidateType(String type) {
		return AcType.valueOf(type.toUpperCase());
	}

	// In case of no txs (withdraw , deposit, funds transfer) ,
	// in 1 year , disable a/c status
	public static void disableAccounts(Map<Integer, BankAccount> acctMap) {
		// since it's searching based upon : value based criteria (last transacation date),
		// Map ---> Collection<V> : values()
		for (BankAccount a : acctMap.values()) {
			long periodInMonths = Period.between(a.getLastTxDate(), LocalDate.now()).toTotalMonths();
			if (periodInMonths > 12)
				a.setActive(false);
		}
		System.out.println("a/c status updated by admin!");

	}
	// remove account which are inactive from last 24 month
	public static void removeAccount(Map<Integer, BankAccount> acctMap) 
	{
		//ArrayList<BankAccount> b1=new ArrayList<>(acctMap.values());
		
		Iterator<BankAccount> bankitr=acctMap.values().iterator();
	
		while(bankitr.hasNext())
		{
				long periodInMonths = Period.between(bankitr.next().getLastTxDate(), LocalDate.now()).toTotalMonths();
				if (periodInMonths > 24)
					//System.out.println("period in month is:"+periodInMonths);
				{
					bankitr.remove();	
					System.out.println("a/c is removed!");
				}
				
		}		
		
	}

	public static BankAccount validateAllInputs(int acctNo, String customerName, String acctType, double balance,
			String creationDate, Map<Integer, BankAccount> map)
			throws InvalidInputException, InsufficientFundsException {
		if (map.containsKey(acctNo))
			throw new InvalidInputException("Dup acct no!!!!");
		AcType type = parseAndValidateType(acctType);
		validateBalance(type, balance);
		LocalDate date = LocalDate.parse(creationDate);
		return new BankAccount(acctNo, customerName, type, balance, date);

	}

}
