package strategies.feecalculation;

import models.Ticket;

abstract public class FeeCalculationStrategy {
    abstract public int getAmount(Ticket ticket);
}
