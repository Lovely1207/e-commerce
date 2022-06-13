package com.product.productcatalog;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductRespository repository;
	
	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	@Override
	public void saveProduct(Product p) {
		 repository.save(p);
	}
	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Optional<Product> product =  repository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}else {
			throw new ProductNotFoundException("Product is not found :"+id);
		}
	}

}
