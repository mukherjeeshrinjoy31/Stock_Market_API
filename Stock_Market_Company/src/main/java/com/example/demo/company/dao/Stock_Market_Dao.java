package com.example.demo.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.company.model.Stock_Price;

import javax.xml.crypto.Data;

import java.sql.Date;
import java.util.List;

@Repository
public interface Stock_Market_Dao extends JpaRepository<Stock_Price,Long> {
    public List<Stock_Price> findAllByCompanyCodeAndDateBetween(int companyCode, Date from, Date to);
}
