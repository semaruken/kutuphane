/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.kutuphane.semaruken.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vektorel
 */
@Entity
@Table(name = "LIB_BOOK_BORROW")
public class KisiOdunc extends BaseEntity {

    private Long id;
    private Kisi kisi;
    private Kitap kitap;
    private Date alisTarihi;
    private Date teslimTarihi;
    private Boolean teslimAlindi;

    @Id
    @SequenceGenerator(name = "SEQ_BOOK_BORROW_ID", sequenceName = "SEQ_BOOK_BORROW_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOOK_BORROW_ID")
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey =
    @ForeignKey(name = "SEQ_BORROW_PERSON_ID"), name = "PERSON_ID")
    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey =
    @ForeignKey(name = "FK_BORROW_BOOK_ID"), name = "BOOK_ID")
    public Kitap getKitap() {
        return kitap;
    }

    public void setKitap(Kitap kitap) {
        this.kitap = kitap;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BORROW_DATE")
    public Date getAlisTarihi() {
        return alisTarihi;
    }

    public void setAlisTarihi(Date alisTarihi) {
        this.alisTarihi = alisTarihi;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RETURN_DATE")
    public Date getTeslimTarihi() {
        return teslimTarihi;
    }

    public void setTeslimTarihi(Date teslimTarihi) {
        this.teslimTarihi = teslimTarihi;
    }

    @Column(name = "IS_RETURN")
    public Boolean getTeslimAlindi() {
        return teslimAlindi;
    }

    public void setTeslimAlindi(Boolean teslimAlindi) {
        this.teslimAlindi = teslimAlindi;
    }
}
