package org.example.DAO;
import org.example.Properties;
import org.example.Ticket;
import org.example.TicketType;
import org.example.User;

import java.sql.*;
import java.time.LocalDate;

public class JDBCTask {

    public static void main(String[] args){
        Properties properties = new Properties();
        UserDAO userDAO = new UserDAO();
        TicketDAO ticketDAO = new TicketDAO();

        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_ticket_service_db",
                    properties.username, properties.password);
            Statement stmt = conn.createStatement();
        ){
            User user = new User("4", "aida4", LocalDate.parse("2020-01-01"), User.Role.ADMIN, "752672565", "aida4@mail.com");
            stmt.executeUpdate(userDAO.saveUser(user));
            ResultSet rs1 = stmt.executeQuery(userDAO.findUserById("2"));
            while(rs1.next()) {
                System.out.print("id: "+rs1.getString("id")+", ");
                System.out.print("name: "+rs1.getString("name")+", ");
                System.out.print("creation date: "+rs1.getString("creation_date") + ", ");
                System.out.print("role: "+rs1.getString("role")+", ");
                System.out.print("phone: "+rs1.getString("phone")+", ");
                System.out.print("email: "+rs1.getString("email"));
                System.out.println();
            }
            stmt.executeUpdate(userDAO.deleteById("2"));

            Ticket ticket = new Ticket("1", "3", TicketType.WEEK, LocalDate.parse("2024-01-01"));
            stmt.executeUpdate(ticketDAO.saveTicket(ticket));
            ResultSet rs2 = stmt.executeQuery(ticketDAO.findTicketById("2"));
            while(rs2.next()) {
                System.out.print("id: "+rs2.getString("id")+", ");
                System.out.print("user id: "+rs2.getString("user_id")+", ");
                System.out.print("ticket type: "+rs2.getString("ticket_type")+", ");
                System.out.print("creation date: "+rs2.getString("creation_date"));
                System.out.println();
            }

            ResultSet rs3 = stmt.executeQuery(ticketDAO.findTicketByUserId("2"));
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
