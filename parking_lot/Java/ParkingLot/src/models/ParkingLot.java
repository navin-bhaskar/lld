package models;

import strategies.allocation.AllocationStrategy;
import strategies.feecalculation.FeeCalculationStrategy;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String name;
    private List<Gate> gates;

    public SlotAllotmentType getAllotmentType() {
        return allotmentType;
    }

    public void setAllotmentType(SlotAllotmentType allotmentType) {
        this.allotmentType = allotmentType;
    }

    private SlotAllotmentType allotmentType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }

    private int floors;
    private ParkingLotStatus status;
    private FeeCalculationStrategy calcFee;
    private List<VehicleType> allowedVehicleTypes;
    private AllocationStrategy spotAllocation;
}
