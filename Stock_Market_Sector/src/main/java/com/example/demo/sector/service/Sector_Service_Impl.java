package com.example.demo.sector.service;

import com.example.demo.sector.dao.Company_Dao;
import com.example.demo.sector.dao.Sector_Dao;
import com.example.demo.sector.dao.Stock_Price_Dao;
import com.example.demo.sector.dto.Company_Dto;
import com.example.demo.sector.model.Company;
import com.example.demo.sector.model.Sectors;
import com.example.demo.sector.model.Stock_Price;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class Sector_Service_Impl implements Sector_Service {
	
	
	Sector_Dao sector_dao;
    Company_Dao company_dao;
    Stock_Price_Dao stock_dao;
    
    @Autowired
    public Sector_Service_Impl(Sector_Dao sector_dao, Company_Dao company_dao, Stock_Price_Dao stock_dao) {
		super();
		this.sector_dao = sector_dao;
		this.company_dao = company_dao;
		this.stock_dao = stock_dao;
	}

	

    @Override
    @Transactional
    public List<Company_Dto> getListOfCompaniesInSector(String Sector){
        List<Company> companyList = company_dao.getAllBySector(Sector);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<Iterable<Company_Dto>>(){}.getType();
        List<Company_Dto> postDtoList = mapper.map(companyList,listType);
        return postDtoList;
    }

    @Override
    @Transactional
    public double getSectorPrice(String Sector_Id, String from, String to){
        List<Sectors> list = sector_dao.getAllBySectorId(Sector_Id);
        String sectorName= list.get(0).getSector();
        List<Company> companyList = company_dao.getAllBySector(sectorName);
        List<Integer> companyCodeList =new ArrayList<>(){};
        for (Company company:companyList) {
            companyCodeList.add(company.getCompany_Code());
        }
        List<Stock_Price> stockPrices = stock_dao.getAll(companyCodeList, Date.valueOf(from), Date.valueOf(to));
        //Remove by feign client
        double x = 0.0;
        for(int i=0;i<stockPrices.size();i++)
        {
            x = x + stockPrices.get(i).getStock_Price();
        }
        x = x / stockPrices.size();
        return x;
    }
}
