package com.etiya.rentACar.entities;

public class Car {
	
	private int id;
	private int brandId;
	private int colorId;
	private int year;
	private double dailyPrice;
	private String description;
	
	
	public Car() {

	}

	public Car(int id, int brandId, int colorId, int year, double dailyPrice, String description) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.colorId = colorId;
		this.year = year;
		this.dailyPrice = dailyPrice;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
