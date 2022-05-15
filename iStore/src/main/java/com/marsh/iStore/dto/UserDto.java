package com.marsh.iStore.dto;

import com.marsh.iStore.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private boolean active;
    private Set<Role> roles;

    public UserDto() {
    }

    public UserDto(String username, String password, String firstname, String lastname, boolean active, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.active = active;
        this.roles = roles;
    }
}
