package com.example.demo.company.controller;

import com.example.demo.company.dto.Company_Dto;
import com.example.demo.company.dto.IPO_Dto;
import com.example.demo.company.model.Company;
import com.example.demo.company.service.Company_Service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class CompanyDetailsController {

	private Company_Service company_service;
	
	@Autowired
    public CompanyDetailsController(Company_Service company_service) {
		super();
		this.company_service = company_service;
	}

	

    @RequestMapping(value = "/company/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Company_Dto>> getAllCompanyDetails()
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(company_service.getAllCompanies());
    }

    @RequestMapping(value = "/company/add", method = RequestMethod.POST)
    public ResponseEntity<Optional<Company_Dto>> addCompany(@RequestBody Company_Dto companyDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(company_service.addCompany(companyDTO));
    }

    @RequestMapping(value = "/company/companyCode/{Company_Code}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Company_Dto>> getCompanyByCompanyCode(@PathVariable int Company_Code){
        return ResponseEntity.status(HttpStatus.FOUND).body(company_service.getCompanyByCompanyCode(Company_Code));
    }

    @RequestMapping(value = "/company/regex/{Regex}", method = RequestMethod.GET)
    public ResponseEntity<List<Company_Dto>> getCompanyByRegex(@PathVariable String Regex){
        return ResponseEntity.status(HttpStatus.FOUND).body(company_service.getCompanyByRegex(Regex));
    }

    @RequestMapping(value = "/company/stock/{Company_Code}/{from}/{to}")
    public ResponseEntity<Double> getCompanyStockPrice(@PathVariable int Company_Code,@PathVariable String from,@PathVariable String to) throws ParseException {
        return ResponseEntity.status(HttpStatus.FOUND).body(company_service.getCompanyStockPrice(Company_Code,from,to));
    }

    @RequestMapping(value = "/company/ipo/{Company_Name}")
    public ResponseEntity<Optional<IPO_Dto>> getIpoDetails(@PathVariable String Company_Name)
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(company_service.getIpoDetails(Company_Name));
    }

}
