package com.etiya.ReCapProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "rent_date")
    private LocalDate rentDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @Column(name = "return_city_id")
    private int returnCityId;

    @Column(name = "rented_city_id")
    private int rentedCityId;

    @Column(name = "rented_kilometer")
    private int rentedKilometer;

    @Column(name = "returned_kilometer")
    private int returnedKilometer;
}
