package com.marsh.iStore.repository;

import com.marsh.iStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
