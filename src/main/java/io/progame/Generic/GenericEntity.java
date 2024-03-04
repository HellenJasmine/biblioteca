/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.progame.Generic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.MappedSuperclass;
import javax.persistence.*;

/**
 *
 * @author Cliente
 */
@MappedSuperclass
public abstract class GenericEntity implements Serializable {
    private Boolean active;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date RegistrationDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateUpdated;
    
    public GenericEntity(){
        active = Boolean.TRUE;
        setRegistrationDate(new Date());
    }
    

    public Boolean getActive() {
        return active;
    }
    

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(Date RegistrationDate) {
        this.RegistrationDate = RegistrationDate;
    }
    
    public Date getDateUpdated() {
        return DateUpdated;
    }

    public void setDateUpdated(Date DateUpdated) {
        this.DateUpdated = DateUpdated;
    }
    
    
}
