package com.example.demo.sector.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long ID;
    private int Company_Code;
    private String Company_Name;
	private long Company_Turnover;
	private String CEO;
	private String Company_BOD;
	private String Sector;
	private String Company_Brief;
	private String Stock_Code;



}