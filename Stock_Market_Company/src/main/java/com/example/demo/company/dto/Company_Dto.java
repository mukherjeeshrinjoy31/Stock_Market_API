package com.example.demo.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company_Dto {
	 	private int Company_Code;
	    private String Company_Name;
		private long Company_Turnover;
		private String CEO;
		private String Company_BOD;
		private String Sector;
		private String Company_Brief;
		private String Stock_Code;
}
