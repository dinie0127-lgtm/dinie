public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String vehicleID, String model, String brand, double engineCapacity, int numberOfDoors) {
        super(vehicleID, model, brand, engineCapacity);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + ", Type: Car, Number of doors: " + numberOfDoors;
    }
}