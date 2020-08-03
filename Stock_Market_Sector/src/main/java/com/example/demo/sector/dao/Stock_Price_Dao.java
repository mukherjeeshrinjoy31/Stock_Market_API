package com.example.demo.sector.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.sector.model.Stock_Price;

import java.sql.Date;
import java.util.List;

public interface Stock_Price_Dao extends JpaRepository<Stock_Price,Long> {
    @Query(value = "SELECT * FROM STOCK_PRICE s WHERE s.company_code IN (:companyCode) AND s.date BETWEEN (:fromDate) AND (:toDate)",
            nativeQuery = true)
    public List<Stock_Price> getAll(@Param("companyCode")List<Integer> companyCode, @Param("fromDate")Date fromDate,@Param("toDate")Date toDate);
}
