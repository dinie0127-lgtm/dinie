
public class Motorcycle extends Vehicle {
    private boolean hasCarrier;

    public Motorcycle(String vehicleID, String model, String brand, double engineCapacity, boolean hasCarrier) {
        super(vehicleID, model, brand, engineCapacity);
        this.hasCarrier = hasCarrier;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + ", Type: Motorcycle, Carrier: " + hasCarrier;
    }
}