package com.goods.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Orders implements java.io.Serializable {

    @SequenceGenerator(name = "seq_orders", sequenceName = "seq_orders")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_orders")
    @Column(name = "orderid", unique = true, nullable = false)
    private Integer orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createby")
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdate", length = 29)
    private Date createDate;

    public Orders(User user) {
        this.user = user;
        this.createDate = new Date();
    }
}
