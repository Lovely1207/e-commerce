package com.customer.customerservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.DiscoveryClient;

@RestController
@RequestMapping("/customer-service")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@Autowired
    private RestTemplate restTemplate;
	 
	@GetMapping("/products")
	public List<Product> getProduct(){
		return service.getProductList();
	}

    @GetMapping("/hello-world")
	public String hellowWorld(){
    	 //String micro2Response = new RestTemplate().getForObject("http://localhost:8081/product-catalog/getStock", String.class);
    	String micro2Response =restTemplate.getForObject("http://PRODUCT-CATALOG/product-catalog/getStock", String.class);
    	return "Customer Service " + " : " + micro2Response;
	}

}
