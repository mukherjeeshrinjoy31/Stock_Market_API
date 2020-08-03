package com.example.demo.sector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.sector.dto.Company_Dto;

import java.util.List;

@FeignClient(name="netflix-zuul-api-gateway-server")
public interface ProxySectorDataService {
    @RequestMapping("/sector/listCompanies/{sector}")
    public ResponseEntity<List<Company_Dto>> getListOfCompaniesInSector(@PathVariable(value = "sector") String sector);

    @RequestMapping("/sector/price/{sectorId}/from/{from}/to/{to}")
    public ResponseEntity<Double> getSectorPrice(@PathVariable(value = "sectorId") String sectorId,@PathVariable(value = "from") String from,@PathVariable(value = "to") String to);
}
