package com.etiya.ReCapProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "invoice_number")
	private String invoiceNumber;

	@Column(name = "create_date")
	private LocalDate createDate;

	@Column(name = "rent_date")
	private LocalDate rentDate;

	@Column(name = "return_date")
	private LocalDate returnDate;

	@Column(name = "total_rent_day")
	private int totalRentDay;

	@Column(name = "total_amount")
	private double totalAmount;
	
	//Customer'la beraber birde rental

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

}
