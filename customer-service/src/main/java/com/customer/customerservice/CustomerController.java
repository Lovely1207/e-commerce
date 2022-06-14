package com.customer.customerservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/customer-service")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@Autowired
    private RestTemplate restTemplate;
	 
	@GetMapping("/products")
	@CircuitBreaker(name="default",fallbackMethod = "fallbackMethodResponse")
	public List<Product> getProduct(){
		return service.getProductList();
	}
	
	@GetMapping("/products/{id}")
	public Product getProductList(@PathVariable("id") Integer id){
		return service.getProduct(id);
	}

    @GetMapping("/hello-world")
	public String hellowWorld(){
    	 //String micro2Response = new RestTemplate().getForObject("http://localhost:8081/product-catalog/getStock", String.class);
    	String micro2Response =restTemplate.getForObject("http://PRODUCT-CATALOG/product-catalog/getStock", String.class);
    	return "Customer Service " + " : " + micro2Response;
	}
    
    public List<Product> fallbackMethodResponse(Exception ex) { 
    	List<Product> productList = new ArrayList();
    	productList.add(new Product("product-catalog","Service is down"));
    	return productList ;
    }
    

}
