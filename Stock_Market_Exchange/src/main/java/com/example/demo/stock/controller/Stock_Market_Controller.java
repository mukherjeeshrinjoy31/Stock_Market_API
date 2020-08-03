package com.example.demo.stock.controller;

import com.example.demo.stock.dto.Stock_Exchange_Dto;
import com.example.demo.stock.model.Stock_Exchange;
import com.example.demo.stock.service.Stock_Market_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Stock_Market_Controller {

    
	private Stock_Market_Service stock_market_service;
	
	@Autowired
    public Stock_Market_Controller(Stock_Market_Service stock_market_service) {
		super();
		this.stock_market_service = stock_market_service;
	}



    @RequestMapping(value = "/exchange/all",method = RequestMethod.GET)
    public ResponseEntity<Iterable<Stock_Exchange_Dto>> getStockExchangeList(){
        return ResponseEntity.status(HttpStatus.FOUND).body(stock_market_service.getAllStockExchange());
    }

    @RequestMapping(value = "/exchange/add",method = RequestMethod.POST)
    public ResponseEntity<Stock_Exchange_Dto> addStockExchangeList(@RequestBody Stock_Exchange_Dto stockExchangeDTO){
        return ResponseEntity.status(HttpStatus.OK).body(stock_market_service.addStockExchange(stockExchangeDTO));
    }

    @RequestMapping(value = "/exchange/{Stock_Exchange}/companies",method = RequestMethod.GET)
    public ResponseEntity<Iterable<String>> getCompaniesByExchange(@PathVariable String Stock_Exchange){
        return ResponseEntity.status(HttpStatus.FOUND).body(stock_market_service.getCompaniesByExchange(Stock_Exchange));
    }

}
