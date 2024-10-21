package org.example.DAO;

import org.example.Properties;
import org.example.Ticket;
import org.example.TicketType;
import org.example.User;

import java.sql.*;
import java.time.LocalDate;

public class UserDAO {
    ConnectDB connectDB = new ConnectDB();

    public void saveUser(User user){
        try{
            connectDB.getConnection().executeUpdate("INSERT INTO user VALUES('" + user.id + "' , '" + user.name + "' , '" + user.creationDate + "' , '" + user.role + "' , '" + user.phone + "' , '" + user.email + "');");

        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally{
            connectDB.getConnection();
        }
    }

    public User findUserById(String id){
        User user = new User();
        try{
            ResultSet rs = connectDB.getConnection().executeQuery("SELECT * FROM user WHERE id = '" + id + "';");
            while(rs.next()){
                user = new User(rs.getString("id"), rs.getString("name"), LocalDate.parse(rs.getString("creation_date")), User.Role.valueOf(rs.getString("role")), rs.getString("phone"), rs.getString("email"));
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally{
            connectDB.getConnection();
        }
        return user;
    }

    // added "ON DELETE CASCADE" when creating table so that the user's tickets are also deleted
    public void deleteById(String id){
        try{
            connectDB.getConnection().executeUpdate("DELETE FROM user WHERE id = '" + id + "';");
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally{
            connectDB.getConnection();
        }
    }

}
