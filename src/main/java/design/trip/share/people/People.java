package design.trip.share.people;

public abstract class People {
    private final String name;
    private final String email;

    public People(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
