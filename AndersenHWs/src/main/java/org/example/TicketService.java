package org.example;

public class TicketService {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Ticket emptyTicket = new Ticket();
        Ticket fullTicket = new Ticket("1", "red", 001, 1676419200, true, Ticket.StadiumSector.A, 25.9857);
        Ticket limitedTicket = new Ticket("red", 001, 1676419200);
        Ticket.price = 3000.0;
        System.out.println(emptyTicket);
        System.out.println(fullTicket);
        System.out.println(limitedTicket);
    }
}
