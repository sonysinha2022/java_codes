package utils;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.banking.AcType;
import com.banking.BankAccount;

public class BankingUtils {
//add a method to populate sample accts data
	public static Map<Integer, BankAccount> populateAccountMap() {
		// create empty Map
		/*
		 * int acctNo, String customerName, AcType acctType, double balance, LocalDate
		 * creationDate
		 */
		Map<Integer, BankAccount> accts = new HashMap<>();
		System.out.println("Added "
				+ accts.put(101, new BankAccount(101, "Monika", AcType.SAVING, 15000, LocalDate.parse("2022-01-01"))));
		System.out.println("Added "
				+ accts.put(10, new BankAccount(10, "Shubham", AcType.SAVING, 23000, LocalDate.parse("2023-01-01"))));

		System.out.println("Added "
				+ accts.put(15, new BankAccount(15, "Kiran", AcType.FD, 150000, LocalDate.parse("2023-01-01"))));

		System.out.println("Added "
				+ accts.put(34, new BankAccount(34, "Mihir", AcType.SAVING, 13000, LocalDate.parse("2023-09-21"))));

		System.out.println("Added "
				+ accts.put(25, new BankAccount(25, "Rama", AcType.CURRENT, 6000, LocalDate.parse("2022-11-07"))));

		System.out.println("Added "
				+ accts.put(11, new BankAccount(11, "Rama", AcType.FD, 200000, LocalDate.parse("2023-06-01"))));

		System.out.println("Added " + accts.putIfAbsent(35,
				new BankAccount(35, "Mihir2", AcType.SAVING, 14000, LocalDate.parse("2023-09-21"))));
		
		return accts;
	}
}
