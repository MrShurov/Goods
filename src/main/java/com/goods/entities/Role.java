package com.goods.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role implements java.io.Serializable {

    @SequenceGenerator(name = "seq_role", sequenceName = "seq_role")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_role")
    @Column(name = "role_id")
    private int id;
    @Column(name = "role")
    private String role;
}
