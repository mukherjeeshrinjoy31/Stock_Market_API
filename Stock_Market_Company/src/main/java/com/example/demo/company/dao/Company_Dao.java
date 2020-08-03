package com.example.demo.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.company.model.Company;

import java.util.List;

@Repository
public interface Company_Dao extends JpaRepository<Company,Long> {
    public Company findByCompanyCode(int companyCode);
    public List<Company> findByCompanyNameContaining(String regex);
}
