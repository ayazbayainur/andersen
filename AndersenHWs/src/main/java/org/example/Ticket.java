package org.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    public String id;
    public String userId;
    public TicketType ticketType;
    public LocalDate creationDate =  LocalDate.now();

    public String toString(){
        return "Ticket data: id = " + id + ", user id = " + userId + ", ticket type = " + ticketType + ", creation date = " + creationDate;
    }
}
