package com.tester;
import com.code.Product;
import java.util.Scanner;
public class TestProduct {

	public static void main(String[] args) {
		
//     Product ptr=new Product(101,"Box",100);
//     System.out.println(ptr);
		
		//shop colllection
		
		Product[] shop = new Product[5];
		System.out.println("1:Show Products 2:Add Products 3:Edit price 4:Remove price");
		Scanner sc = new Scanner(System.in);
		int ch,index=0;
		do {
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			switch(ch) {
			case 1:
				//for each product prd in shop---used to display only
				for(Product ptr:shop)
				{
					System.out.println(ptr);
				}
				break;
			case 2:
				//check whether shop is empty or null
				if(index<shop.length)
				{
					System.out.println("Enter details: ProductID,product_name,price");
					Product prdObj=new Product(sc.nextInt(),sc.next(),sc.nextDouble());
				
				shop[index]= prdObj;
				index++;
				}
				else {
					System.out.println("List is full");
				}
				break;
			case 3:
				System.out.println("Enter product ID");
				int prdId=sc.nextInt();
				for(Product prd : shop)
				{
					if(prd!=null)
					{
						if(prd.getPrdId()==prdId)
						{
							System.out.println("Enter new value");
							prd.setPrice(sc.nextDouble());
							break;
						}
						else {
							System.out.println("Product does not exist");
						}
					}
				}
				break;
			case 4:
				System.out.println("Enter product ID");
				prdId=sc.nextInt();
				for(int i=0;i<shop.length;i++) {
					if(shop[i]!= null) {
						if(shop[i].getPrdId() == prdId) {
							shop[i]=null;
							System.out.println("Product is removed");	
							break;
						}
						else {
							System.out.println("Product not found");
						}
					}
				}
				break;
			}
		}
		while(ch !=5);
	}
}
		
	


