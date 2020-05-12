package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import com.example.demo.model.ConversionFactor;

public interface ConversionFactorService {
	public Optional<ConversionFactor> addConversionFactor(ConversionFactor cfObject);
	Optional<ConversionFactor> updateConversionFactor(long id,ConversionFactor cfObject);
	ConversionFactor getConversionFactor(String from, String to);
	List<ConversionFactor> getAllConversionFactor();
	
}
