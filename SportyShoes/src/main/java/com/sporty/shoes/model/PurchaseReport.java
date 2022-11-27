package com.sporty.shoes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="purchase_report")
public class PurchaseReport {
	
	@Id
	@GeneratedValue
	private int id;
	private String category;
	private Date date;
	String orderList;
	public PurchaseReport(int id, String category, Date date, String orderList) {
		super();
		this.id = id;
		this.category = category;
		this.date = date;
		this.orderList = orderList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOrderList() {
		return orderList;
	}
	public void setOrderList(String orderList) {
		this.orderList = orderList;
	}
	@Override
	public String toString() {
		return "PurchaseReport [id=" + id + ", category=" + category + ", date=" + date + ", orderList=" + orderList
				+ "]";
	}
	
	

}
