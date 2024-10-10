package TestVehicle;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import EntityVehicle.*;
import Exception.InvalidVehicleException;
import ServiceVehicle.*;

public class TestVehicle{
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        RentalService rentalService = new RentalService();

        try {
            // Ask how many rentals to create
            System.out.print("How many rentals do you want to create? ");
            int numberOfRentals = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numberOfRentals; i++) {
                System.out.println("\n--- Rental " + (i + 1) + " ---");

                // Get customer details
                System.out.print("Enter your name: ");
                String name = reader.readLine();
                System.out.print("Enter your email: ");
                String email = reader.readLine();
                Customer customer = new Customer(name, email);

                // Get vehicle details
                System.out.print("Enter vehicle make: ");
                String vehicleMake = reader.readLine();
                System.out.print("Enter vehicle model: ");
                String vehicleModel = reader.readLine();
                System.out.print("Enter vehicle license plate: ");
                String licensePlate = reader.readLine();
                Vehicle vehicle = new Vehicle(vehicleMake, vehicleModel, licensePlate);

                // Get rental days and daily rate
                System.out.print("Enter rental days: ");
                int rentalDays = Integer.parseInt(reader.readLine());
                System.out.print("Enter daily rental rate: ");
                double dailyRate = Double.parseDouble(reader.readLine());

                // Create and add rental to RentalService
                Rental rental = new Rental(customer, vehicle, rentalDays, dailyRate);
                rentalService.addRental(rental);

                // Display rental details
                rental.displayRentalDetails();
            }

            // Save all rentals to file
            rentalService.saveAllRentalsToFile("rentals.txt");

            // Display all rentals
            rentalService.displayAllRentals();

        } catch (InvalidVehicleException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: Please enter numeric values for rental days and daily rate.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
