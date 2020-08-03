package com.example.demo.sector.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.sector.model.Company;
import com.example.demo.sector.model.Sectors;

import java.util.List;

public interface Sector_Dao extends JpaRepository<Sectors,Long> {
    public List<Sectors> getAllBySectorId(String Sector_Id);

}
