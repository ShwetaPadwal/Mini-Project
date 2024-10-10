package ServiceVehicle;
import java.util.ArrayList;
import java.util.List;

import EntityVehicle.*;
import ServiceVehicle.*;

public class RentalService {
	
	    private List<Rental> rentals;

	    public RentalService() {
	        this.rentals = new ArrayList<>();
	    }

	    public void addRental(Rental rental) {
	        rentals.add(rental);
	    }

	    public void displayAllRentals() {
	        System.out.println("\n--- All Rentals ---");
	        for (Rental rental : rentals) {
	            rental.displayRentalDetails();
	        }
	    }

	    public void saveAllRentalsToFile(String filename) {
	        for (Rental rental : rentals) {
	            rental.saveRentalToFile(filename);
	        }
	    }
	}

