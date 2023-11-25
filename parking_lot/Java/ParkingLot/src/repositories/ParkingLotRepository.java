package repositories;

import models.Gate;
import models.ParkingLot;

import java.util.HashMap;
import java.util.Optional;

public class ParkingLotRepository extends BaseRepository {
    final private HashMap<Long, ParkingLot> parkingLots = new HashMap<>();

    public ParkingLot addParkingLot(ParkingLot lot) {
        Long nextId = this.getNextId();
        parkingLots.put(nextId, lot);
        lot.setId(nextId);
        this.setNextId(nextId);
        return lot;
    }

    public Optional<ParkingLot> findById(Long id) {
        if(parkingLots.containsKey(id)) {
            return Optional.of(parkingLots.get(id));
        }
        return Optional.empty();
    }

    public Optional<ParkingLot> findByGate(Gate gate) {
        for(ParkingLot plot: parkingLots.values()) {
            if(plot.getGates().contains(gate)) {
                return Optional.of(plot);
            }
        }
        return Optional.empty();
    }
}
