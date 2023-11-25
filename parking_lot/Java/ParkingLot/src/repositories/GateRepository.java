package repositories;

import models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository extends BaseRepository{
    final private Map<Long, Gate> gates = new HashMap<>();

    public Optional<Gate> findById(Long id) {
        if(gates.containsKey(id)) {
            return Optional.of(gates.get(id));
        }
        return Optional.empty();
    }

    public Gate addGate(Gate gate) {
        Long nextId = this.getNextId();
        gates.put(nextId, gate);
        gate.setId(nextId);
        this.setNextId(nextId);
        return gate;
    }
}
