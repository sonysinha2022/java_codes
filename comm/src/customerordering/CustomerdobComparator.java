package customerordering;

import java.util.Comparator;

import comm.Customer;

public class CustomerdobComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		return o1.getDob().compareTo(o2.getDob());
	}
	
	
}
