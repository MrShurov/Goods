package com.goods.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "materials")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Materials implements java.io.Serializable {

    @SequenceGenerator(name = "seq_materials", sequenceName = "seq_materials")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_materials")
    @Column(name = "materialid", unique = true, nullable = false)
    private Integer materialId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodid", nullable = false)
    private Goods goods;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measureid", nullable = false)
    private Measures measures;
    @Column(name = "materialname", nullable = false, length = 100)
    private String materialName;
    @Column(name = "mandatory", nullable = false)
    private Boolean mandatory;
    @Column(name = "formula", length = 500)
    private String formula;
    @Column(name = "price", nullable = false, precision = 17, scale = 17)
    private double price;
}
