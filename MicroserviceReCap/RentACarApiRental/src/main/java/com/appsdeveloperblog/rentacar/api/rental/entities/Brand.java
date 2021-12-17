package com.appsdeveloperblog.rentacar.api.rental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brands")
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "brand_name")
	private String brandName;
	
	@OneToMany(mappedBy = "brand")
	private List<Car> cars;

}
