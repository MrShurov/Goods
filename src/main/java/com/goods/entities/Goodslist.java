package com.goods.entities;

import com.goods.entities.Goods;

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
import com.goods.entities.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "goodslist")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
    private String length;
    @Column(name = "width", length = 50)
    private String width;
    @Column(name = "height", length = 50)
    private String height;
    @Column(name = "depth", length = 50)
    private String depth;
}
