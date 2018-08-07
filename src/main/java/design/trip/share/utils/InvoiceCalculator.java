package design.trip.share.utils;

import design.trip.share.Invoice;
import design.trip.share.Token;
import design.trip.share.cars.Car;
import design.trip.share.people.Passenger;

public class InvoiceCalculator {
    public static Invoice generateInvoice(Token token, Passenger passenger, Car car) {
        int moneyToBePaid = (token.endKm - token.startKm) * car.getCostPerKM();
        return new Invoice(passenger, token.startKm, token.endKm, moneyToBePaid, car);
    }
}
