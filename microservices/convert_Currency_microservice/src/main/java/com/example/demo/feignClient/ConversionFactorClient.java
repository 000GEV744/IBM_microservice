package com.example.demo.feignClient;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.feignClient.model.ConversionFactor;
import com.example.demo.model.FactorResponse;

//, fallback = ConversionFactorFallback.class
@FeignClient(name = "CURRENCY-EXCHANGE-SERVICE")
@RibbonClient(name = "CURRENCY-EXCHANGE-SERVICE")
public interface ConversionFactorClient {

	@GetMapping(value = "/currency-exchange")
	public ResponseEntity<?> getAllConversionFactor();
	
	@PostMapping(value = "/currency-exchange")
	public ResponseEntity<?> addConversionFactor(@RequestBody ConversionFactor cf);
	
	@GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
	public ResponseEntity<FactorResponse> getConversionFactor(@PathVariable String from, @PathVariable String to);
	
	@PutMapping(value = "/currency-exchange/{id}")
	public ResponseEntity<?> updateConversionFactor(@RequestBody ConversionFactor cf, @PathVariable long id);
}
