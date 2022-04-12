package com.marsh.iStore.entity;

import lombok.Data;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity{
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    @Override
    public String toString(){
        return "Role{" + "id=" + super.getId() + '\'' + "name=" + name + '\'' + '}';
    }
}
