package strategies.feecalculation;

import models.Ticket;

public class FlatFeeStrategy extends FeeCalculationStrategy{

    @Override
    public int getAmount(Ticket ticket) {
        return 1000;
    }
}
