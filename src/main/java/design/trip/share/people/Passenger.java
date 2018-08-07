package design.trip.share.people;

import design.trip.share.Token;

public class Passenger extends People{
    private final Token token;

    public Passenger(String name, String email, Token token) {
        super(name, email);
        this.token = token;
    }

    public Token getToken() {
        return token;
    }
}
