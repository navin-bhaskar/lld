package models;

import java.util.Date;

public class Bill extends BaseModel{
    private Ticket ticket;
    private Operator operator;
    private int amount;
    private Date exitTime;
}
