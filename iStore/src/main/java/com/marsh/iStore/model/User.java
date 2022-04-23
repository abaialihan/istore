package com.marsh.iStore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users",  indexes ={ @Index(name = "IDX_MYIDX1", columnList = "login,password") })
@Data
public class User extends BaseEntity{

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "active")
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User() {
    }

    public User(String login, String password, String firstname, String lastname, boolean active, Set<Role> roles) {
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.active = active;
        this.roles = roles;
    }
}
