package com.code;
//parent is object
public class Product {
	//data members 
	private int prdId;
	private String pname;
	private double price;
	private double discount;
	
	//parameterised constructor
	
	public Product(int prdId,String pname,double price) {
		this.prdId=prdId;
		this.pname=pname;
		this.price=price;
	}
	
	public Product() {
		
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPrdId() {
		return prdId;
	}
	//to avoid display method override toString() method
	public String toString() {
		System.out.println("This is product class toString()");
		return prdId+ " "+pname+" "+price;
	}

}
