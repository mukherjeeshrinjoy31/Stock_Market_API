package com.example.demo.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sectors_Dto {

	private int Company_Code;
    private String Sector_Id;
    private String Sector;
}
