package com.example.demo.company.service;

import com.example.demo.company.dto.Company_Dto;
import com.example.demo.company.dto.IPO_Dto;


import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface Company_Service {
    public Iterable<Company_Dto> getAllCompanies();
    public Optional<Company_Dto> addCompany(Company_Dto company_Dto);
    public Optional<Company_Dto> getCompanyByCompanyCode(int Company_Code);
    public List<Company_Dto> getCompanyByRegex(String Regex);
    public double getCompanyStockPrice(int Company_Code, String from, String to) throws ParseException;
    public Optional<IPO_Dto> getIpoDetails(String Company_Name);
}
