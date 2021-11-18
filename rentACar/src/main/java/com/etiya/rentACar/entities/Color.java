package com.etiya.rentACar.entities;

public class Color {
	
	private int id;
	private String colorName;
	public Color() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Color(int id, String colorName) {
		super();
		this.id = id;
		this.colorName = colorName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	
	

}
