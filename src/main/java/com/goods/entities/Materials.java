package com.goods.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

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
    @Column(name = "price", nullable = false, precision = 17, scale = 17)
    private double price;
}
