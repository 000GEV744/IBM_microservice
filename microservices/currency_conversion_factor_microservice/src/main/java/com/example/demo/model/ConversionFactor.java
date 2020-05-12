package com.example.demo.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConversionFactor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	private Long id;
	
	@Column(name = "currency_from")
	@NotNull
	private String from;
	@Column(name = "currency_to")
	@NotNull
	private String to;
	@Column(name = "conversion_factor")
	@NotNull
	private double conversionFactor;
	
	
}
