package org.example.DAO;

import org.example.Ticket;
import org.example.TicketType;
import org.example.User;

import java.time.LocalDate;

public class JDBCTask {

    public static void main(String[] args){
        TicketDAO ticketDAO = new TicketDAO();
        ticketDAO.saveTicket( new Ticket("8", "3", TicketType.WEEK, LocalDate.parse("2024-10-01")));
        System.out.println(ticketDAO.findTicketById("3"));
        System.out.println(ticketDAO.findTicketByUserId("3"));
        ticketDAO.updateTicketType("3", TicketType.YEAR);

        UserDAO userDao = new UserDAO();
        userDao.saveUser(new User("7", "aida7", LocalDate.parse("2020-01-01"), User.Role.ADMIN, "752672565", "aida7@mail.com"));
        System.out.println(userDao.findUserById("4"));
        userDao.deleteById("5");

    }
}
