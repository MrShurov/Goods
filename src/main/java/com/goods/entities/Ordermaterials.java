package com.goods.entities;
// Generated by Hibernate Tools 4.3.1


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Ordermaterials generated by hbm2java
 */
@Entity
@Table(name = "ordermaterials")
@AllArgsConstructor
@NoArgsConstructor
public class Ordermaterials implements java.io.Serializable {


    private Integer ordermaterialsid;
    private Goodslist goodslist;
    private Materials materials;
    private String koefficient;
    private double price;
    private double total;

    @SequenceGenerator(name = "seq_ordermaterials", sequenceName = "seq_ordermaterials")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_ordermaterials")
    @Column(name = "ordermaterialsid", unique = true, nullable = false)
    public Integer getOrdermaterialsid() {
        return this.ordermaterialsid;
    }

    public void setOrdermaterialsid(Integer ordermaterialsid) {
        this.ordermaterialsid = ordermaterialsid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodslistid")
    public Goodslist getGoodslist() {
        return this.goodslist;
    }

    public void setGoodslist(Goodslist goodslist) {
        this.goodslist = goodslist;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materialid")
    public Materials getMaterials() {
        return this.materials;
    }

    public void setMaterials(Materials materials) {
        this.materials = materials;
    }

    @Column(name = "koefficient", nullable = false, length = 50)
    public String getKoefficient() {
        return this.koefficient;
    }

    public void setKoefficient(String koefficient) {
        this.koefficient = koefficient;
    }

    @Column(name = "price", nullable = false, precision = 17, scale = 17)
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "total", nullable = false, precision = 17, scale = 17)
    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}
