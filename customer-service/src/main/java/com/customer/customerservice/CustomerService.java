package com.customer.customerservice;

import java.util.List;


public interface CustomerService {

 List<Product> getProductList();

 Product getProduct(int id);
}
