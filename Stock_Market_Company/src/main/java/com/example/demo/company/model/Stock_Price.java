package com.example.demo.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock_Price {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long ID;
    private int Company_Code;
    private double Stock_Price;
    private String Stock_Exchange;
    private Date Date;

}
