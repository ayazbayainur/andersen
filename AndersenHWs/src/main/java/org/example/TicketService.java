package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TicketService {
    private static List<ConcertTicket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        int total = 0;
        int validCount = 0;

        // reading tickets from file BusTicketData.txt
        String input = null;
        try(var reader = new BufferedReader(new FileReader("/Users/macbookpro/Desktop/andersen/AndersenHWs/src/main/java/org/example/BusTicketData"))){
            while(((input = reader.readLine()) != null)){
                BusTicket.TicketClass ticketClass = null;
                BusTicket.TicketType ticketType = null;
                LocalDate startDate = null;
                Double price = null;
                List<String> subStrings = Arrays.asList(input.substring(1, input.length() - 1).split(","));
                System.out.println(subStrings);

                for(int i = 0; i < subStrings.size() - 1; i++){
                    String param = Arrays.asList(subStrings.get(i).split(":")).get(1);
                    if(!param.equals("null")){
                        param = param.substring(1, param.length() - 1);
                    }
                    if(i == 0 && !param.equals("null")) ticketClass = BusTicket.TicketClass.valueOf(param);
                    else if(i == 1 && !param.equals("null")) ticketType = BusTicket.TicketType.valueOf(param);
                    else if(i == 2 && !param.equals("null") && param.length()!=0) startDate = LocalDate.parse(param);
                }

                if(!Arrays.asList(subStrings.get(3).split(":")).get(1).equals("null")) {
                    price = Double.valueOf(Arrays.asList(subStrings.get(3).split(":")).get(1));
                }

                BusTicket busTicket = new BusTicket(ticketClass, ticketType, startDate, price);

                total++;
                if(busTicket.getValid() == true) validCount++;
                System.out.println();
            }
        } catch(IOException ex){
            System.out.println("excep");
            System.out.println(ex.getMessage());
        }

        System.out.println("\nTotal = " + total);
        System.out.println("Valid = " + validCount);

        int maxValidations = Math.max(Math.max(BusTicketValidator.startDateValidations, BusTicketValidator.ticketTypeValidations),BusTicketValidator.priceValidations);
        String mostPopularViolation;
        if(maxValidations == BusTicketValidator.startDateValidations) mostPopularViolation = "start date";
        else if(maxValidations == BusTicketValidator.ticketTypeValidations) mostPopularViolation = "ticket type";
        else mostPopularViolation = "price";
        System.out.println("Most popular violation = " + mostPopularViolation);

        System.out.println("start date violations = " + BusTicketValidator.startDateValidations + ", ticket type violations = " + BusTicketValidator.ticketTypeValidations + ", price violations = " + BusTicketValidator.priceValidations);
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
