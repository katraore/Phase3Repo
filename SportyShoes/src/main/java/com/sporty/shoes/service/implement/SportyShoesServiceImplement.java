package com.sporty.shoes.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sporty.shoes.exceptionhandler.ExceptionHandler;
import com.sporty.shoes.model.PurchaseReport;
import com.sporty.shoes.model.SportyShoesModel;
import com.sporty.shoes.repository.PurchaseReportRepository;
import com.sporty.shoes.repository.SportyShoesRepository;
import com.sporty.shoes.service.SportyShoesService;

public class SportyShoesServiceImplement implements SportyShoesService {
	
	@Autowired
	private SportyShoesRepository ShoesRepo;
	@Autowired
	private PurchaseReportRepository PurchaseRepo;

	@Override
	public SportyShoesModel createSportyShoesModel(SportyShoesModel shoe) throws ExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SportyShoesModel getSportyShoesModelById(int id) throws ExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SportyShoesModel updateSportyShoesModel(SportyShoesModel shoe) throws ExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSportyShoesModelById(int id) throws ExceptionHandler {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SportyShoesModel> getAllSportyShoesModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseReport createPurchaseReport(PurchaseReport report) throws ExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseReport getPurchaseReportById(int id) throws ExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseReport updatePurchaseReport(PurchaseReport report) throws ExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dletePurchaseReportById(int id) throws ExceptionHandler {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReports() throws ExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReportsByDOP(Date date) throws ExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category) throws ExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

}
