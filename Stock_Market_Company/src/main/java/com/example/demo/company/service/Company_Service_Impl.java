package com.example.demo.company.service;

import com.example.demo.company.dao.Company_Dao;
import com.example.demo.company.dao.IPO_Dao;
import com.example.demo.company.dao.Stock_Market_Dao;
import com.example.demo.company.dto.Company_Dto;
import com.example.demo.company.dto.IPO_Dto;
import com.example.demo.company.model.Company;
import com.example.demo.company.model.IPO;
import com.example.demo.company.model.Stock_Price;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@EnableTransactionManagement
public class Company_Service_Impl implements Company_Service {

    
    Company_Dao company_dao;
    Stock_Market_Dao stock_market_dao;
    IPO_Dao ipo_dao;
    
    @Autowired
    public Company_Service_Impl(Company_Dao company_dao, Stock_Market_Dao stock_market_dao, IPO_Dao ipo_dao) {
		super();
		this.company_dao = company_dao;
		this.stock_market_dao = stock_market_dao;
		this.ipo_dao = ipo_dao;
	}


	

    @Override
    @Transactional
    public Iterable<Company_Dto> getAllCompanies()
    {
        List<Company> companyList = company_dao.findAll();
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<Iterable<Company_Dto>>(){}.getType();
        Iterable<Company_Dto> postDtoList = mapper.map(companyList,listType);
        return postDtoList;
    }

    @Override
    @Transactional
    public Optional<Company_Dto> addCompany(Company_Dto company_Dto){
        Company company = new Company();
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.map(company_Dto,company);
        company_dao.save(company);
        return Optional.of(company_Dto);
    }

    @Override
    @Transactional
    public Optional<Company_Dto> getCompanyByCompanyCode(int Company_Code)
    {
        Company company = company_dao.findByCompanyCode(Company_Code);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Company_Dto company_Dto = new Company_Dto();
        mapper.map(company,company_Dto);
        return Optional.of(company_Dto);
    }

    @Override
    @Transactional
    public List<Company_Dto> getCompanyByRegex(String Regex)
    {
        List<Company> companyList  = company_dao.findByCompanyNameContaining(Regex);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<Iterable<Company_Dto>>(){}.getType();
        List<Company_Dto> postDtoList = mapper.map(companyList,listType);
        return postDtoList;
    }

    @Override
    @Transactional
    public double getCompanyStockPrice(int Company_Code, String from, String to) throws ParseException {
        List<Stock_Price> list = stock_market_dao.findAllByCompanyCodeAndDateBetween(Company_Code, Date.valueOf(from),Date.valueOf(to));
        //Assuming average stock price between days
        double x = 0.0;
        for(int i=0;i<list.size();i++)
        {
            x = x + list.get(i).getStock_Price();
        }
        x = x / list.size();
        return x;
    }


    @Override
    @Transactional
    public Optional<IPO_Dto> getIpoDetails(String Company_Name)
    {
        IPO ipo = ipo_dao.findByCompanyName(Company_Name);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        IPO_Dto ipo_dto = new IPO_Dto();
        mapper.map(ipo,ipo_dto);
        return Optional.of(ipo_dto);
    }
}
