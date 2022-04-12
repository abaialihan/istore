package com.marsh.iStore.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity{

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "")
    private Date date_of_birth;

    @Column(name = "avatar")
    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id",
                    referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id",
                    referencedColumnName = "id")})
    private List<Role> roles;

    public User() {
    }

    public User(String login,
                String password,
                String name,
                String surname,
                String email,
                Date date_of_birth,
                String avatar,
                List<Role> roles)
    {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.avatar = avatar;
        this.roles = roles;
    }
}
