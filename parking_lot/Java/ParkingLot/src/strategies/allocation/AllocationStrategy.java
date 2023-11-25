package strategies.allocation;

import models.ParkingLot;
import models.ParkingSpot;
import models.VehicleType;

abstract public class AllocationStrategy {
    private ParkingLot parkingLot;
    public AllocationStrategy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    abstract public ParkingSpot getSpot(VehicleType vehicleType);
}
