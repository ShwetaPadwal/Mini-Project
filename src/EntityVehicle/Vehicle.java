package EntityVehicle;

public class Vehicle {
    private String make;
    private String model;
    private String licensePlate;

    public Vehicle(String make, String model, String licensePlate) {
        this.make = make;
        this.model = model;
        this.licensePlate = licensePlate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return "Vehicle: " + make + " " + model + " (License Plate: " + licensePlate + ")";
    }
}