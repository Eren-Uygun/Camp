package com.bestpractiseworkshop.recap2.entities.abstracts;

import java.time.LocalDateTime;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseEntity {

    private LocalDateTime cDate;
    private LocalDateTime uDate;
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
