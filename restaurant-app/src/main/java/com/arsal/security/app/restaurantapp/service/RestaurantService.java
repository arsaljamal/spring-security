package com.arsal.security.app.restaurantapp.service;


import com.arsal.security.app.restaurantapp.dto.Restaurant;
import com.arsal.security.app.restaurantapp.dto.RestaurantDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestaurantService {

    private static final String RESTAURANT = "/restaurant";

    @Value("${restaurant.service.url}")
    private String restaurantServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Restaurant addRestaurant(RestaurantDto restaurantDto) {
        String url = restaurantServiceUrl + RESTAURANT;
        HttpEntity<Restaurant> request = new HttpEntity(restaurantDto, null);
        return this.restTemplate.exchange(url, HttpMethod.POST, request, Restaurant.class).getBody();
    }

    public Restaurant updateRestaurant(long id, RestaurantDto restaurantDto) {
        String url = restaurantServiceUrl + RESTAURANT + "/" + id;
        HttpEntity<Restaurant> request = new HttpEntity(restaurantDto, null);
        return this.restTemplate.exchange(url, HttpMethod.PUT, request, Restaurant.class).getBody();
    }

    public void deleteRestaurant(long id) {
        String url = restaurantServiceUrl + RESTAURANT + "/"+ id + "/";
        HttpEntity<String> request = new HttpEntity<>(null, null);
        this.restTemplate.exchange(url, HttpMethod.DELETE, request, Restaurant.class).getBody();
    }

    public Restaurant getRestaurant(long id) {
        String url = restaurantServiceUrl + RESTAURANT + "/get/" + id + "/";
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, Restaurant.class).getBody();
    }

    public List<Restaurant> getAllRestaurant() {
        String url = restaurantServiceUrl + RESTAURANT + "/list";
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request,
                new ParameterizedTypeReference<List<Restaurant>>() {}).getBody();
    }
}
