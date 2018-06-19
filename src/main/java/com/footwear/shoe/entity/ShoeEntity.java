package com.footwear.shoe.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="shoes")
public class ShoeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="variant")
	private String variant;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdon;
	
	public ShoeEntity() {
		super();
	}
	
	public ShoeEntity(String name, double price, String variant, Date createdon) {
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
