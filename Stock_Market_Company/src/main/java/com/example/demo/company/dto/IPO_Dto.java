package com.example.demo.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IPO_Dto {

	private String Company_Name;
    private String Stock_Exchange;
	private double Price_Per_Share;
	private int Total_Shares;
	private Date Open_Date_Time;
	private String Remarks;


}
