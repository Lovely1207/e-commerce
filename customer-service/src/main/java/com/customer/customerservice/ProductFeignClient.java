package com.customer.customerservice;

import java.util.List;

//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="product-catalog")
//@RibbonClient("product-catalog")
public interface ProductFeignClient {

	@GetMapping("/product-catalog/products")
	public List<Product> getProductList();

}
