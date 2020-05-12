package com.example.demo.service;

import com.example.demo.model.CurrencyConversion;
import com.example.demo.model.FactorResponse;

public interface ConvertService {

	public CurrencyConversion getCurrencyConverted(String from,String to,FactorResponse fResp, double quantity);
}
