package com.arsal.security.app.restaurantservice.web;

import com.arsal.security.app.restaurantservice.domain.Restaurant;
import com.arsal.security.app.restaurantservice.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return restaurantService.addRestaurant(restaurantDto);
    }

    @PutMapping(path = "/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody RestaurantDto restaurantDto) {
        return restaurantService.updateRestaurant(id, restaurantDto);
    }

    @DeleteMapping(path = "/{id}/")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }

    @GetMapping(path = "/get/{restId}/")
    public Restaurant getRestaurant(@PathVariable(value = "restId") Long restId) {
        return restaurantService.getRestaurant(restId).
                orElseThrow(() -> new NoSuchElementException("No such Restaurant!"));
    }

    @GetMapping(path = "/list")
    public List<Restaurant> getAllRestaurant() {
        return restaurantService.getAllRestaurant();
    }

}
