package com.goods.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "goods")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Goods implements java.io.Serializable {

    @SequenceGenerator(name = "seq_goods", sequenceName = "seq_goods", initialValue = 1)
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_goods")
    @Column(name = "goodid", unique = true, nullable = false)
    private Integer goodId;
    @Column(name = "goodname", nullable = false, length = 100)
    private String goodName;

    public Goods(String goodname) {
        this.goodName = goodname;
    }
}
