package ku.restaurant.dto;

public class RestaurantRequest {
    private String name;
    private double rating;

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String location;

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public String getLocation() {
        return location;
    }
}
