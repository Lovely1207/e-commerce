package com.customer.customerservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product implements Serializable{

	@Id
	private int id;
	private String name;
	private String description;

	public Product() {}
	
	public Product(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Product(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
