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
@Table(name = "ordermaterials")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ordermaterials implements java.io.Serializable {

    @SequenceGenerator(name = "seq_ordermaterials", sequenceName = "seq_ordermaterials")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_ordermaterials")
    @Column(name = "ordermaterialsid", unique = true, nullable = false)
    private Integer orderMaterialsId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodslistid")
    private Goodslist goodsList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materialid")
    private Materials materials;
    @Column(name = "koefficient", nullable = false, length = 50)
    private String koefficient;
    @Column(name = "price", nullable = false, precision = 17, scale = 17)
    private double price;
    @Column(name = "total", nullable = false, precision = 17, scale = 17)
    private double total;
}
