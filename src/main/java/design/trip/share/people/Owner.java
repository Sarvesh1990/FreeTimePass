package design.trip.share.people;

import design.trip.share.Trip;
import design.trip.share.cars.Car;

import java.util.LinkedList;
import java.util.List;

public class Owner extends People {
    private final List<Car> cars;
    private final List<Trip> trips;

    public Owner(String name, String email, List<Car> cars) {
        super(name, email);
        this.cars = cars;
        this.trips = new LinkedList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Trip> getTrips() {
        return trips;
    }
}
