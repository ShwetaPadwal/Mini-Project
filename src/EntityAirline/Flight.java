package EntityAirline;

public class Flight {
	
	    private String flightNumber;
	    private String destination;
	    private double price;

	    public Flight(String flightNumber, String destination, double price) {
	        this.flightNumber = flightNumber;
	        this.destination = destination;
	        this.price = price;
	    }

	    public String getFlightNumber() {
	        return flightNumber;
	    }

	    public String getDestination() {
	        return destination;
	    }

	    public double getPrice() {
	        return price;
	    }

	    @Override
	    public String toString() {
	        return flightNumber + " to " + destination + " ($" + price + ")";
	    }
	}
