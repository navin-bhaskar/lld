package services;

import exceptions.GateNotFound;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import strategies.allocation.AllocationFactory;
import strategies.allocation.AllocationStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketingService {
    private GateRepository gateRepo;
    private ParkingLotRepository parkingLotRepo;
    private TicketRepository ticketRepo;
    private VehicleRepository vehicleRepo;

    public TicketingService(GateRepository gateRepo,
                            ParkingLotRepository parkingLotRepo,
                            TicketRepository ticketRepo,
                            VehicleRepository vehicleRepo) {
        this.gateRepo = gateRepo;
        this.parkingLotRepo = parkingLotRepo;
        this.ticketRepo = ticketRepo;
        this.vehicleRepo = vehicleRepo;
    }

    public Ticket issueTicket(VehicleType vehicleType, String number, String owner, Long gateId) throws GateNotFound {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gate> gateOption = gateRepo.findById(gateId);
        if (gateOption.isEmpty()) {
            throw new GateNotFound();
        }

        Gate gate = gateOption.get();
        ticket.setEntryGate(gate);

        Vehicle vehicle = null;
        Optional<Vehicle> vehicleOp = vehicleRepo.findByNumber(number);
        if (vehicleOp.isEmpty()) {
            vehicle = new Vehicle();
            vehicle.setOwner(owner);
            vehicle.setVehicleType(vehicleType);
            vehicle.setRegNumber(number);
            vehicleRepo.addVehicle(vehicle);
        }

        Optional<ParkingLot> parkingLotOp = parkingLotRepo.findByGate(gate);
        if (parkingLotOp.isEmpty()) {
            // TODO: Add check for parkinglot exception
            throw new GateNotFound();
        }
        ParkingLot parkingLot = parkingLotOp.get();

        AllocationFactory fct = new AllocationFactory(parkingLot);
        AllocationStrategy allotStart = fct.getStrategy();

        ParkingSpot spot = allotStart.getSpot(vehicle.getVehicleType());
        spot.setStatus(ParkingSpotStatus.OCCUPIED);
        ticket.setSpot(spot);

        ticketRepo.addTicket(ticket);
        return ticket;
    }
}
