package com.example.demo.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.stock.model.IPO;

import java.util.List;

public interface IPO_Dao extends JpaRepository<IPO,Long> {
    public List<IPO> getAllByStockExchange(String Stock_Exchange);
}
