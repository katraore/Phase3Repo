package com.sporty.shoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SportyShoesModel {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String category;
	private int size;
	private double price;
	public SportyShoesModel(int id, String name, String category, int size, double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.size = size;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "SportyShoesModel [id=" + id + ", name=" + name + ", category=" + category + ", size=" + size
				+ ", price=" + price + "]";
	}
	
	

}
