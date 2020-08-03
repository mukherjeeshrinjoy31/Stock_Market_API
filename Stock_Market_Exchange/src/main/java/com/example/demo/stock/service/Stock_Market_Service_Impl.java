package com.example.demo.stock.service;

import com.example.demo.stock.dao.IPO_Dao;
import com.example.demo.stock.dao.Stock_Market_Dao;
import com.example.demo.stock.dto.Company_Dto;
import com.example.demo.stock.dto.Stock_Exchange_Dto;
import com.example.demo.stock.model.IPO;
import com.example.demo.stock.model.Stock_Exchange;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableTransactionManagement
public class Stock_Market_Service_Impl implements Stock_Market_Service {
    
    private Stock_Market_Dao stock_market_dao;
    private IPO_Dao ipo_dao;
    
    @Autowired
    public Stock_Market_Service_Impl(Stock_Market_Dao stock_market_dao, IPO_Dao ipo_dao) {
		super();
		this.stock_market_dao = stock_market_dao;
		this.ipo_dao = ipo_dao;
	}

	

    @Override
    @Transactional
    public List<Stock_Exchange_Dto> getAllStockExchange() {

       List<Stock_Exchange> stockExchanges = stock_market_dao.findAll();
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<Iterable<Stock_Exchange_Dto>>(){}.getType();
        List<Stock_Exchange_Dto> postDtoList = mapper.map(stockExchanges,listType);
        return postDtoList;
    }

    @Override
    @Transactional
    public Stock_Exchange_Dto addStockExchange(Stock_Exchange_Dto stock_exchange_Dto) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Stock_Exchange stockExchange = new Stock_Exchange();
        mapper.map(stock_exchange_Dto,stockExchange);
        return stock_exchange_Dto;
    }

    @Override
    public List<String> getCompaniesByExchange(String Stock_Exchange) {
        List<IPO> list = ipo_dao.getAllByStockExchange(Stock_Exchange);
        List<String> arrayList = new ArrayList<>(){};
        for (IPO ipo:list) {
            arrayList.add(ipo.getCompany_Name());
        }
        return arrayList;
    }
}
