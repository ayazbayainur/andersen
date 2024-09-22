package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.ConcertTicket;
public class TicketService {
    private static List<ConcertTicket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello world!");
        ConcertTicket emptyConcertTicket = new ConcertTicket();
        ConcertTicket fullConcertTicket1 = new ConcertTicket("1", "red", 001, 1676419200, true, ConcertTicket.StadiumSector.A, 25.9857);
        ConcertTicket fullConcertTicket2 = new ConcertTicket("2", "red", 001, 1676419200, true, ConcertTicket.StadiumSector.A, 25.9857);
        ConcertTicket fullConcertTicket3 = new ConcertTicket("3", "red", 001, 1676419200, true, ConcertTicket.StadiumSector.C, 25.9857);
        ConcertTicket fullConcertTicket4 = new ConcertTicket("4", "red", 001, 1676419200, true, ConcertTicket.StadiumSector.B, 25.9857);
        ConcertTicket fullConcertTicket5 = new ConcertTicket("5", "red", 001, 1676419200, true, ConcertTicket.StadiumSector.A, 25.9857);
        ConcertTicket fullConcertTicket6 = new ConcertTicket("6", "red", 001, 1676419200, true, ConcertTicket.StadiumSector.C, 25.9857);
        ConcertTicket fullConcertTicket7 = new ConcertTicket("7", "red", 001, 1676419200, true, ConcertTicket.StadiumSector.A, 25.9857, "747 632 5465");
        ConcertTicket fullConcertTicket8 = new ConcertTicket("8", "red", 001, 1676419200, true, ConcertTicket.StadiumSector.B, 25.9857, "707 632 5465", "email");
        ConcertTicket fullConcertTicket9 = new ConcertTicket("1", "red", 001, 1676419200, true, ConcertTicket.StadiumSector.A, 25.9857);
        ConcertTicket limitedConcertTicket1 = new ConcertTicket("red", 001, 1676419208);
        ConcertTicket limitedConcertTicket2 = new ConcertTicket("red", 001, 1676419209);

//        tickets.add(emptyTicket);
        tickets.add(fullConcertTicket1);
        tickets.add(limitedConcertTicket1);
        tickets.add(fullConcertTicket2);
        tickets.add(fullConcertTicket3);
        tickets.add(fullConcertTicket4);
        tickets.add(fullConcertTicket5);
        tickets.add(fullConcertTicket6);
        tickets.add(fullConcertTicket7);
        tickets.add(fullConcertTicket8);
        tickets.add(limitedConcertTicket2);

//        ConcertTicket.price = 3000.0;
        System.out.println(tickets);
        System.out.println(returnById("2"));

        System.out.println(fullConcertTicket1.print());

        fullConcertTicket1.shared("8773636");
        fullConcertTicket1.shared("672323572", "email");

        User user = new Admin();
        System.out.println(user.printRole());

        System.out.println(fullConcertTicket1.equals(fullConcertTicket9));
        System.out.println(fullConcertTicket1 == fullConcertTicket9);
        System.out.println(fullConcertTicket1.hashCode());
        System.out.println(fullConcertTicket9.hashCode());
    }

    private static ConcertTicket returnById(String id){
        for(int i = 0; i < tickets.size(); i++){
            if(tickets.get(i).getId() != null && tickets.get(i).getId().equals(id)){
                return tickets.get(i);
            }
        }
        return null;
    }
}
