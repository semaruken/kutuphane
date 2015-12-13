/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.kutuphane.semaruken.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vektorel
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    private String ctrr;
    private Date crtm;
    private String updtr;
    private Date updtm;

    @Column(name = "crtr", length = 100)
    public String getCtrr() {
        return ctrr;
    }

    public void setCtrr(String ctrr) {
        this.ctrr = ctrr;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "crtm")
    public Date getCrtm() {
        return crtm;
    }

    public void setCrtm(Date crtm) {
        this.crtm = crtm;
    }

    @Column(name = "updtr", length = 100)
    public String getUpdtr() {
        return updtr;
    }

    public void setUpdtr(String updtr) {
        this.updtr = updtr;
    }
@Temporal(TemporalType.TIMESTAMP)
@Column(name="updtm")
    public Date getUpdtm() {
        return updtm;
    }

    public void setUpdtm(Date updtm) {
        this.updtm = updtm;
    }

  
}
