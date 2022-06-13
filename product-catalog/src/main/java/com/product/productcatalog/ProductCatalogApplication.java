package com.product.productcatalog;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductCatalogApplication {

	@Autowired
	ProductRespository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogApplication.class, args);
	}
	
	@PostConstruct
	void addProduct() {
		List<Product> productList = new ArrayList();
		productList.add(new Product(1, "TOP", "all type"));
		productList.add(new Product(2, "SHIRT", "all type"));
		productList.add(new Product(3, "SUIT", "all type"));
		productList.add(new Product(4, "SKIRT", "all type"));
		productList.add(new Product(5, "JEANS", "all type"));
		repository.saveAll(productList);
	}

}
