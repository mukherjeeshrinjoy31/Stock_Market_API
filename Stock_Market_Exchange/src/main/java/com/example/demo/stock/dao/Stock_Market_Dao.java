package com.example.demo.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.stock.model.Stock_Exchange;

public interface Stock_Market_Dao extends JpaRepository<Stock_Exchange,Long> {

}
