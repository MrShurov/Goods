package com.goods.entities;
// Generated by Hibernate Tools 4.3.1


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Measures generated by hbm2java
 */
@Entity
@Table(name = "measures")
@AllArgsConstructor
@NoArgsConstructor
public class Measures implements java.io.Serializable {


    private Integer measureid;
    private String measurename;

    @SequenceGenerator(name = "seq_measures", sequenceName = "seq_measures")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_measures")
    @Column(name = "measureid", unique = true, nullable = false)
    public Integer getMeasureid() {
        return this.measureid;
    }

    public void setMeasureid(Integer measureid) {
        this.measureid = measureid;
    }

    @Column(name = "measurename", nullable = false, length = 50)
    public String getMeasurename() {
        return this.measurename;
    }

    public void setMeasurename(String measurename) {
        this.measurename = measurename;
    }


}