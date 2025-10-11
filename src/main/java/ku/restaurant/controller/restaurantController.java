package ku.restaurant.controller;

import ku.restaurant.entity.Restaurant;
import ku.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class restaurantController {
    private RestaurantService service;

    @Autowired
    public restaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurant() {
        return service.getAll();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant getRestaurantById(@PathVariable UUID id) {
        return service.getRestaurantById(id);
    }

    @PostMapping("/restaurants")
    public Restaurant create(@RequestBody Restaurant restaurant) {
        return service.create(restaurant);
    }

    @PutMapping("/restaurants")
    public Restaurant update(@RequestBody Restaurant restaurant) {
        return service.update(restaurant);
    }

    @DeleteMapping("/restaurants/{id}")
    public Restaurant delete(@PathVariable UUID id) {
        return service.delete(id);
    }

    @GetMapping("/restaurants/name/{name}")
    public Restaurant getRestaurantByName(@PathVariable String name) {
        return service.getRestaurantByName(name);
    }

    @GetMapping("/restaurants/location/{location}")
    public List<Restaurant> getRestaurantByLocation(@PathVariable String location) {
        return service.getRestaurantByLocation(location);
    }
}
