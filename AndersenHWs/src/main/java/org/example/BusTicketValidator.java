package org.example;

import java.time.LocalDate;

public class BusTicketValidator{
    public static int startDateValidations = 0;
    public static int ticketTypeValidations = 0;
    public static int priceValidations = 0;

    public void startDateValidator(LocalDate startDate, BusTicket.TicketType ticketType) throws Exception{
        if(ticketType == BusTicket.TicketType.MONTH && startDate != null){
            startDateValidations++;
            throw new Exception("Only DAY, WEEK and YEAR types must have a start date.");
        }
        else if (startDate!= null && startDate.isAfter(LocalDate.now())){
            startDateValidations++;
            throw new Exception ("Start date can't be in the future.");
        }
    }

    public void ticketTypeValidator(BusTicket.TicketType ticketType)throws IllegalArgumentException{
        if(ticketType != BusTicket.TicketType.DAY && ticketType != BusTicket.TicketType.WEEK && ticketType != BusTicket.TicketType.MONTH && ticketType != BusTicket.TicketType.YEAR){
            ticketTypeValidations++;
            throw new IllegalArgumentException("Ticket type valid values are DAY, WEEK, MONTH, YEAR");
        }
    }

    public void priceValidator(Double price) throws Exception {
        if(price == null){
            priceValidations++;
            throw new Exception("Price can't be null");
        }
        else if(price == 0){
            priceValidations++;
            throw new Exception("Price can't be 0.");
        }
        else if(price % 2 != 0){
            priceValidations++;
            throw new Exception ("Price should always be even.");
        }
    }
}
