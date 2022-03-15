package com.bestpractiseworkshop.recap2.entities.abstracts;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseEntity {

    @Column(name = "c_date")
    @JoinColumn(name = "c_date")
    private LocalDateTime cDate;
    
    @Column(name = "u_date")
    @JoinColumn(name = "u_date")
    private LocalDateTime uDate;

    @Column(name = "is_actv")
    @JoinColumn(name = "is_actv")
    private boolean isActv;
    
    public LocalDateTime getcDate() {
        return cDate;
    }

    public void setcDate(LocalDateTime cDate) {
        cDate = LocalDateTime.now();
        this.cDate = cDate;
    }

    public void setActv(boolean isActv) {
        isActv = true;
        this.isActv = isActv;
    }
}

//Status için ayrı bi class sistemi yazılabilir ? 
// id,status, vs....
