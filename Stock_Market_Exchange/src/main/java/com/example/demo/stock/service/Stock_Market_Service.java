package com.example.demo.stock.service;

import java.util.List;

import com.example.demo.stock.dto.Stock_Exchange_Dto;

public interface Stock_Market_Service {
    public List<Stock_Exchange_Dto> getAllStockExchange();
    public Stock_Exchange_Dto addStockExchange(Stock_Exchange_Dto stock_exchange_Dto);
    public List<String> getCompaniesByExchange(String Stock_Exchange);
}
