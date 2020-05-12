package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ConversionFactor;

@Repository
public interface ConversionFactorRepository extends JpaRepository<ConversionFactor, Long>{
	ConversionFactor findByFromAndTo(String from, String to); 
	List<ConversionFactor> findAll();
}
