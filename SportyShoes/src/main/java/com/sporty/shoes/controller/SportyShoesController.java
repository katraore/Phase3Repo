package com.sporty.shoes.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.sporty.shoes.model.PurchaseReport;
import com.sporty.shoes.model.SportyShoesModel;
import com.sporty.shoes.service.SportyShoesService;

@RestController

public class SportyShoesController {
	
private SportyShoesService shoeService;
	
public SportyShoesController(SportyShoesService shoesService) {
		super();
		this.shoeService = shoesService;
}

// build create shoe Rest API
@GetMapping("/shoe") 
public ResponseEntity<SportyShoesModel> saveSportyShoesModel(@RequestBody SportyShoesModel shoe){
		return new ResponseEntity<SportyShoesModel>(shoeService.saveSportyShoesModel(shoe), HttpStatus.CREATED);
	}

// build get shoe by id REST API
@GetMapping("/shoe/{id}")
public ResponseEntity<SportyShoesModel> getSportyShoesModelById(@PathVariable("id") int id){
	return new ResponseEntity<SportyShoesModel>(shoeService.getSportyShoesModelById(id), HttpStatus.OK);
}

//build update shoe REST API
@PutMapping("/shoe/{id}")
public ResponseEntity<SportyShoesModel> updateSportyShoesModel(@PathVariable("id") int id, @RequestBody SportyShoesModel shoe){
	return new ResponseEntity<SportyShoesModel>(shoeService.updateSportyShoesModel(shoe, id), HttpStatus.OK);
}

//build delete report REST API
@DeleteMapping("/shoe/delete/{id}")
public ResponseEntity<String> deleteSportyShoesModelById(@PathVariable("id") int id){
	// delete shoe from DB
	shoeService.deleteSportyShoesModelById(id);
	return new ResponseEntity<String>("Shoe has been successfully deleted with id: " + id, HttpStatus.OK);
}
//build get all shoe list by id REST API
@GetMapping("/shoe/all")
public ResponseEntity<List<SportyShoesModel>> getAllSportyShoesModel(){
	return new ResponseEntity<List<SportyShoesModel>>(shoeService.getAllSportyShoesModel(), HttpStatus.OK);
	
}

//build create report Rest API
@GetMapping("/report")
public ResponseEntity<PurchaseReport> savePurchaseReport(@RequestBody PurchaseReport report){
	return new ResponseEntity<>(shoeService.savePurchaseReport(report), HttpStatus.OK);
}

//build get report by id REST API
@GetMapping("/report/{id}")
public ResponseEntity<PurchaseReport> getPurchaseReportById(@PathVariable("id") int id ) {
	return new ResponseEntity<PurchaseReport>(shoeService.getPurchaseReportById(id), HttpStatus.OK);
}

//build update report REST API
@PutMapping("/report/{id}")
public ResponseEntity<PurchaseReport> updatePurchaseReport(@PathVariable("id") int id, @RequestBody PurchaseReport report){
	return new ResponseEntity<>(shoeService.updatePurchaseReport(report, id), HttpStatus.OK);	
}

// build delete report REST API
@DeleteMapping("/report/delete/{id}")
public ResponseEntity<String> deletePurchaseReportById(@PathVariable("id") int id){
	
	// delete report from DB
	shoeService.deletePurchaseReportById(id);
	return new ResponseEntity<String>("Report has been successfully deleted with id: " + id, HttpStatus.OK);
}

@GetMapping("/report/all")
public ResponseEntity<List<PurchaseReport>> getAllPurchaseReport(){
	return new ResponseEntity<List<PurchaseReport>>(shoeService.getAllPurchaseReports(), HttpStatus.OK);
}

@GetMapping("/report/date")
public ResponseEntity<List<PurchaseReport>> getPurchaseReportByDOP(@PathVariable Date date){
	return new ResponseEntity<List<PurchaseReport>>(shoeService.getAllPurchaseReportsByDOP(date), HttpStatus.OK);
	
}
@GetMapping("/report/category")
public ResponseEntity<List<PurchaseReport>> getPurchaseReportByCategory(@PathVariable String category){
	return new ResponseEntity<List<PurchaseReport>>(shoeService.getAllPurchaseReportsByCategory(category), HttpStatus.OK);
}
}
