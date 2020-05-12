package com.example.demo.feignClient;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.feignClient.model.ConversionFactor;
import com.example.demo.model.FactorResponse;

@Component
public class ConversionFactorFallback implements ConversionFactorClient {

	@Override
	public ResponseEntity<?> getAllConversionFactor() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(new ArrayList<>());
	}

	@Override
	public ResponseEntity<?> addConversionFactor(ConversionFactor cf) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(new ArrayList<>());
	}

	@Override
	public ResponseEntity<FactorResponse> getConversionFactor(String from, String to) {
		// TODO Auto-generated method stub
		FactorResponse fResp = new FactorResponse(00.00);
		return ResponseEntity.ok(fResp);
	}

	@Override
	public ResponseEntity<?> updateConversionFactor(ConversionFactor cf, long id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(new ConversionFactor(1L, "EUR", "INR", 75.0));
	}

}
