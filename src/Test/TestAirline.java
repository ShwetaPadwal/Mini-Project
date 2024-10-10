package Test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import EntityAirline.*;
import Exception.BookingException;
import ServiceAirline.*;

public class TestAirline {
	

	
	    public static void main(String[] args) {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        BookingService bookingService = new BookingService();

	        try {
	            // Ask how many bookings to create
	            System.out.print("How many bookings do you want to create? ");
	            int numberOfBookings = Integer.parseInt(reader.readLine());

	            for (int i = 0; i < numberOfBookings; i++) {
	                System.out.println("\n--- Booking " + (i + 1) + " ---");

	                // Get passenger details
	                System.out.print("Enter passenger name: ");
	                String passengerName = reader.readLine();
	                System.out.print("Enter passenger contact: ");
	                String passengerContact = reader.readLine();
	                Passenger passenger = new Passenger(passengerName, passengerContact);

	                // Get flight details
	                System.out.print("Enter flight number: ");
	                String flightNumber = reader.readLine();
	                System.out.print("Enter flight destination: ");
	                String flightDestination = reader.readLine();
	                System.out.print("Enter flight price: ");
	                double flightPrice = Double.parseDouble(reader.readLine());
	                Flight flight = new Flight(flightNumber, flightDestination, flightPrice);

	                // Create booking
	                Booking booking = new Booking(passenger, flight);

	                // Add booking to BookingService
	                bookingService.addBooking(booking);

	                // Display booking details
	                booking.displayBookingDetails();
	            }

	            // Save all bookings to file
	            bookingService.saveAllBookingsToFile("bookings.txt");

	            // Display all bookings
	            bookingService.displayAllBookings();

	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input: Please enter numeric values for booking count.");
	        } catch (BookingException e) {
	            System.out.println("Booking error: " + e.getMessage());
	        } catch (Exception e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        }
	    }
	}

