package org.example.DAO;

import org.example.Properties;
import org.example.Ticket;
import org.example.TicketType;
import org.example.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    Properties properties = new Properties();
    public void saveTicket(Ticket ticket){
            try(
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_ticket_service_db",
                            properties.username, properties.password);
                    Statement stmt = conn.createStatement();
                    ){
                stmt.executeUpdate("INSERT INTO ticket VALUES('" + ticket.id + "' , '" + ticket.userId + "', '" + ticket.ticketType + "' , '" + ticket.creationDate + "');");
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
    }

    public Ticket findTicketById(String id){
        Ticket ticket = new Ticket();
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_ticket_service_db",
                        properties.username, properties.password);
                Statement stmt = conn.createStatement();
                ){
            ResultSet rs = stmt.executeQuery("SELECT * FROM ticket WHERE id = '" + id + "';");
            while(rs.next()){
                ticket = new Ticket(rs.getString("id"), rs.getString("user_id"), TicketType.valueOf(rs.getString("ticket_type")), LocalDate.parse(rs.getString("creation_date")));
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return ticket;
    }

    public List<Ticket> findTicketByUserId(String userId){
        Ticket ticket = new Ticket();
        List<Ticket> ticketList = new ArrayList<>();
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_ticket_service_db",
                        properties.username, properties.password);
                Statement stmt = conn.createStatement();
        ){
            ResultSet rs = stmt.executeQuery("SELECT * FROM ticket WHERE user_id = '" + userId + "';");
            while(rs.next()){
                ticket = new Ticket(rs.getString("id"), rs.getString("user_id"), TicketType.valueOf(rs.getString("ticket_type")), LocalDate.parse(rs.getString("creation_date")));
                ticketList.add(ticket);
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return ticketList;
    }

    public void updateTicketType(String id, TicketType ticketType){
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_ticket_service_db",
                        properties.username, properties.password);
                Statement stmt = conn.createStatement();
                ){
            stmt.executeUpdate("UPDATE ticket SET ticket_type = '" + ticketType + "' WHERE id = '" + id + "';");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

}
