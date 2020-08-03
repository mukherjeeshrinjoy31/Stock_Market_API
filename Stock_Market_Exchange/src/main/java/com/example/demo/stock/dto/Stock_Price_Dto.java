package com.example.demo.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock_Price_Dto {

	private int Company_Code;
    private double Stock_Price;
    private String Stock_Exchange;
    private Date Date;

}
