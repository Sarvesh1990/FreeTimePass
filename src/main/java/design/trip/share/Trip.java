package design.trip.share;

import design.trip.share.cars.Car;
import design.trip.share.people.People;

public class Trip {
    private final int startIndex;
    private final int endIndex;
    private final Car car;
    private final People owner;
    private String status;
    private int moneyEarned;



    public Trip(int startIndex, int endIndex, Car car, People owner) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.car = car;
        this.owner = owner;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public Car getCar() {
        return car;
    }

    public String getStatus() {
        return status;
    }

    public int getMoneyEarned() {
        return moneyEarned;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMoneyEarned(int moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public People getOwner() {
        return owner;
    }
}
