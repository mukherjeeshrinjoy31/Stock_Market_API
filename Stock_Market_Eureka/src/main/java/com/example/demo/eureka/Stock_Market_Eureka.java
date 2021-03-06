package com.example.demo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Stock_Market_Eureka {

	public static void main(String[] args) {
		SpringApplication.run(Stock_Market_Eureka.class, args);
	}

}
