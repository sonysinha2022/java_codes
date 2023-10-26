package com.code;

public class Showroom
{	//Data Members
	private int id;
	private String name;
	private String colour;
	private double price;
	//static 
	private static double discount;
	
	//Constructor
	public Showroom(int id,String name,String colour,double price)
	{
		this.id=id;
		this.name=name;
		this.colour=colour;
		this.price=price;
	}
	
	//getters
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getColour()
	{
		return colour;
	}
	public double getPrice()
	{
		return price;
	}

	//setters
	public void setName(String name)
	{
		this.name=name;
	}
	public void setColour(String colour)
	{
		this.colour=colour;
	}
	public void setPrice(double price)
	{
		this.price=price;
	}
	
	//toString
	public String toString()
	{
		return "Id:"+id+" Name:"+name+" Colour:"+colour+" Price:"+price+" Discount:"+discount;
	}

	//static
	static
	{
		discount=5000;
	}
}