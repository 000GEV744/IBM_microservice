package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.CurrencyConversion;
import com.example.demo.model.FactorResponse;

@Service
public class ConvertServiceImpl implements ConvertService {

   public CurrencyConversion getCurrencyConverted(String from,String to,FactorResponse fResp, double quantity) {
	   
	   double totalCalculatedAmount = quantity * fResp.getConversionFactor();
	   return new CurrencyConversion(from, to, fResp.getConversionFactor(), quantity, totalCalculatedAmount);   
   
   }
}
