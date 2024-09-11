package org.example;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private static List<Ticket> tickets = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Ticket emptyTicket = new Ticket();
        Ticket fullTicket1 = new Ticket("1", "red", 001, 1676419200, true, Ticket.StadiumSector.A, 25.9857);
        Ticket fullTicket2 = new Ticket("2", "red", 001, 1676419200, true, Ticket.StadiumSector.A, 25.9857);
        Ticket fullTicket3 = new Ticket("3", "red", 001, 1676419200, true, Ticket.StadiumSector.C, 25.9857);
        Ticket fullTicket4 = new Ticket("4", "red", 001, 1676419200, true, Ticket.StadiumSector.B, 25.9857);
        Ticket fullTicket5 = new Ticket("5", "red", 001, 1676419200, true, Ticket.StadiumSector.A, 25.9857);
        Ticket fullTicket6 = new Ticket("6", "red", 001, 1676419200, true, Ticket.StadiumSector.C, 25.9857);
        Ticket fullTicket7 = new Ticket("7", "red", 001, 1676419200, true, Ticket.StadiumSector.A, 25.9857);
        Ticket fullTicket8 = new Ticket("8", "red", 001, 1676419200, true, Ticket.StadiumSector.B, 25.9857);
        Ticket limitedTicket1 = new Ticket("red", 001, 1676419208);
        Ticket limitedTicket2 = new Ticket("red", 001, 1676419209);

        tickets.add(emptyTicket);
        tickets.add(fullTicket1);
        tickets.add(fullTicket2);
        tickets.add(fullTicket3);
        tickets.add(fullTicket4);
        tickets.add(fullTicket5);
        tickets.add(fullTicket6);
        tickets.add(fullTicket7);
        tickets.add(fullTicket8);
        tickets.add(limitedTicket1);
        tickets.add(limitedTicket2);

        Ticket.price = 3000.0;

        System.out.println(tickets);
    }
}
