package com.etiya.northwindSpring.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Getter ve Setter lombok ile otomatikleşir.
@AllArgsConstructor //Dolu Constructor
@NoArgsConstructor //Boş Constructor
@Entity //Veri tabanı varlığını belirtir.
@Table(name = "categories") //Tabloda oluşacak yada karşılık gelecek tablo adı
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int id;
	
	@Column(name = "category_name")
	private String categoryName;
	
	//Bir kategorinin altında birden fazla ürün olabilir. One To Many
	@OneToMany(mappedBy = "category")//Karşı tarafda category adlı bir alan var ben onla ilişkiliyim.
	private List<Product> products;
	

}
