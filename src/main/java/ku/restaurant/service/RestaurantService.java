package ku.restaurant.service;

import ku.restaurant.dto.RestaurantRequest;
import ku.restaurant.entity.Restaurant;
import ku.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import java.time.Instant;
import java.util.List;
import java.util.UUID;


@Service
public class RestaurantService {


    private RestaurantRepository repository;


    @Autowired
    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    public Page<Restaurant> getRestaurantsPage(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    public Restaurant getRestaurantById(UUID id) {
        return repository.findById(id).get();
    }

    public Restaurant create(RestaurantRequest request) {
        Restaurant dao = new Restaurant();
        dao.setName(request.getName());
        dao.setLocation(request.getLocation());
        dao.setRating(request.getRating());

        dao.setCreatedAt(Instant.now());
        Restaurant record = repository.save(dao);
        return record;
    }

    public Restaurant update(RestaurantRequest requestBody) {
        Restaurant dao = new Restaurant();
        dao.setName(requestBody.getName());
        dao.setLocation(requestBody.getLocation());
        dao.setRating(requestBody.getRating());

        UUID id = dao.getId();
        Restaurant record = repository.findById(id).get();
        record.setName(requestBody.getName());
        record.setRating(requestBody.getRating());
        record.setLocation(requestBody.getLocation());

        record = repository.save(record);
        return record;
    }

    public Restaurant delete(UUID id) {
        Restaurant record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }

    public List<Restaurant> getRestaurantByName(String name) {
        return repository.findByName(name);
    }

    public List<Restaurant> getRestaurantByLocation(String location) {
        return repository.findByLocation(location);
    }
}
