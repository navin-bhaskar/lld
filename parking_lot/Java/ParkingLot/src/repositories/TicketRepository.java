package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository extends BaseRepository {
    final private Map<Long, Ticket> tickets = new HashMap<>();

    public Ticket addTicket(Ticket ticket) {
        Long nextId = this.getNextId();
        tickets.put(nextId, ticket);
        ticket.setId(nextId);
        this.setNextId(nextId);
        return ticket;
    }

    public Optional<Ticket> findById(Long id) {
        if(tickets.containsKey(id)) {
            return Optional.of(tickets.get(id));
        }
        return Optional.empty();
    }
}
