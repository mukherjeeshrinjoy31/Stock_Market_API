package com.example.demo.company;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.company.dto.Company_Dto;
import com.example.demo.company.dto.IPO_Dto;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@FeignClient(name="netflix-zuul-api-gateway-server")
public interface ProxyCompanyDataService {

    @RequestMapping(value = "/company/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Company_Dto>> getAllCompanyDetails();

    @RequestMapping(value = "/company/add", method = RequestMethod.POST)
    public ResponseEntity<Optional<Company_Dto>> addCompany(@RequestBody Company_Dto companyDTO);

    @RequestMapping(value = "/company/companyCode/{companyCode}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Company_Dto>> getCompanyByCompanyCode(@PathVariable(value = "companyCode") int companyCode);

    @RequestMapping(value = "/company/regex/{regex}", method = RequestMethod.GET)
    public ResponseEntity<List<Company_Dto>> getCompanyByRegex(@PathVariable(value = "regex" ) String regex);

    @RequestMapping(value = "/company/stock/{companyCode}/{from}/{to}")
    public ResponseEntity<Double> getCompanyStockPrice(@PathVariable(value = "companyCode") int companyCode,@PathVariable(value = "from") String from,@PathVariable(value = "to") String to) throws ParseException ;

    @RequestMapping(value = "/company/ipo/{companyName}")
    public ResponseEntity<Optional<IPO_Dto>> getIpoDetails(@PathVariable(value = "companyName") String companyName);
}