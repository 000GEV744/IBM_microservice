package com.example.demo.feignClient.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversionFactor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	
	@NotNull
	private String from;
	
	@NotNull
	private String to;
	
	@NotNull
	private double conversionFactor;
	
	
}
