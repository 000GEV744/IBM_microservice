package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.FactorNotCreatedException;
import com.example.demo.model.ConversionFactor;
import com.example.demo.repository.ConversionFactorRepository;

@Service
public class ConversionFactorServiceImpl implements ConversionFactorService {

	@Autowired
	private ConversionFactorRepository conversionFactorRepo;
	
	
	//CREATE
	public Optional<ConversionFactor> addConversionFactor(ConversionFactor cfObject) {
		
		ConversionFactor cf = this.findByFromAndTo(cfObject.getFrom(), cfObject.getTo());
		if(cf!= null) {
			throw new BadRequestException("Factor for particular country codes already exists"); //Incase factors already exists
		}
		else {
		cfObject = this.removeWhiteSpaceNMakeUpperCase(cfObject);
		conversionFactorRepo.save(cfObject);
		Optional<ConversionFactor> cvFc = conversionFactorRepo.findById(cfObject.getId());
		if(cvFc.isPresent()) {
			return cvFc;
		}
		throw new FactorNotCreatedException("Factor not created"); //for INTERNAL_SERVER_ERROR
		}
	}
	
	//UPDATE
	public Optional<ConversionFactor> updateConversionFactor(long id,ConversionFactor cfObject) {
		
		Optional<ConversionFactor> convFact = conversionFactorRepo.findById(id);
		System.out.println(convFact);
		if(convFact.isPresent()) {
			cfObject = this.removeWhiteSpaceNMakeUpperCase(cfObject);
			conversionFactorRepo.save(cfObject);
			return conversionFactorRepo.findById(id);
		}
		else throw new BadRequestException("Resource not available to update");
	}
	
	//RETREIVE
	public ConversionFactor getConversionFactor(String from, String to) {
		ConversionFactor cf = this.findByFromAndTo(from, to);
		return cf;
	}
	
	//RETREIVE ALL
	public List<ConversionFactor> getAllConversionFactor(){
		return conversionFactorRepo.findAll();
	}
	
	
	//********************utility function :: START**************************
	private ConversionFactor findByFromAndTo(String from,String to) {
		from = from.replaceAll("\\s+","").toUpperCase();
		to = to.replaceAll("\\s+","").toUpperCase();
		ConversionFactor cf = conversionFactorRepo.findByFromAndTo(from, to);
		return cf;
	}
	
	
	
	private ConversionFactor removeWhiteSpaceNMakeUpperCase(ConversionFactor cf) {
		String from = (cf.getFrom().replaceAll("\\s+","")).toUpperCase();
		String to = (cf.getTo().replaceAll("\\s+","")).toUpperCase();
		cf.setFrom(from);
		cf.setTo(to);
		return cf;
	}
	//********************utility function :: END**************************
}
