package com.example.demo.stock;

import brave.sampler.Sampler;

import com.example.demo.stock.dao.IPO_Dao;
import com.example.demo.stock.dao.Stock_Market_Dao;
import com.example.demo.stock.model.IPO;
import com.example.demo.stock.model.Stock_Exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication

@EnableFeignClients("com.example.stock.exchange.stockexchangedataservice")
@EnableDiscoveryClient
public class Stock_Market_Application  {

	@Autowired
	IPO_Dao ipoDetailsRepository;
	@Autowired
	Stock_Market_Dao stockExchangeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Stock_Market_Application.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
