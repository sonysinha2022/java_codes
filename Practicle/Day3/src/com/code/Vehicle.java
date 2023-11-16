package com.code;

import java.util.Date;
import com.code.Color;
import java.text.SimpleDateFormat;

public class Vehicle {

	private String chasis;
	private Color clr;
	private double baseprice;
	private boolean isAvailable;
	private Date mfdDate;
	private String Company;
	public static SimpleDateFormat sfd;

	static {
		sfd = new SimpleDateFormat("yyy-MM-dd");
	}

	public Vehicle(String chasis, Color clr, double baseprice, Date mfdDate, String Company) {

		this.isAvailable = true;
		this.chasis = chasis;
		this.clr = clr;
		this.baseprice = baseprice;
		this.mfdDate = mfdDate;
		this.Company = Company;
	}

	public String getChasis() {
		return chasis;
	}

	public Color getClr() {
		return clr;
	}

	public double getBaseprice() {
		return baseprice;
	}

	public Date getMfdDate() {
		return mfdDate;
	}

	public String getCompany() {
		return Company;
	}

	public boolean equals(Object o) {
		System.out.println("In vehicle's eq !");
		if (o instanceof Vehicle) {
			Vehicle v = (Vehicle) o;
			return this.chasis.equals(v.chasis);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Vehicle [chasis=" + chasis + ", clr=" + clr + ", baseprice=" + baseprice + ", mfdDate="
				+ sfd.format(mfdDate) + ", Company=" + Company + "]";
	}

}

