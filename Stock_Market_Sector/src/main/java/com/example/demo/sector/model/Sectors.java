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
public class Sectors {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long ID;
    private int Company_Code;
    private String Sector_Id;
    private String Sector;

}
