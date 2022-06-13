package com.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		System.out.println("Request comes to api-gateway");
		return builder.routes()
				.route(p -> p.path("/get").filters(f -> f
						.addRequestHeader("MyHeader", "MyURI")
						.addRequestParameter("Param", "MyValue"))
				.uri("http://httpbin.org:80"))
				.route(p -> p.path("/product-catalog/**")
						.filters(f->f.addRequestHeader("service1-header", "product-catalog-header")
								.addRequestParameter("service1-param", "product-catalog-param"))
						.uri("lb://product-catalog"))
				.route(p -> p.path("/customer-service/**")
						.uri("lb://customer-service"))
				.build();
	}
}
