package com.etiya.rentACar.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.servlet.annotation.HandlesTypes;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private int id;
	
	/*
	@Column(name = "brand_id")
	private int brandId;
	
	@Column(name = "color_id")
	private int colorId;
*/
	
	@Column(name = "model_year")
	private int modelYear;
	@Column(name = "daily_price")
	private double dailyPrice;
	@Column(name = "description")
	private String description;
	
	@ManyToOne()
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@ManyToOne()
	@JoinColumn(name = "color_id")
	private Color color;
	
	
	@OneToMany(mappedBy = "car")
	private List<Rental> rentals;
	
	@OneToMany(mappedBy = "car")
	@Size(min = 0,max = 5)
	private List<CarImage> carImages;
	

}
