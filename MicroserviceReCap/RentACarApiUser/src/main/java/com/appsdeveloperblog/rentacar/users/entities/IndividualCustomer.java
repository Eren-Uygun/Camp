package com.appsdeveloperblog.rentacar.users.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "individual_customers")
@PrimaryKeyJoinColumn(name = "customer_id")
public class IndividualCustomer extends Customer {
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "birthdate")
	private LocalDate birthdate;

}
