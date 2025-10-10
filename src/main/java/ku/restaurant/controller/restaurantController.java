package ku.restaurant.controller;

import ku.restaurant.entity.Restaurant;
import ku.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class restaurantController {
    private RestaurantService service;

    @Autowired
    public restaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping("/restaurant")
    public List<Restaurant> getAllRestaurant() {
        return service.getAll();
    }

    @PostMapping("/restaurant")
    public Restaurant create(@RequestBody Restaurant restaurant) {
        return service.create(restaurant);
    }
}
