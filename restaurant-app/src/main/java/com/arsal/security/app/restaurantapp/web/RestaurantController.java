package com.arsal.security.app.restaurantapp.web;

import com.arsal.security.app.restaurantapp.dto.Restaurant;
import com.arsal.security.app.restaurantapp.dto.RestaurantDto;
import com.arsal.security.app.restaurantapp.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping(value = {"/","/index"})
    public String getHomePage(Model model) {
        return "index";
    }

    @GetMapping(value = "/restaurant")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getRestaurants(Model model) {
        List<Restaurant> restaurantList = restaurantService.getAllRestaurant();
        model.addAttribute("restaurants" , restaurantList);
        return "restaurants-view";
    }

    @GetMapping(value = "/restaurant/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addRestaurantForm(Model model) {
        return "restaurant-view";
    }

    @PostMapping(value = "/restaurant")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView addRestaurant(HttpServletRequest httpServletRequest, Model model, @ModelAttribute RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantService.addRestaurant(restaurantDto);
        model.addAttribute("restaurant" , restaurant);
        httpServletRequest.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return new ModelAndView("redirect:/restaurant/" + restaurant.getId());
    }

    @GetMapping(value = "/restaurant/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getRestaurant(Model model, @PathVariable long id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);
        model.addAttribute("restaurant", restaurant);
        return "restaurant-view";
    }

    @PostMapping(value = "/restaurant/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateRestaurant(Model model, @PathVariable long id, @ModelAttribute RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantService.updateRestaurant(id, restaurantDto);
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("restaurantDto", new RestaurantDto());
        return "restaurant-view";
    }
}
