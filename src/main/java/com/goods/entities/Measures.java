package com.goods.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "measures")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Measures implements java.io.Serializable {

    @SequenceGenerator(name = "seq_measures", sequenceName = "seq_measures")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_measures")
    @Column(name = "measureid", unique = true, nullable = false)
    private Integer measureId;
    @Column(name = "measurename", nullable = false, length = 50)
    private String measureName;

    public Measures(String measureName) {
        this.measureName = measureName;
    }
}
