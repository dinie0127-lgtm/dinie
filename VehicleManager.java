import java.util.ArrayList;

public class VehicleManager {
    private ArrayList<Vehicle> vehicles;

    public VehicleManager() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) throws Exception {
        for (Vehicle existing : vehicles) {
            if (existing.getModel().equalsIgnoreCase(v.getModel())) {
                throw new Exception("Duplicate Error: A vehicle with model '" + v.getModel() + "' already exists!");
            }
        }
        vehicles.add(v);
    }

    public String searchCar(String model) {
        StringBuilder result = new StringBuilder();
        boolean found = false;
        for (Vehicle v : vehicles) {
            if (v instanceof Car && v.getModel().equalsIgnoreCase(model)) {
                result.append(v.displayInfo()).append("\n");
                found = true;
            }
        }
        if (!found) {
            return "No registered car found matching the model: " + model;
        }
        return result.toString();
    }

    public String displayAllVehicles() {
        if (vehicles.isEmpty()) {
            return "No vehicles currently registered in the system.";
        }
        StringBuilder result = new StringBuilder();
        for (Vehicle v : vehicles) {
            result.append(v.displayInfo()).append("\n");
        }
        return result.toString();
    }
}