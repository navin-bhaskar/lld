package strategies.allocation;

import models.ParkingLot;
import models.ParkingSpot;
import models.VehicleType;

public class FirstFreeStrategy extends AllocationStrategy {

    public FirstFreeStrategy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    @Override
    public ParkingSpot getSpot(VehicleType vehicleType) {
        ParkingLot parkingLot = this.getParkingLot();
        return null;
    }

}
