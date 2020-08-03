package com.example.demo.stock;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.stock.dto.Stock_Exchange_Dto;

@FeignClient(name="netflix-zuul-api-gateway-server")
public interface Proxy_Stock_Exchange {

    @RequestMapping(value = "/exchange/all",method = RequestMethod.GET)
    public ResponseEntity<Iterable<Stock_Exchange_Dto>> getStockExchangeList();

    @RequestMapping(value = "/exchange/add",method = RequestMethod.POST)
    public ResponseEntity<Stock_Exchange_Dto> addStockExchangeList(@RequestBody Stock_Exchange_Dto stockExchangeDTO);

    @RequestMapping(value = "/exchange/{stockExchange}/companies",method = RequestMethod.GET)
    public ResponseEntity<Iterable<String>> getCompaniesByExchange(@PathVariable(value = "stockExchange") String stockExchange);
}
