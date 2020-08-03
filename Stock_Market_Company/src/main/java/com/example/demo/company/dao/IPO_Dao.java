package com.example.demo.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.company.model.IPO;

@Repository
public interface IPO_Dao extends JpaRepository<IPO,Long> {
    public IPO findByCompanyName(String companyName);
}
