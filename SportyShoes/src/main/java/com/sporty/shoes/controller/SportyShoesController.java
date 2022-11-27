package com.sporty.shoes.controller;

import java.util.Date;
import java.util.List;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sporty.shoes.exceptionhandler.ExceptionHandler;
import com.sporty.shoes.model.PurchaseReport;
import com.sporty.shoes.model.SportyShoesModel;
import com.sporty.shoes.repository.PurchaseReportRepository;
import com.sporty.shoes.repository.SportyShoesRepository;
import com.sporty.shoes.service.SportyShoesService;

@RestController
@RequestMapping

public class SportyShoesController {
	

	@Autowired
	private SportyShoesService service;
	
	private MultiValueMap<String, String> error;
	
	/*
	 * Shoe post request controlle with newly created Shoe
	 */
	@PostMapping(value = "shoe",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SportyShoesModel> createSportyShoesModel(@RequestBody SportyShoesModel shoe) {
		
		try {
			return new ResponseEntity<>(service.createSportyShoesModel(shoe), HttpStatus.OK );
			
		} catch (ExceptionHandler e) {
			error = new LinkedMultiValueMap<>(); 
			error.add("errorMessage:", e.getMessage());
			
			return new ResponseEntity<SportyShoesModel>(null, error, HttpStatus.BAD_REQUEST);
			
		}
		

	}
		
	/*
	 * Shoe get request controller with the given id
	 */
	@GetMapping(value = "shoe/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SportyShoesModel> getSportyShoesModelById(@PathVariable int id){
		try {
			return new ResponseEntity<>(service.getSportyShoesModelById(id), HttpStatus.OK);
			
			
		} catch (ExceptionHandler e) {
			error = new LinkedMultiValueMap<>(); 
			error.add("errorMessage:", e.getMessage());
			
			return new ResponseEntity<SportyShoesModel>(null, error, HttpStatus.NOT_FOUND);
		}
	}
		
	/*
	 * Shoe update request controller with updated shoe
	 */	
	@PutMapping(value = "/shoe")
	public ResponseEntity<SportyShoesModel> updateSportyShoesModel(@RequestBody SportyShoesModel shoe) throws ExceptionHandler {
		
		return new ResponseEntity<>(service.updateSportyShoesModel(shoe), HttpStatus.OK);
		
	}
	
	/*
	 * Shoe delete request controller with id number
	 */
	@DeleteMapping(value ="shoe/{id}")
	public ResponseEntity<String> deleteSportyShoesModelById(@PathVariable int id){
		try {
			service.deleteSportyShoesModelById(id);
			return new ResponseEntity<>("Shoe has been successfully deleted with id: " + id, HttpStatus.OK);
			
		} catch (ExceptionHandler e) {
			error = new LinkedMultiValueMap<>(); 
			error.add("errorMessage:", e.getMessage());
			
			return new ResponseEntity<>(e.getMessage(), error, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	/*
	 * Purchase Report  request controller with newly created Purchase Report
	 */
	@GetMapping(value = "report", consumes  = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PurchaseReport> createPurchaseReport(@RequestBody PurchaseReport report){
		try {
			return new ResponseEntity<>(service.createPurchaseReport(report), HttpStatus.OK);
		} catch (ExceptionHandler e) {
			error = new LinkedMultiValueMap<>(); 
			error.add("errorMessage:", e.getMessage());
			
			return new ResponseEntity<>(null, error, HttpStatus.BAD_REQUEST);
		}			
		
	}
	
	/*
	 * 
	/*
	 * Purchase Report get request controller with  with the given id
	 */
	@PostMapping(value="report/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PurchaseReport> getPurchaseReportById(@PathVariable int id ) {
		try {
			return new ResponseEntity<>(service.getPurchaseReportById(id), HttpStatus.OK);
		} catch (Exception e) {
			error = new LinkedMultiValueMap<>(); 
			error.add("errorMessage:", e.getMessage());
			
			return new ResponseEntity<PurchaseReport>(null, error, HttpStatus.NOT_FOUND);
		}	
	}
	
	/*
	 * Report update request controller with updated shoe
	 */	
	@PutMapping(value="report")
	public ResponseEntity<PurchaseReport> updatePurchaseReport(@RequestBody PurchaseReport report) throws ExceptionHandler {
	
		return new ResponseEntity<>(service.updatePurchaseReport(report), HttpStatus.OK);		
	}
	
	/*
	 * Report delete request controller with id number
	 */
	@DeleteMapping(value="report/{id}")
	public ResponseEntity<String> deletePurchaseReportById(@PathVariable int id){
		
		try {
			service.deletePurchaseReportById(id);
			return new ResponseEntity<>("Report has been successfully deleted with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
	
			error = new LinkedMultiValueMap<>(); 
			error.add("errorMessage:", e.getMessage());
			
			return new ResponseEntity<>(e.getMessage(), error, HttpStatus.BAD_REQUEST);
			
		}
	
		
	}

}
