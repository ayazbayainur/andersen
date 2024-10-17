package org.example.DAO;

import org.example.Properties;
import org.example.Ticket;
import org.example.TicketType;
import org.example.User;

import java.sql.*;
import java.time.LocalDate;

public class UserDAO {

    public String saveUser(User user){
        return "INSERT INTO user VALUES('" + user.id + "' , '" + user.name + "' , '" + user.creationDate + "' , '" + user.role + "' , '" + user.phone + "' , '" + user.email + "');";
    }

    public String findUserById(String id){
        return "SELECT * FROM user WHERE id = '" + id + "';";
    }

    // added "ON DELETE CASCADE" when creating table so that the user's tickets are also deleted
    public String deleteById(String id){
        return "DELETE FROM user WHERE id = '" + id + "';";
    }

    public static void main(String[] args){
        Properties properties = new Properties();
        UserDAO userDAO = new UserDAO();
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_ticket_service_db",
                        properties.username, properties.password);
                Statement stmt = conn.createStatement();
        ){
            User user = new User("6", "aida6", LocalDate.parse("2020-01-01"), User.Role.ADMIN, "752672565", "aida6@mail.com");
            stmt.executeUpdate(userDAO.saveUser(user));
            String userId = "3";
            ResultSet rs1 = stmt.executeQuery(userDAO.findUserById(userId));
            System.out.println("Users with id = " + userId);
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
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

    }

}
