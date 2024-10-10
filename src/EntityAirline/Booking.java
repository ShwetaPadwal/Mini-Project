package EntityAirline;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Passenger passenger;
    private Flight flight;

    public Booking(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    public double getTotalPrice() {
        return flight.getPrice();
    }

    public void saveBookingToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\DELL\\Desktop\\CDAC\\Airline.txt", true))) {
            writer.write(passenger.toString());
            writer.newLine();
            writer.write(flight.toString());
            writer.newLine();
            writer.write("Total Price: $" + getTotalPrice());
            writer.newLine();
            writer.write("-------------------------");
            writer.newLine();
            System.out.println("Booking saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving booking: " + e.getMessage());
        }
    }

    public void displayBookingDetails() {
        System.out.println("Booking Details:");
        System.out.println(passenger);
        System.out.println(flight);
        System.out.println("Total Price: $" + getTotalPrice());
    }
}

