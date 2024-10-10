package ServiceAirline;

import java.util.ArrayList;
import java.util.List;

import EntityAirline.*;
import Exception.BookingException;

public class BookingService {
    private List<Booking> bookings;

    public BookingService() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) throws BookingException {
        if (booking == null) {
            throw new BookingException("Booking cannot be null.");
        }
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
