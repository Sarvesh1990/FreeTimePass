package design.trip.share;

import design.trip.share.cars.Car;
import design.trip.share.cars.Dzire;
import design.trip.share.cars.Innova;
import design.trip.share.people.Owner;
import design.trip.share.people.Passenger;
import design.trip.share.people.People;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Car innova = new Innova("Innova", 15, 2);
        Car dzire = new Dzire("Dzire", 12, 4);

        People owner = new Owner("Sarvesh", "sarveshiitb@gmail.com", new LinkedList<Car>(){
            {
                add(innova);
                add(dzire);
            }
        });

        Trip trip = new Trip(2, 15, innova, owner);

        Ride ride = new Ride(trip);

        Token token1 = ride.addPassenger("Ramesh", "ramesh@gmail.com", 3);
        Token token2 = ride.addPassenger("Ramesh1", "ramesh@gmail.com", 17);
        Token token3 = ride.addPassenger("Ramesh", "ramesh1@gmail.com", 7);
        ride.removePassenger(token2, 9);
        Token token4 = ride.addPassenger("Ramesh2", "ramesh2@gmail.com", 12);
        ride.removePassenger(token1, 9);
        ride.removePassenger(token4, 13);
        Token token5 = ride.addPassenger("Ramesh3", "ramesh3@gmail.com", 11);
        ride.removePassenger(token3, 13);
        ride.removePassenger(token5, 14);

        System.out.println(trip.getMoneyEarned());

        for(Invoice invoice : ride.invoiceList) {
            System.out.println(invoice.startIndex + " " + invoice.endIndex + " " + invoice.passenger.getEmail() + " " + invoice.moneyToBePaid);
        }
    }
}
