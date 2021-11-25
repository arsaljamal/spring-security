package com.arsal.security.app.restaurantapp.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {

    List<AuthGroup> findByUserName(String userName);
}
