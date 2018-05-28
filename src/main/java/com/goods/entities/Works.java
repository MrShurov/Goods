package com.goods.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
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

@Entity
@Table(name = "works")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Works implements java.io.Serializable {

    @SequenceGenerator(name = "seq_works", sequenceName = "seq_works")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_works")
    @Column(name = "workid", unique = true, nullable = false)
    private Integer workId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodid")
    private Goods goods;
    @Column(name = "workname", nullable = false, length = 50)
    private String workName;
    @Column(name = "norma", nullable = false, precision = 17, scale = 17)
    private double norma;
    @Column(name = "count", nullable = false)
    private int count;

    public Works(Goods goods, String workName, double norma, int count) {
        this.goods = goods;
        this.workName = workName;
        this.norma = norma;
        this.count = count;
    }
}
