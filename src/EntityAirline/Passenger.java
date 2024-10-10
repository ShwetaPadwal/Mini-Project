package EntityAirline;

public class Passenger {
    private String name;
    private String contact;

    public Passenger(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Passenger: " + name + " (Contact: " + contact + ")";
    }
}
