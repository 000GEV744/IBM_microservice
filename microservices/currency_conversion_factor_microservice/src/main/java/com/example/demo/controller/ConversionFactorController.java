package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FactorResponse;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.ConversionFactor;
import com.example.demo.service.ConversionFactorService;

@RestController
public class ConversionFactorController {

	private Logger logger=LoggerFactory.getLogger(this.getClass());  
	
	@Autowired
	private ConversionFactorService  conversionFactorService;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ModelMapper mapper;
	
	//get the list of all conversion factor stored
	@GetMapping(value = "/currency-exchange")
	public ResponseEntity<List<?>> getAllConversionFactor(){
		return ResponseEntity.ok(conversionFactorService.getAllConversionFactor());	
	}
	
	
	//add a conversion factor
	@PostMapping(value = "/currency-exchange")
	public ResponseEntity<List<?>> addConversionFactor(@RequestBody ConversionFactor cf) {
		conversionFactorService.addConversionFactor(cf);
		List<?> list = conversionFactorService.getAllConversionFactor();
		return new ResponseEntity<>(list,HttpStatus.CREATED);
		}
	
	
	//get a conversion factor for particular from and to
	@GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
	public ResponseEntity<FactorResponse> getConversionFactor(@PathVariable String from, @PathVariable String to) {
		
		 logger.info("Port :: "+env.getProperty("local.server.port"));
		 
		ConversionFactor cf = conversionFactorService.getConversionFactor(from, to);
		if(cf==null) {
			throw new NotFoundException("Factor not Found");
		}
		logger.info("{}", cf);
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		FactorResponse facRespStatus = mapper.map(cf, FactorResponse.class);
		
		return ResponseEntity.ok(facRespStatus);	
	}
	
	
	//update a conversion factor
	@PutMapping(value = "/currency-exchange/{id}")
	public ResponseEntity<Optional<ConversionFactor>> updateConversionFactor(@RequestBody ConversionFactor cf, @PathVariable long id) {
		return ResponseEntity.ok(conversionFactorService.updateConversionFactor(id,cf));
	}
}
