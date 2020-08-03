package com.example.demo.sector.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.sector.model.Company;

import java.util.List;

public interface Company_Dao extends JpaRepository<Company,Long> {
    public List<Company> getAllBySector(String sector);
}
