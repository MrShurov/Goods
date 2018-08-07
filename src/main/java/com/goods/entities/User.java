package com.goods.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements java.io.Serializable {

    @SequenceGenerator(name = "seq_user", sequenceName = "seq_user")
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_user")
    @Column(name = "userid", unique = true, nullable = false)
    private Integer userid;
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
    @Column(name = "companyname", length = 100)
    private String companyName;
    @Column(name = "postcode", length = 6)
    private String postCode;
    @Column(name = "paymentaccount", length = 50)
    private String paymentAccount;
    @Column(name = "bankrequisites", length = 1000)
    private String bankRequisites;
    @Column(name = "unp", length = 100)
    private String unp;
    @Column(name = "tel")
    private String tel;

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}