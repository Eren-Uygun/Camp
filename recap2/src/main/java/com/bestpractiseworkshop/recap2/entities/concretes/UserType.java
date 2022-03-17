package com.bestpractiseworkshop.recap2.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bestpractiseworkshop.recap2.entities.abstracts.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_types")
public class UserType extends BaseEntity {

    @Id
    @Column(name = "user_type_id")
    private String userTypeId;

    @Column(name = "user_type",unique = true)
    private String userType;

    @Column(name = "description")
    private String description;

    @Column(name = "short_code")
    private String shortCode;

    @OneToOne(mappedBy = "type",fetch = FetchType.LAZY)
    private UserTypeRel userTypeRel;
    
}
