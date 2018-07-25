package com.goods.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "works")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Works implements java.io.Serializable {

    @SequenceGenerator(name = "seq_works", sequenceName = "seq_works")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_works")
    @Column(name = "workid", unique = true, nullable = false)
    private Integer workId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodid")
    private Goods goods;
    @Column(name = "workname", nullable = false, length = 50)
    private String workName;
    @Column(name = "count", nullable = false)
    private int count;

    public Works(Goods goods, String workName, int count) {
        this.goods = goods;
        this.workName = workName;
        this.count = count;
    }
}
