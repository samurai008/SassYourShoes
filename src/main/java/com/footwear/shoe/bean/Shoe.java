package com.footwear.shoe.bean;

import java.util.Date;

public class Shoe {
	
	private int id;
	private String name;
	private double price;
	private String variant;
	private Date createdon;
	
	public Shoe() {
		super();
	}
	
	public Shoe(String name, double price, String variant, Date createdon) {
		this.name = name;
		this.price = price;
		this.variant = variant;
		this.createdon = createdon;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getVariant() {
		return this.variant;
	}
	
	public void setVariant(String variant) {
		this.variant = variant;
	}
	
	public Date getCreatedon() {
		return this.createdon;
	}
	
	public void setCreatedon(Date d) {
		this.createdon = d;
	}
	
}
