package com.example.demo.sector;

import brave.sampler.Sampler;

import com.example.demo.sector.dao.Company_Dao;
import com.example.demo.sector.dao.Sector_Dao;
import com.example.demo.sector.dao.Stock_Price_Dao;
import com.example.demo.sector.model.Company;
import com.example.demo.sector.model.IPO;
import com.example.demo.sector.model.Sectors;
import com.example.demo.sector.model.Stock_Price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.Arrays;

@SpringBootApplication


@EnableFeignClients("com.example.stock.exchange.sectordataservice")
@EnableDiscoveryClient

public class SectorDataServiceApplication {
	
	private Sector_Dao sector_dao;
	private Company_Dao company_dao;
	private Stock_Price_Dao stock_price_dao;
	
	@Autowired
	public SectorDataServiceApplication(Sector_Dao sector_dao, Company_Dao company_dao,
			Stock_Price_Dao stock_price_dao) {
		super();
		this.sector_dao = sector_dao;
		this.company_dao = company_dao;
		this.stock_price_dao = stock_price_dao;
	}



	

	public static void main(String[] args) {
		SpringApplication.run(SectorDataServiceApplication.class, args);
	}



	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}