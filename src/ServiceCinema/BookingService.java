package ServiceCinema;
import java.util.ArrayList;
import java.util.List;

import EntityCinema.Booking;

public class BookingService {
	    private List<Booking> bookings;

	    public BookingService() {
	        this.bookings = new ArrayList<>();
	    }

	    public void addBooking(Booking booking) {
	        bookings.add(booking);
	    }

	    public void displayAllBookings() {
	        System.out.println("\n--- All Bookings ---");
	        for (Booking booking : bookings) {
	            booking.displayBookingDetails();
	        }
	    }

	    public void saveAllBookingsToFile(String filename) {
	        for (Booking booking : bookings) {
	            booking.saveBookingToFile(filename);
	        }
	    }
	}
