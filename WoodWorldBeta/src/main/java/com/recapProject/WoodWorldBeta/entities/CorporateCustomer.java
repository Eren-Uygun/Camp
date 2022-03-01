package com.recapProject.WoodWorldBeta.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "corporate_customers")
public class CorporateCustomer extends Customer {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "corporate_tax_number",unique = true)
    private String taxtNumber;

    @Column(name = "organization_create_date")
    private Date organizationCreateDate;

    //Organization Type Enumla seçilebilir !!!! Siyasi parti , Vakıf , Belediye  , gibi

}
