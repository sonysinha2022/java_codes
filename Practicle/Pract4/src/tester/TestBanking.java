package tester;

import java.time.LocalDate;
import static utils.BankingValidationRules.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;
import java.util.stream.Stream;

import javax.security.auth.login.AccountNotFoundException;

import com.banking.AcType;
import com.banking.BankAccount;

import custom_exceptions.InvalidInputException;

import static utils.BankingUtils.populateAccountMap;

public class TestBanking {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// init
			// get the popualated map : from utils
			Map<Integer, BankAccount> accountMap = populateAccountMap();
			boolean exit = false;
			while (!exit) {
				System.out.println("Options 1. Create A/C 2. Display all accts 3. Show a/c summary \n"
						+ "4. Transfer Funds 5. Close A/c 6. Disable unused accts \n"
						+ "7. Sort accts as per acct no \n" + "8. Sort accts as per  balance" + "9.desc order by acc no"+
						"10.acc sorted as per creationDate and name"+ "11.remove account"+"0. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter acct no customerName,  acctType,  balance,  creationDate");
						BankAccount acct = validateAllInputs(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(),
								sc.next(), accountMap);
						accountMap.put(acct.getAcctNo(), acct);
						System.out.println("new a/c created !");
						break;
					case 2:
						System.out.println("All accounts :");
						for (BankAccount a : accountMap.values())
							System.out.println(a);
						break;
					case 3:
						System.out.println("Enter acct no");
						acct = accountMap.get(sc.nextInt());// O(1)
						if (acct == null)
							throw new InvalidInputException("Invalid a/c no !!!!");
						System.out.println("A/C summary " + acct);
						break;
					case 4:
						System.out.println("Enter src a/c no , dest a/c no n amount");
						BankAccount src = accountMap.get(sc.nextInt());
						if (src == null)
							throw new InvalidInputException("Invalid src a/c no !!!!");
						BankAccount dest = accountMap.get(sc.nextInt());
						if (dest == null)
							throw new InvalidInputException("Invalid dest a/c no !!!!");
						// valid src n dest a/cs
						src.transferFunds(dest, sc.nextDouble());
						System.out.println("funds transferred....");
						break;
					case 5:
						System.out.println("Enter a/c no , to close an a/c");
						acct = accountMap.remove(sc.nextInt());// auto boxing n up casting
						if (acct == null)
							throw new InvalidInputException("Invalid a/c no , A/C can't be closed!!!!");
						System.out.println("Closed the account for customer : " + acct.getCustomerName());

						break;
					case 6: // disable accts
						disableAccounts(accountMap);
						break;
					case 7:// sorting --key based

						Stream<BankAccount> acc=accountMap.values().stream()
						.sorted((c1,c2)->((Integer)c1.getAcctNo()).compareTo(c2.getAcctNo()));
						acc.forEach(System.out::println);
						
						break;
					case 8:
						// balance based sorting --sorting criteria : value based
	
						Stream<BankAccount> acc1=accountMap.values().stream()
						.sorted((c1,c2)->((Double)c1.getBalance()).compareTo(c2.getBalance()));
						acc1.forEach(System.out::println);
						break;
					case 9:
						//desc order by acc no

						Stream<BankAccount> acc2=accountMap.values().stream()
						.sorted((c1,c2)->((Integer)c2.getAcctNo()).compareTo(c1.getAcctNo()));
						acc2.forEach(System.out::println);
						
					
						break;
					case 10:
						//display the acc sorted as per creationDate n customer name
						Stream<BankAccount> acc3=accountMap.values().stream()
						.sorted((c1,c2)->c1.getCreationDate().compareTo(c2.getCreationDate()))
						.sorted((c3,c4)->c3.getCustomerName().compareTo(c4.getCustomerName()));
						acc3.forEach(System.out::println);
						
						break;
					case 11:
						removeAccount(accountMap);
						break;
					
					case 0:
						exit = true;

						break;

					}
				} catch (Exception e) {
					sc.nextLine();
					System.out.println(e);
				}
			}
		}

	}

}
