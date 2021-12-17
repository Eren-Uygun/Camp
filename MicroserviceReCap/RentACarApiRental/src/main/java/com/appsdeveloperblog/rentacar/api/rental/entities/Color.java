package com.appsdeveloperblog.rentacar.api.rental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "colors")
public class Color {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "color_name")
	private String colorName;
	
	@OneToMany(mappedBy = "color")
	private List<Car> cars;
	

}
