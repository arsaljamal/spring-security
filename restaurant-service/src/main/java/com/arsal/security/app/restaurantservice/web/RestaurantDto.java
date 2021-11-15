package com.arsal.security.app.restaurantservice.web;


import com.arsal.security.app.restaurantservice.domain.Restaurant;

public class RestaurantDto {

    private String name;

    private String address;

    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Restaurant translateDtoToRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(this.name);
        restaurant.setAddress(this.address);
        restaurant.setLocation(this.location);
        return restaurant;
    }
}
