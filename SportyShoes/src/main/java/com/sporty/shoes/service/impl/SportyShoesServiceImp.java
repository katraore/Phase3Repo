package com.sporty.shoes.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;


import com.sporty.shoes.exceptionhandler.ResourceNotFoundException;
import com.sporty.shoes.model.PurchaseReport;
import com.sporty.shoes.model.SportyShoesModel;
import com.sporty.shoes.repository.PurchaseReportRepository;
import com.sporty.shoes.repository.SportyShoesRepository;
import com.sporty.shoes.service.SportyShoesService;

@Service
public class SportyShoesServiceImp implements SportyShoesService{
	
	private SportyShoesRepository ShoesRepo;
	private PurchaseReportRepository PurchaseRepo;


	@Override
	public SportyShoesModel saveSportyShoesModel(SportyShoesModel shoe) {
		return ShoesRepo.save(shoe) ;
	}

	@Override
	public SportyShoesModel getSportyShoesModelById(int id) {
		Optional<SportyShoesModel> shoe = ShoesRepo.findById(id);
		if(shoe.isPresent()) {
			return shoe.get();
		}else {
			throw new ResourceNotFoundException("SportyShoesModel", "Id", id);
		}
	}

	@Override
	public SportyShoesModel updateSportyShoesModel(SportyShoesModel shoe, int id) {
		
		// We need to check whether shoe with given id exists in DB or not 
		SportyShoesModel existingSportyShoesModel = ShoesRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("SportyShoesModel", "Id", id));
		
		existingSportyShoesModel.setName(shoe.getName());
		existingSportyShoesModel.setCategory(shoe.getCategory());
		existingSportyShoesModel.setSize(shoe.getSize());
		
		// save existing shoe to DB
		ShoesRepo.save(existingSportyShoesModel);
		
		return existingSportyShoesModel;
	}

	@Override
	public void deleteSportyShoesModelById(int id) {
		
		// check whether a shoe exist in a DB or not
		ShoesRepo.findById(id).orElseThrow(() -> 
		 new ResourceNotFoundException("SportyShoesModel", "Id", id));
		
		ShoesRepo.deleteById(id);
	}

	@Override
	public List<SportyShoesModel> getAllSportyShoesModel() {
		
		return ShoesRepo.findAll();
	}

	@Override
	public PurchaseReport savePurchaseReport(PurchaseReport report) {
		
		return PurchaseRepo.save(report);
	}

	@Override
	public PurchaseReport getPurchaseReportById(int id) {
		Optional<PurchaseReport> report = PurchaseRepo.findById(id);
		if(report.isPresent()) {
			return report.get();
		}else {
			throw new ResourceNotFoundException("PurchaseReport", "Id", id);
		}
	}

	@Override
	public PurchaseReport updatePurchaseReport(PurchaseReport report, int id) {
		
		// We need to check whether report with given id exists in DB or not 
		PurchaseReport existingPurchaseReport = PurchaseRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("SportyShoesModel", "Id", id));
		existingPurchaseReport.setId(report.getId());
		existingPurchaseReport.setCategory(report.getCategory());
		existingPurchaseReport.setDate(report.getDate());
		
		// save existing report to DB
		PurchaseRepo.save(existingPurchaseReport);

		
		return existingPurchaseReport;
	}

	@Override
	public void deletePurchaseReportById(int id)  {
		
		// check whether a shoe exist in a DB or not
		PurchaseRepo.findById(id).orElseThrow(() -> 
		 new ResourceNotFoundException("PurchaseReport", "Id", id));
		
		PurchaseRepo.deleteById(id);
		
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReports() {
		
		return PurchaseRepo.findAll();
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReportsByDOP(Date date) {
		
		return PurchaseRepo.findByDop(date);
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category) {
		
		return PurchaseRepo.findbyCategory(category);
	}
	
	
	

}
