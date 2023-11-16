package custom_ordering;

import java.util.Comparator;

import com.code.CustomerMangSys;

public class CustomerDateComparator implements Comparator<CustomerMangSys> {

	@Override
	public int compare(CustomerMangSys o1, CustomerMangSys o2) {
		System.out.println("in campare: dob");
		int ret=o1.getDob().compareTo(o2.getDob());
		return ret;
	}

}
