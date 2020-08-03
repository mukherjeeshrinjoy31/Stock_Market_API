package com.example.demo.company;

import brave.sampler.Sampler;

import com.example.demo.company.dao.Company_Dao;
import com.example.demo.company.dao.IPO_Dao;
import com.example.demo.company.dao.Stock_Market_Dao;
import com.example.demo.company.model.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication
@EnableFeignClients("com.example.stock.exchange.companydataservice")
@EnableDiscoveryClient
public class CompanyDataServiceApplication {

	@Autowired
	Company_Dao companyRepository;
	@Autowired
	Stock_Market_Dao stockPriceRepository;
	@Autowired
	IPO_Dao ipoDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(CompanyDataServiceApplication.class, args);
	}



	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
