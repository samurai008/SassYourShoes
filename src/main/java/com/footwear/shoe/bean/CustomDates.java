package com.footwear.shoe.bean;

public class CustomDates {
	private String d1;
	private String d2;
	
	CustomDates() {
		super();
	}
	
	CustomDates(String d1, String d2) {
		this.d1 = d1;
		this.d2 = d2;
	}
	
	public String getD1() {
		return d1 + " 00:00:00";
	}
	
	public String getD2() {
		return d2 + " 00:00:00";
	}
}
