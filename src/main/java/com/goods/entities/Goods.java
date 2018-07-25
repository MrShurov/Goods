package com.goods.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "goods")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
