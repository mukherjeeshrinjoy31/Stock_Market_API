package com.example.demo.sector.controller;

import com.example.demo.sector.dto.Company_Dto;
import com.example.demo.sector.service.Sector_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SectorsDetailsController {
    
	private Sector_Service sector_service;
	
	@Autowired
	public SectorsDetailsController(Sector_Service sector_service) {
		super();
		this.sector_service = sector_service;
	}

	

    @RequestMapping("/sector/listCompanies/{Sector}")
    public ResponseEntity<List<Company_Dto>> getListOfCompaniesInSector(@PathVariable String Sector){
        return ResponseEntity.status(HttpStatus.FOUND).body(sector_service.getListOfCompaniesInSector(Sector));
    }

    @RequestMapping("/sector/price/{Sector_Id}/from/{from}/to/{to}")
    public ResponseEntity<Double> getSectorPrice(@PathVariable String Sector_Id,@PathVariable String from,@PathVariable String to){
        return ResponseEntity.status(HttpStatus.FOUND).body(sector_service.getSectorPrice(Sector_Id,from,to));
    }
}
