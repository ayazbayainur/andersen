package org.example.DAO;

import org.example.User;

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

}
