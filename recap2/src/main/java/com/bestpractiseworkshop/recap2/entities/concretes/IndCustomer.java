package com.bestpractiseworkshop.recap2.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "individual_customer")
public class IndCustomer extends Customer {

    private String firstName;
    private String secondName;
    private String lastName;
    private String nationalIdentityNumber;
    private LocalDate birthDate;
    private String birthPlace;
    
     
    
}
