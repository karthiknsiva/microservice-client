package com.karish.cloud.microserviceclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@EnableHystrix
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClientApplication.class, args);
	}
}

@Configuration
class Config {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate () {
		return new RestTemplate();
	}
}