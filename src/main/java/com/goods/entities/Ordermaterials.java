package com.goods.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "ordermaterials")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    private Double koefficient;
    @Column(name = "price", nullable = false, precision = 17, scale = 17)
    private double price;
    @Column(name = "total", nullable = false, precision = 17, scale = 17)
    private double total;

    public Ordermaterials(Goodslist goodsList, Materials materials, Double koefficient, double price, double total) {
        this.goodsList = goodsList;
        this.materials = materials;
        this.koefficient = koefficient;
        this.price = price;
        this.total = total;
    }
}
