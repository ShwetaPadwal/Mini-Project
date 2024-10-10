package Test;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import ServiceCinema.*;
import EntityCinema.*;
import Exception.*;

public class TestCinema {
	
	    public static void main(String[] args) {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        BookingService bookingService = new BookingService();

	        try {
	            // Ask how many bookings to create
	            System.out.print("How many bookings do you want to create? ");
	            int numberOfBookings = Integer.parseInt(reader.readLine());

	            for (int i = 0; i < numberOfBookings; i++) {
	                System.out.println("\n--- Booking " + (i + 1) + " ---");

	                // Get user details
	                System.out.print("Enter your name: ");
	                String name = reader.readLine();
	                System.out.print("Enter your email: ");
	                String email = reader.readLine();
	                User user = new User(name, email);

	                // Get movie details
	                System.out.print("Enter movie title: ");
	                String movieTitle = reader.readLine();
	                System.out.print("Enter movie genre: ");
	                String movieGenre = reader.readLine();
	                Movie movie = new Movie(movieTitle, movieGenre);

	                // Get seat number and price
	                System.out.print("Enter seat number: ");
	                int seatNumber = Integer.parseInt(reader.readLine());
	                System.out.print("Enter ticket price: ");
	                double ticketPrice = Double.parseDouble(reader.readLine());

	                // Create and add booking to BookingService
	                Booking booking = new Booking(user, movie, seatNumber, ticketPrice);
	                bookingService.addBooking(booking);

	                // Display booking details
	                booking.displayBookingDetails();
	            }

	            // Save all bookings to file
	            bookingService.saveAllBookingsToFile("bookings.txt");

	            // Display all bookings
	            bookingService.displayAllBookings();

	        } catch (InvalidSeatException e) {
	            System.out.println("Error: " + e.getMessage());
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input: Please enter numeric values for seat number and price.");
	        } catch (Exception e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        }
	    }
	}
