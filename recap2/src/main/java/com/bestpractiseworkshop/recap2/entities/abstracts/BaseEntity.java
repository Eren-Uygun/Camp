package com.bestpractiseworkshop.recap2.entities.abstracts;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BaseEntity {

    @Id
    private String id;

    private OffsetDateTime createDate;

    private OffsetDateTime updateDate;

    private LocalDateTime deleteDate;

    @Column(name = "status")
    private boolean isActive;


    
}
