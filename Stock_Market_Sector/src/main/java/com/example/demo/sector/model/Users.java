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
public class Users {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long ID;
	private String Username;
	private String Password;
	private String User_Type;
	private String Email;
	private long Mobile_Number;
	private int Confirmed;


}
