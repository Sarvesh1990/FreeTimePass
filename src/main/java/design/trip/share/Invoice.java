package design.trip.share;

import design.trip.share.cars.Car;
import design.trip.share.people.People;

public class Invoice {
    public final People passenger;
    public final int startIndex;
    public final int endIndex;
    public final int moneyToBePaid;
    public final Car car;

    public Invoice(People passenger, int startIndex, int endIndex, int moneyToBePaid, Car car) {
        this.passenger = passenger;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.moneyToBePaid = moneyToBePaid;
        this.car = car;
    }
}
