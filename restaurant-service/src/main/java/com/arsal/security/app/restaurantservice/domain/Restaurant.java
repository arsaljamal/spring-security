package com.arsal.security.app.restaurantservice.domain;

import com.arsal.security.app.restaurantservice.web.RestaurantDto;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REST_ID")
    private long id;

    @Column(name = "REST_NAME")
    private String name;

    @Column(name = "REST_ADDRESS")
    private String address;

    @Column(name = "REST_LOCATION")
    private String location;

    public Restaurant(String name, String address, String location) {
        this.name = name;
        this.address = address;
        this.location = location;
    }

    public Restaurant() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
}
