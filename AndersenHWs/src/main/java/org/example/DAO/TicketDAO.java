package org.example.DAO;

import org.example.Properties;
import org.example.Ticket;
import org.example.TicketType;
import org.example.User;

import java.sql.*;
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

    public static void main(String[] args){
        Properties properties = new Properties();
        TicketDAO ticketDAO = new TicketDAO();

        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_ticket_service_db",
                        properties.username, properties.password);
                Statement stmt = conn.createStatement();
        ){
            Ticket ticket = new Ticket("5", "4", TicketType.WEEK, LocalDate.parse("2024-10-01"));
            stmt.executeUpdate(ticketDAO.saveTicket(ticket));
            ResultSet rs2 = stmt.executeQuery(ticketDAO.findTicketById("2"));
            while(rs2.next()) {
                System.out.print("id: "+rs2.getString("id")+", ");
                System.out.print("user id: "+rs2.getString("user_id")+", ");
                System.out.print("ticket type: "+rs2.getString("ticket_type")+", ");
                System.out.print("creation date: "+rs2.getString("creation_date"));
                System.out.println();
            }
            String userId = "3";
            ResultSet rs3 = stmt.executeQuery(ticketDAO.findTicketByUserId(userId));
            System.out.println("Tickets with user id = " + userId);
            while(rs3.next()) {
                System.out.print("id: "+rs3.getString("id")+", ");
                System.out.print("user id: "+rs3.getString("user_id")+", ");
                System.out.print("ticket type: "+rs3.getString("ticket_type")+", ");
                System.out.print("creation date: "+rs3.getString("creation_date"));
                System.out.println();
            }
            stmt.executeUpdate(ticketDAO.updateTicketType("1", TicketType.DAY));
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

    }
}
