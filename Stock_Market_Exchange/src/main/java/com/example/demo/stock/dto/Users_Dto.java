package com.example.demo.stock.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
