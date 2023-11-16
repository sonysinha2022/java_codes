package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import com.shop.core.Category;
import com.shop.core.Product;

public interface IO_utils {
	
	static void storeProductDetails(Map<Integer,Product> productMap,String fname,String c) throws IOException
	{
		// Suppose you have product details in a map. 
		//Store these product details from a specified category , sorted as per manu. date , in a text file using buffer.

		
			//System.out.println("Enter category name");
		Category cat=Category.valueOf(c.toUpperCase());
		//PW--FW--file
		try(PrintWriter pw=new PrintWriter(new FileWriter(fname))){
		productMap.values()
		.stream()
		.filter(p->p.getProductCategory()==cat)
		.sorted((p1,p2)->p1.getManufactureDate().compareTo(p2.getManufactureDate()))
		.forEach(pw::println); //.forEach(p->pw.println(p));
		
		}
	}

}
