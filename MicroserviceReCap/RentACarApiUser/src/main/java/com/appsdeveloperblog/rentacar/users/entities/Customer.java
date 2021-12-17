package com.appsdeveloperblog.rentacar.users.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "customers")
public class Customer extends User {

}
