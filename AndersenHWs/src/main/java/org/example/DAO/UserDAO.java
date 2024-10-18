package org.example.DAO;

import org.example.Properties;
import org.example.Ticket;
import org.example.TicketType;
import org.example.User;

import java.sql.*;
import java.time.LocalDate;

public class UserDAO {
    Properties properties = new Properties();

    public void saveUser(User user){
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_ticket_service_db",
                        properties.username, properties.password);
                Statement stmt = conn.createStatement();
                ){
            stmt.executeUpdate("INSERT INTO user VALUES('" + user.id + "' , '" + user.name + "' , '" + user.creationDate + "' , '" + user.role + "' , '" + user.phone + "' , '" + user.email + "');");

        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public User findUserById(String id){
        User user = new User();
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_ticket_service_db",
                        properties.username, properties.password);
                Statement stmt = conn.createStatement();
                ){

            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id = '" + id + "';");
            while(rs.next()){
                user = new User(rs.getString("id"), rs.getString("name"), LocalDate.parse(rs.getString("creation_date")), User.Role.valueOf(rs.getString("role")), rs.getString("phone"), rs.getString("email"));
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return user;
    }

    // added "ON DELETE CASCADE" when creating table so that the user's tickets are also deleted
    public void deleteById(String id){
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_ticket_service_db",
                        properties.username, properties.password);
                Statement stmt = conn.createStatement();
                ){
            stmt.executeUpdate("DELETE FROM user WHERE id = '" + id + "';");
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

}
