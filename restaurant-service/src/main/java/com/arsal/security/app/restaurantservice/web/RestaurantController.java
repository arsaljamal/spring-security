package com.arsal.security.app.restaurantservice.web;

import com.arsal.security.app.restaurantservice.domain.Restaurant;
import com.arsal.security.app.restaurantservice.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return restaurantService.addRestaurant(restaurantDto);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody RestaurantDto restaurantDto) {
        return restaurantService.updateRestaurant(id, restaurantDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteRestaurant(Long id) {
        restaurantService.deleteRestaurant(id);
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        return restaurantService.getRestaurant(id).
                orElseThrow(() -> new NoSuchElementException("No such Restaurant!"));
    }

    @GetMapping
    public List<Restaurant> getAllRestaurant() {
        return restaurantService.getAllRestaurant();
    }

}
