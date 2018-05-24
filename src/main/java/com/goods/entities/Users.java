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
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users implements java.io.Serializable {

    @SequenceGenerator(name = "seq_user", sequenceName = "seq_user")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_user")
    @Column(name = "userid", unique = true, nullable = false)
    private Integer userid;
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Column(name = "password", nullable = false, length = 20)
    private String password;
}
