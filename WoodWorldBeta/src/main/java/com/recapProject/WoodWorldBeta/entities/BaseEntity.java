package com.recapProject.WoodWorldBeta.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class BaseEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "cdate")
    private Date createDate;
    @Column(name = "udate")
    private Date updateDate;
    @Column(name = "ddate")
    private Date deleteDate;
    @Column(name = "status")
    private boolean isActive;

}
