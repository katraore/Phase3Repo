package com.sporty.shoes.service;

import java.util.Date;
import java.util.List;

import com.sporty.shoes.exceptionhandler.ExceptionHandler;
import com.sporty.shoes.model.PurchaseReport;
import com.sporty.shoes.model.SportyShoesModel;

public interface SportyShoesService {
	
	public SportyShoesModel createSportyShoesModel(SportyShoesModel shoe) throws ExceptionHandler;
	public SportyShoesModel getSportyShoesModelById(int id) throws ExceptionHandler;
	public SportyShoesModel updateSportyShoesModel(SportyShoesModel shoe) throws ExceptionHandler;
	public void deleteSportyShoesModelById(int id)  throws ExceptionHandler;
	public List<SportyShoesModel> getAllSportyShoesModel();
	
	
	public PurchaseReport createPurchaseReport(PurchaseReport report) throws ExceptionHandler;
	public PurchaseReport getPurchaseReportById(int id) throws ExceptionHandler;
	public PurchaseReport updatePurchaseReport(PurchaseReport report) throws ExceptionHandler;
	public void dletePurchaseReportById(int id) throws ExceptionHandler;
	public List<PurchaseReport> getAllPurchaseReports()throws ExceptionHandler;
	public List<PurchaseReport> getAllPurchaseReportsByDOP(Date date) throws ExceptionHandler;
	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category) throws ExceptionHandler;

}
