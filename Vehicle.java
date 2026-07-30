public abstract class Vehicle {
    private String vehicleID;
    private String model;
    private String brand;
    private double engineCapacity;

    public Vehicle(String vehicleID, String model, String brand, double engineCapacity) {
        this.vehicleID = vehicleID;
        this.model = model;
        this.brand = brand;
        this.engineCapacity = engineCapacity;
    }

    public String getVehicleID() { return vehicleID; }
    public String getModel() { return model; }
    public String getBrand() { return brand; }
    public double getEngineCapacity() { return engineCapacity; }

    public String displayInfo() {
        return "Vehicle ID: " + vehicleID + ", Model: " + model + ", Brand: " + brand + ", Engine Capacity: " + engineCapacity;
    }
}