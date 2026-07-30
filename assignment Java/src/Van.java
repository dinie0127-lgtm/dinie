public class Van extends Vehicle {
    private double loadCapacity;

    public Van(String vehicleID, String model, String brand, double engineCapacity, double loadCapacity) {
        super(vehicleID, model, brand, engineCapacity);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + ", Type: Van, Load Capacity: " + loadCapacity;
    }
}