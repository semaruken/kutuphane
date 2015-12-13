/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.kutuphane.semaruken.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vektorel
 */
@Entity
@Table(name = "LIB_BOOK")
public class Kitap extends BaseEntity {

    private Long id;
    private String kitapAdi;
    private String isbn;
    private String yazar;
    private Integer sayfaSayisi;
    private Date basimTarihi;

    @Id
    @SequenceGenerator(name = "SEQ_BOOK_ID", sequenceName = "SEQ_BOOK_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOOK_ID")
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME", length = 150)
    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    @Column(name = "ISBN", length = 50)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "AUTHOR", length = 200)
    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    @Column(name = "PAGE_NUMBER")
    public Integer getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(Integer sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "PUBLISH_DATE")
    public Date getBasimTarihi() {
        return basimTarihi;
    }

    public void setBasimTarihi(Date basimTarihi) {
        this.basimTarihi = basimTarihi;
    }
}
