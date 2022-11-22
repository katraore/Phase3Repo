package com.sporty.shoes.service.implement;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

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
		int id = shoe.getId();
		SportyShoesModel oldShoe = null;
		try {
			oldShoe = ShoesRepo.findById(id).get();
		} catch (NoSuchElementException e) {
			
		}
		if (oldShoe != null) throw new ExceptionHandler("Shoe already exists with id" +" "+ id);
		return ShoesRepo.save(shoe) ;
	}

	@Override
	public SportyShoesModel getSportyShoesModelById(int id) throws ExceptionHandler {
		// TODO Auto-generated method stub
		SportyShoesModel shoe = null;
		try {
			if (id<=0)throw new ExceptionHandler("Id can not be negative or zero");
			shoe = ShoesRepo.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new ExceptionHandler("Shoe cannot be found with id"+ " "+id);
		}
		return shoe;
	}

	@Override
	public SportyShoesModel updateSportyShoesModel(SportyShoesModel shoe) throws ExceptionHandler {
		// TODO Auto-generated method stub
		return ShoesRepo.save(shoe);
	}

	@Override
	public void deleteSportyShoesModelById(int id) throws ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			ShoesRepo.deleteById(id);
		} catch (Exception e) {
			throw new ExceptionHandler("Invalid id or shoe does not exist: "+id);
		}
	}

	@Override
	public List<SportyShoesModel> getAllSportyShoesModel() {
		// TODO Auto-generated method stub

		return ShoesRepo.findAll();
	}

	@Override
	public PurchaseReport createPurchaseReport(PurchaseReport report) throws ExceptionHandler {
		// TODO Auto-generated method stub
		int id = report.getId();
		PurchaseReport oldReport = null;
		try {
			oldReport = PurchaseRepo.getById(id);
		} catch (Exception e) {
			
		}
		if (oldReport != null) throw new ExceptionHandler("Report already exists with id" +" "+ id);
		return PurchaseRepo.save(report);
	}

	@Override
	public PurchaseReport getPurchaseReportById(int id) throws ExceptionHandler {
		// TODO Auto-generated method stub
		PurchaseReport report = null;
		
		try {
			if (id<=0)throw new ExceptionHandler("Id can not be negative or zero");
			report = PurchaseRepo.findById(id).get();
		} catch (Exception e) {
			throw new ExceptionHandler("Purchase report could not be found with id : "+id);
		}
		return report;
	}

	@Override
	public PurchaseReport updatePurchaseReport(PurchaseReport report) throws ExceptionHandler {
		// TODO Auto-generated method stub
		return PurchaseRepo.save(report);
	}

	@Override
	public void dletePurchaseReportById(int id) throws ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			PurchaseRepo.deleteById(id);
		} catch (Exception e) {
			throw new ExceptionHandler("Invalid id or report does not exist: "+id);
		}
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReports() throws ExceptionHandler {
		// TODO Auto-generated method stub
		return PurchaseRepo.findAll();
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReportsByDOP(Date date) throws ExceptionHandler {
		// TODO Auto-generated method stub
		return PurchaseRepo.findByDop(date);
	}

	@Override
	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category) throws ExceptionHandler {
		// TODO Auto-generated method stub
		return PurchaseRepo.findbyCategory(category);
	}

	
	@PostConstruct
	public void init() {
		SportyShoesModel s1 = new SportyShoesModel(1, "Nike", "Basketball" , 13, 200.99);
		SportyShoesModel s2 = new SportyShoesModel(2, "Addidas", "Soccer" , 10, 179.99);
		SportyShoesModel s3 = new SportyShoesModel(3, "Puma", "Cricket" , 9, 189.99);
		SportyShoesModel s4 = new SportyShoesModel(4, "Reebok", "Football" , 12, 129.99);
		
		ShoesRepo.save(s1);
		ShoesRepo.save(s2);
		ShoesRepo.save(s3);
		ShoesRepo.save(s4);
		
		Date date = new Date();
		

		PurchaseReport p1 = new PurchaseReport(1,"Baba", date, "2 Addidas,3 Nike");
		PurchaseReport p2 = new PurchaseReport(2,"Kassoum", date, "1 Addidas,2 Nike");
		PurchaseReport p3 = new PurchaseReport(3,"Nouhoum", date, "2 Puma,3 Reebok");
		
		PurchaseRepo.save(p1);
		PurchaseRepo.save(p2);
		PurchaseRepo.save(p3);
	}
	
}
