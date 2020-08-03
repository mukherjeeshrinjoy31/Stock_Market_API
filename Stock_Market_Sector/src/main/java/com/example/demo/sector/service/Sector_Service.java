package com.example.demo.sector.service;

import com.example.demo.sector.dto.Company_Dto;
import com.example.demo.sector.model.Sectors;

import java.util.List;

public interface Sector_Service {
    public List<Company_Dto> getListOfCompaniesInSector(String Sector);
    public double getSectorPrice(String Sector_Id, String from, String to);
}
