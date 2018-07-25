package com.goods.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "goodslist")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Goodslist implements java.io.Serializable {

    @SequenceGenerator(name = "seq_goodlist", sequenceName = "seq_goodlist")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_goodlist")
    @Column(name = "goodslistid", unique = true, nullable = false)
    private Integer goodsListId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodid")
    private Goods goods;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderid")
    private Orders orders;
    @Column(name = "count", nullable = false)
    private int count;
    @Column(name = "length", length = 50)
    private Double length;
    @Column(name = "width", length = 50)
    private Double width;
    @Column(name = "height", length = 50)
    private Double height;
    @Column(name = "depth", length = 50)
    private Double depth;

    public Goodslist(Goods goods, Orders orders, int count, Double length, Double width, Double height, Double depth) {
        this.goods = goods;
        this.orders = orders;
        this.count = count;
        this.length = length;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
}
