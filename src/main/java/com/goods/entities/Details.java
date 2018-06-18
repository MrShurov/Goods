package com.goods.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "details")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Details implements java.io.Serializable {

    @SequenceGenerator(name = "seq_details", sequenceName = "seq_details", initialValue = 1)
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_details")
    @Column(name = "detailid", unique = true, nullable = false)
    private Integer detailId;
    @Column(name = "detailname", nullable = false, length = 50)
    private String detailName;
    @Column(name = "price", nullable = false, precision = 17, scale = 17)
    private double price;

    public Details(String detailName, double price) {
        this.detailName = detailName;
        this.price = price;
    }
}
