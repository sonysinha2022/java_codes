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
						+ "7. Sort accts as per acct no \n" + "8. Sort accts as per  balance 0. Exit");
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
					case 7:// sorting --key based --Can you use a TreeMap : YES
							// Natural order : TreeMap(Map<K,V> map)
						TreeMap<Integer, BankAccount> tm = new TreeMap<>(accountMap);
						// JVM invokes : TimSort -- that invokes Integer's compareTo -- asc order.
						// display
						System.out.println("Accts sorted as per acct no");
						for (BankAccount a : tm.values())
							System.out.println(a);
						break;
					case 8:
						// balance based sorting --sorting criteria : value based
						// TreeMap can't be used !!!
						// Map --> Collection<V> : values()
						// ArrayList/LinkedList/Vector : AL(Collection<E> coll)
						// Collections.sort(list,comp);
						Vector<BankAccount> acctVector = new Vector<>(accountMap.values());
						Collections.sort(acctVector, new Comparator<BankAccount>() {
							@Override
							public int compare(BankAccount a1,BankAccount a2)
							{
								System.out.println("in compare : bal");
								return ((Double)a1.getBalance()).compareTo(a2.getBalance());
							}
						});
						System.out.println("Bank a/cs sorted as per balance");
						for(BankAccount a : acctVector)
							System.out.println(a);
						break;
					case 9 : //display the accts sorted as per creation date n customer name
						ArrayList<BankAccount> list=new ArrayList<>(accountMap.values());
						Collections.sort(list,new Comparator<BankAccount>() {
							@Override
							public int compare(BankAccount a1,BankAccount a2)
							{
								 int ret=a1.getCreationDate().compareTo(a2.getCreationDate());
								 if(ret==0)
									 return a1.getCustomerName().compareTo(a2.getCustomerName());
								 return ret;
							}
						});
						System.out.println("Acct as per creation date n balance");
						for(BankAccount a : list)
							System.out.println(a);
						break;
					case 10: //remove all accounts for which no txs in last 2 years
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
