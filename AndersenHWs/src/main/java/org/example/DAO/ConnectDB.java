package org.example.DAO;

import org.example.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
    private Properties properties = new Properties();

    public Statement getConnection(){
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_ticket_service_db", properties.username, properties.password);
            stmt = conn.createStatement();
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return stmt;
    }
}
