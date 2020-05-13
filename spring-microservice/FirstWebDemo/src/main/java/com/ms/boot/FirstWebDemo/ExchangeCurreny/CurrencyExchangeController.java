package com.ms.boot.FirstWebDemo.ExchangeCurreny;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ms.boot.FirstWebDemo.product.Product;
import com.springboot.microservice.currencyconversion.CurrencyConversionBean;

@RestController
@RequestMapping(path = "/currency-exchange")
public class CurrencyExchangeController {

	@Autowired
	private ExchangeValueRepository repository;

		
	@RequestMapping(path = "/count", method = RequestMethod.GET)
	public long getCountProducts() {
		return repository.count();
	}

		
	@GetMapping("/from/{from}/to/{to}")
	  public ExchangeValue retrieveExchangeValue
	    (@PathVariable String from, @PathVariable String to){
	    
	    ExchangeValue exchangeValue = 
	        repository.findByFromAndTo(from, to);
	    
	   return exchangeValue;
	  }
	
	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public ExchangeValue convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		repository.findByFromAndTo(from, to);
		
		ExchangeValue oid = repository.findByFromAndTo(from, to);
		
		return new ExchangeValue(oid.getId(), from, to, oid.getConversionMultiple(), quantity,
				quantity.multiply(oid.getConversionMultiple()), oid.getPort());
	

		
	}

}
