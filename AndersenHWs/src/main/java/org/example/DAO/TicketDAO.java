package org.example.DAO;

import org.example.Ticket;
import org.example.TicketType;

import java.time.LocalDate;

public class TicketDAO {

    public String saveTicket(Ticket ticket){
        return "INSERT INTO ticket VALUES('" + ticket.id + "' , '" + ticket.userId + "', '" + ticket.ticketType + "' , '" + ticket.creationDate + "');";
    }

    public String findTicketById(String id){
        return "SELECT * FROM ticket WHERE id = '" + id + "';";
    }

    public String findTicketByUserId(String userId){
        return "SELECT * FROM ticket WHERE user_id = '" + userId + "';";
    }

    public String updateTicketType(String id, TicketType ticketType){
        return "UPDATE ticket SET ticket_type = '" + ticketType + "' WHERE id = '" + id + "';";
    }
}
