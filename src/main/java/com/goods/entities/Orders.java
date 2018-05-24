package com.goods.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders implements java.io.Serializable {

    @SequenceGenerator(name = "seq_orders", sequenceName = "seq_orders")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_orders")
    @Column(name = "orderid", unique = true, nullable = false)
    private Integer orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createby")
    private Users users;
    @Column(name = "ordernunber", length = 20)
    private String orderNunber;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdate", length = 29)
    private Date createDate;
}
