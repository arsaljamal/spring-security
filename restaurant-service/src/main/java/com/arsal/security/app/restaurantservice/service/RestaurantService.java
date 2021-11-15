package com.arsal.security.app.restaurantservice.service;

import com.arsal.security.app.restaurantservice.domain.Restaurant;
import com.arsal.security.app.restaurantservice.repo.RestaurantRepository;
import com.arsal.security.app.restaurantservice.web.RestaurantDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant addRestaurant(RestaurantDto restaurantDto) {
        return restaurantRepository.save(restaurantDto.translateDtoToRestaurant());
    }

    public Optional<Restaurant> getRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    public Restaurant updateRestaurant(Long id, RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantDto.translateDtoToRestaurant();
        restaurant.setId(id);
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
