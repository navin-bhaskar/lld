package repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository extends BaseRepository {
    final private Map<String, Vehicle> vehicles = new HashMap<>();

    public Vehicle addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getRegNumber(), vehicle);
        return vehicle;
    }

    public Optional<Vehicle> findByNumber(String number) {
        if(vehicles.containsKey(number)) {
            return Optional.of(vehicles.get(number));
        }
        return Optional.empty();
    }
}
