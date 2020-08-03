package com.example.demo.company.model;

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
public class Stock_Exchange {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long ID;

    private String Stock_Exchange;

}
