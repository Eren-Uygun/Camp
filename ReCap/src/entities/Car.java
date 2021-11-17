package entities;

import java.util.Date;

public class Car {
	
	private int carId;
	private int colorId;
	private int brandId;
	private int year;
	private double dailyPrice;
	private String description;
	
	public Car() {
		super();
	}
	
	public Car(int carId, int colorId, int brandId, int year, double dailyPrice, String description) {
		super();
		this.carId = carId;
		this.colorId = colorId;
		this.brandId = brandId;
		this.year = year;
		this.dailyPrice = dailyPrice;
		this.description = description;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
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
