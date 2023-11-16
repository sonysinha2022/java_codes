package com.tester;

import java.io.IOException;
import java.util.Locale.Category;

import static utils.ShopUtils.populateProductList;
import static utils.ShopUtils.populateProductMap;
import static utils.IO_utils.*;

import java.util.Map;
import java.util.Scanner;

import com.shop.core.Product;

public class Test1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try(Scanner sc=new Scanner(System.in))
		{
		Map<Integer,Product> productMap =populateProductMap(populateProductList());
		 
		System.out.println("Enter file name");
		String fname=sc.nextLine();
		System.out.println("Enter category name");
		String cat=sc.next();
		//Category cat=Category.valueOf(sc.next().toUpperCase());
		storeProductDetails(productMap,fname,cat);

	
	}
}
}
