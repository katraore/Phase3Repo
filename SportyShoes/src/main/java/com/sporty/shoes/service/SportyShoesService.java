package com.sporty.shoes.service;

import java.util.Date;
import java.util.List;


import com.sporty.shoes.model.PurchaseReport;
import com.sporty.shoes.model.SportyShoesModel;

public interface SportyShoesService {
	
	SportyShoesModel saveSportyShoesModel(SportyShoesModel shoe); 
	SportyShoesModel getSportyShoesModelById(int id);
	SportyShoesModel updateSportyShoesModel(SportyShoesModel shoe, int id);
	void deleteSportyShoesModelById(int id);
	List<SportyShoesModel> getAllSportyShoesModel();
	
	PurchaseReport savePurchaseReport(PurchaseReport report);
	PurchaseReport getPurchaseReportById(int id);
	PurchaseReport updatePurchaseReport(PurchaseReport report, int id);
	void deletePurchaseReportById(int id);
	List<PurchaseReport> getAllPurchaseReports();
	List<PurchaseReport> getAllPurchaseReportsByDOP(Date date);
	List<PurchaseReport> getAllPurchaseReportsByCategory(String category);

}
