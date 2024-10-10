package EntityCinema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Exception.InvalidSeatException;

public class Booking {
	    private User user;
	    private Movie movie;
	    private int seatNumber;
	    private double price;

	    public Booking(User user, Movie movie, int seatNumber, double price) throws InvalidSeatException {
	        if (seatNumber <= 0) {
	            throw new InvalidSeatException("Seat number must be greater than zero.");
	        }
	        this.user = user;
	        this.movie = movie;
	        this.seatNumber = seatNumber;
	        this.price = price;
	    }

	    public void saveBookingToFile(String filename) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\DELL\\Desktop\\CDAC\\ShwetaPadwal.txt", true))) {
	            writer.write(user.toString());
	            writer.newLine();
	            writer.write(movie.toString());
	            writer.newLine();
	            writer.write("Seat Number: " + seatNumber);
	            writer.newLine();
	            writer.write("Total Price: $" + price);
	            writer.newLine();
	            writer.write("-------------------------");
	            writer.newLine();
	            System.out.println("Booking saved to file: " + filename);
	        } catch (IOException e) {
	            System.out.println("Error saving booking: " + e.getMessage());
	        }
	    }

		public void displayBookingDetails() {System.out.println("Booking Details:");
        System.out.println(user.toString());
        System.out.println(movie.toString());
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Total Price: $" + price);
		}
	}