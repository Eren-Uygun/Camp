package com.etiya.northwindSpring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data //Getter ve Setter lombok ile otomatikleşir.
@AllArgsConstructor //Dolu Constructor
@NoArgsConstructor //Boş Constructor
@Entity //Veri tabanı varlığını belirtir.
@Table(name = "products") //Tabloda oluşacak yada karşılık gelecek tablo adı
public class Product {
	
	
	@Id //P.key için anotasyon
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Otomatik olarak üretilir.
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_name")
	private String productName;

	/* Relation belirttiğimiz için bu alana gerek kalmadı.
	@Column(name = "category_id")
	private int categoryId;
	*/
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name = "units_in_stock")
	private int unitsInStock;
	
	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;
	
	
	
	@ManyToOne() //Ürünlerin bir kategorisi vardır bu db'ye göre.
	@JoinColumn(name = "category_id") //Hangi alana göre join edeyim.
	private Category category;





	
	
	
	


	
	

}
