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
 * Materials generated by hbm2java
 */
@Entity
@Table(name = "materials")
@AllArgsConstructor
@NoArgsConstructor
public class Materials implements java.io.Serializable {


    private Integer materialid;
    private Goods goods;
    private Measures measures;
    private String materialname;
    private Boolean mandatory;
    private String formula;
    private double price;

    @SequenceGenerator(name = "seq_materials", sequenceName = "seq_materials")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_materials")
    @Column(name = "materialid", unique = true, nullable = false)
    public Integer getMaterialid() {
        return this.materialid;
    }

    public void setMaterialid(Integer materialid) {
        this.materialid = materialid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodid", nullable = false)
    public Goods getGoods() {
        return this.goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measureid", nullable = false)
    public Measures getMeasures() {
        return this.measures;
    }

    public void setMeasures(Measures measures) {
        this.measures = measures;
    }

    @Column(name = "materialname", nullable = false, length = 100)
    public String getMaterialname() {
        return this.materialname;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }

    @Column(name = "mandatory", nullable = false)
    public Boolean getMandatory() {
        return this.mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    @Column(name = "formula", length = 500)
    public String getFormula() {
        return this.formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    @Column(name = "price", nullable = false, precision = 17, scale = 17)
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
