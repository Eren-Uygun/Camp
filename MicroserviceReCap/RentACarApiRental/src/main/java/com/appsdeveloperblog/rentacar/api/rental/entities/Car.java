package com.appsdeveloperblog.rentacar.api.rental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "daily_price")
	private double dailyPrice;
	
	@Column(name = "model_year")
	private int modelYear;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@ManyToOne()
	@JoinColumn(name = "color_id")
	private Color color;
	

}
