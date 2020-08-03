package com.example.demo.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.stock.model.Company;

import java.util.List;

public interface Company_Dao extends JpaRepository<Company,Long> {
    public List<Company> getAllBySector(String Sector);
}
