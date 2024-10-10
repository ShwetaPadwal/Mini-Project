package EntityVehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Exception.InvalidVehicleException;

public class Rental {
	    private Customer customer;
	    private Vehicle vehicle;
	    private int rentalDays;
	    private double dailyRate;

	    public Rental(Customer customer, Vehicle vehicle, int rentalDays, double dailyRate) throws InvalidVehicleException {
	        if (rentalDays <= 0) {
	            throw new InvalidVehicleException("Rental days must be greater than zero.");
	        }
	        this.customer = customer;
	        this.vehicle = vehicle;
	        this.rentalDays = rentalDays;
	        this.dailyRate = dailyRate;
	    }

	    public double calculateTotalPrice() {
	        return rentalDays * dailyRate;
	    }

	    public void saveRentalToFile(String filename) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\DELL\\Desktop\\CDAC\\Vehicle.txt", true))) {
	            writer.write(customer.toString());
	            writer.newLine();
	            writer.write(vehicle.toString());
	            writer.newLine();
	            writer.write("Rental Days: " + rentalDays);
	            writer.newLine();
	            writer.write("Total Price: $" + calculateTotalPrice());
	            writer.newLine();
	            writer.write("-------------------------");
	            writer.newLine();
	            System.out.println("Rental saved to file: " + filename);
	        } catch (IOException e) {
	            System.out.println("Error saving rental: " + e.getMessage());
	        }
	    }

	    public void displayRentalDetails() {
	        System.out.println("Rental Details:");
	        System.out.println(customer.toString());
	        System.out.println(vehicle.toString());
	        System.out.println("Rental Days: " + rentalDays);
	        System.out.println("Total Price: $" + calculateTotalPrice());
	    }
	}
