package com.customer.customerservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	ProductFeignClient client;

	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return client.getProductList();
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
