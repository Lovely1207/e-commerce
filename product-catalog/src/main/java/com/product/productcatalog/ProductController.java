package com.product.productcatalog;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;


@RestController
@ControllerAdvice
@RequestMapping("/product-catalog")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	
	@Autowired
	Configuration config;
	
	@Autowired
	private Environment environment;
	
	private Logger logger =LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("/getStock")
	public String getMaxMinStock(){
		String port = environment.getProperty("local.server.port");
		return "Max="+config.getMaxStock()+" Min="+config.getMinStock()+"product-catalog-port="+port;
	}
	
	@GetMapping("/products")
	public List<Product> getProductList(){
		//@RequestHeader("service1-header") Map<String,String> header
		//logger.info("header:"+header);
		//logger.info("param:"+param);
		//header:{cache-control=max-age=0, sec-ch-ua=" Not A;Brand";v="99", "Chromium";v="102", "Google Chrome";v="102", sec-ch-ua-mobile=?0, sec-ch-ua-platform="Windows", dnt=1, upgrade-insecure-requests=1, user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36, accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9, sec-fetch-site=none, sec-fetch-mode=navigate, sec-fetch-user=?1, sec-fetch-dest=document, accept-encoding=gzip, deflate, br, accept-language=en-IN,en-GB;q=0.9,en-US;q=0.8,en;q=0.7,hi;q=0.6, service1-header=product-catalog-header, forwarded=proto=http;host="localhost:8765";for="[0:0:0:0:0:0:0:1]:55941", x-forwarded-for=0:0:0:0:0:0:0:1, x-forwarded-proto=http, x-forwarded-port=8765, x-forwarded-host=localhost:8765, host=host.docker.internal:8081, content-length=0} param:product-catalog-param

		return service.getProductList();
	}
	
	@GetMapping("/products/{id}")
	public Product getProductList(@PathVariable("id") Integer id){
		return service.getProduct(id);
	}
	
	@PostMapping("/products")
	public List<Product> getProductList(@RequestBody Product product){
		return service.getProductList();
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException p , WebRequest web){
		
		ProductResponse productResp = new ProductResponse(p.getMessage(),new Date()); 
		
		return new ResponseEntity<Object>(productResp, HttpStatus.NOT_FOUND); 
		
	}

	
}
