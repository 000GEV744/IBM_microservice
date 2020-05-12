package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {
	
	
	private String from;  
	private String to;  
	private double ConversionMultiple;  
	private double quantity;  
	private double totalCalculatedAmount;
}
