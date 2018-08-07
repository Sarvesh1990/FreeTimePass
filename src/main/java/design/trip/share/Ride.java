package design.trip.share;

import design.trip.share.people.Owner;
import design.trip.share.people.Passenger;
import design.trip.share.people.People;
import design.trip.share.utils.InvoiceCalculator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Ride {
    public final Trip trip;
    public final List<Invoice> invoiceList;
    public final Map<Token, People> passengerMap;


    public Ride(Trip trip) {
        this.trip = trip;
        ((Owner)trip.getOwner()).getTrips().add(trip);
        this.invoiceList = new LinkedList<>();
        this.passengerMap = new HashMap<>();
    }

    public Token addPassenger(String name, String email, int startKm) {
        if(trip.getCar().getCapacity() > passengerMap.size() && startKm >= trip.getStartIndex() && startKm <= trip.getEndIndex()) {
            Token token = new Token(startKm);
            Passenger passenger = new Passenger(name, email, token);
            passengerMap.put(token, passenger);
            return token;
           } else {
            return null;
        }

    }

    public void removePassenger(Token token, int endKm) {
        if(token == null) {
            System.out.println("Passenger was never added");
        } else {
            token.endKm = endKm;
            Invoice invoice = InvoiceCalculator.generateInvoice(token, (Passenger) passengerMap.get(token), trip.getCar());
            invoiceList.add(invoice);
            passengerMap.remove(token);
            trip.setMoneyEarned(trip.getMoneyEarned() + invoice.moneyToBePaid);
        }
    }
}
