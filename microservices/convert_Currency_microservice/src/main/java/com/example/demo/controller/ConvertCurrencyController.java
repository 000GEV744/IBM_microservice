package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.feignClient.ConversionFactorClient;
import com.example.demo.model.FactorResponse;
import com.example.demo.service.ConvertService;

@RestController
public class ConvertCurrencyController {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());  
	
	@Autowired
	private ConversionFactorClient cnvFacCl;
	@Autowired
	private ConvertService convertServ;
	
	@GetMapping(value = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<?> convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable double quantity)  
	{ 
		FactorResponse fr =  cnvFacCl.getConversionFactor(from, to).getBody();
		logger.info("{}",fr);
		return ResponseEntity.ok(convertServ.getCurrencyConverted(from, to, fr, quantity));
	}  
	

}






/*
 * //setting variables to currency exchange service Map<String,
 * String>uriVariables=new HashMap<>(); uriVariables.put("from", from);
 * uriVariables.put("to", to); ResponseEntity<ConversionFactorResponse>
 * responseEntity = restTemplate.getForEntity(
 * "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
 * ConversionFactorResponse.class, uriVariables);
 * System.out.println(responseEntity); ConversionFactorResponse response =
 * responseEntity.getBody(); //creating a new response bean and getting the
 * response back and taking it into Bean return new CurrencyConversion(
 * from,to,response.getConversionFactor(),
 * quantity,quantity*(response.getConversionFactor()));
 */
