package org.example;

import java.time.LocalDate;
import org.example.TicketType;

public class BusTicketValidator{
    public static int START_DATE_VALIDATIONS;
    public static int TICKET_TYPE_VALIDATIONS;
    public static int PRICE_VALIDATIONS;

    public void validateStartDate(LocalDate startDate, TicketType ticketType) throws Exception{
        if(ticketType == TicketType.MONTH && startDate != null){
            START_DATE_VALIDATIONS++;
            throw new Exception("Only DAY, WEEK and YEAR types must have a start date.");
        }
        else if (startDate!= null && startDate.isAfter(LocalDate.now())){
            START_DATE_VALIDATIONS++;
            throw new Exception ("Start date can't be in the future.");
        }
    }

    public void validateTicketType(TicketType ticketType)throws IllegalArgumentException{
        if(ticketType != TicketType.DAY && ticketType != TicketType.WEEK && ticketType != TicketType.MONTH && ticketType != TicketType.YEAR){
            TICKET_TYPE_VALIDATIONS++;
            throw new IllegalArgumentException("Ticket type valid values are DAY, WEEK, MONTH, YEAR");
        }
    }

    public void validatePrice(Double price) throws Exception {
        if(price == null){
            PRICE_VALIDATIONS++;
            throw new Exception("Price can't be null");
        }
        else if(price == 0){
            PRICE_VALIDATIONS++;
            throw new Exception("Price can't be 0.");
        }
        else if(price % 2 != 0){
            PRICE_VALIDATIONS++;
            throw new Exception ("Price should always be even.");
        }
    }
}
