package com.product.productcatalog;

import java.util.List;

import org.springframework.stereotype.Service;



public interface ProductService {
  
	List<Product> getProductList();
	
	Product getProduct(int id);
	
	void saveProduct(Product p);
}
