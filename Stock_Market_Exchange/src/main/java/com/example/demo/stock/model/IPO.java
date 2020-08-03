package com.example.demo.stock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IPO {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long ID;
	private String Company_Name;
    private String Stock_Exchange;
	private double Price_Per_Share;
	private int Total_Shares;
	private Date Open_Date_Time;
	private String Remarks;

}
