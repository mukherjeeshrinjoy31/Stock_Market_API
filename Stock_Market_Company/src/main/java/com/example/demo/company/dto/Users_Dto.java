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
public class Users_Dto {

	private String Username;
	private String Password;
	private String User_Type;
	private String Email;
	private long Mobile_Number;
	private int Confirmed;
}
