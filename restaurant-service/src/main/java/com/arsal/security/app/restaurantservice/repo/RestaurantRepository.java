package com.arsal.security.app.restaurantservice.repo;

import com.arsal.security.app.restaurantservice.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
