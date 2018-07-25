package com.goods.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "measures")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
