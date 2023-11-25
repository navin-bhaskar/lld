package strategies.allocation;

import models.ParkingLot;
import models.SlotAllotmentType;

public class AllocationFactory {
    private ParkingLot parkingLot;
    public AllocationFactory(ParkingLot plot) {
        parkingLot = plot;

    }

    public AllocationStrategy getStrategy() {
        if (parkingLot.getAllotmentType() == SlotAllotmentType.LOWEST) {
            return new FirstFreeStrategy(parkingLot);
        }
        return null;
    }
}
