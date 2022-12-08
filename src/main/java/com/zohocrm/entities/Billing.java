package com.zohocrm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "billing")
public class Billing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name", length = 45, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 45, nullable = false)
	private String lastName;
	
	@Column(name = "email", length = 128, nullable = false, unique = true)
	private String Email;
	
	@Column(name = "mobile", length = 10, nullable = false, unique = true)
	private long Mobile;
	
	@Column(name = "product")
	private String Product;
	
	@Column(name = "amount")
	private double Amount;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getMobile() {
		return Mobile;
	}
	public void setMobile(long mobile) {
		this.Mobile = mobile;
	}
	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	
}
