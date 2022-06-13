package com.product.productcatalog;

import java.util.Date;

public class ProductResponse {

	private String message;
	private Date date;
	
	
	
	public ProductResponse(String message, Date date) {
		super();
		this.message = message;
		this.date = date;
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
