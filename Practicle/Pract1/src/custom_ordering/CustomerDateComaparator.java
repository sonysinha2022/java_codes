package custom_ordering;

import java.util.Comparator;

import com.code.Customer;



public class CustomerDateComaparator implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		
		// TODO Auto-generated method stub
		int ret=o1.getDob().compareTo(o2.getDob());
		return ret;
	}

}
