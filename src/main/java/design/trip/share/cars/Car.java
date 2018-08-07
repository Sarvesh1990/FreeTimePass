package design.trip.share.cars;

public abstract class Car {
    private final String name;
    private final int costPerKM;
    private final int capacity;

    public Car(String name, int costPerKM, int capacity) {
        this.name = name;
        this.costPerKM = costPerKM;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCostPerKM() {
        return costPerKM;
    }

    public int getCapacity() {
        return capacity;
    }
}
