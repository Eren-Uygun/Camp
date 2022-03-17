package com.bestpractiseworkshop.recap2.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="genders")
public class Gender {
    
    @Id
    @Column(name="id")
    private String genderId;
    
    @Column(name="gender_name")
    private String genderName;

    @Column(name="gender_description")
    private String genderDescription;
}
