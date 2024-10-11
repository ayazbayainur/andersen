package org.example;

import java.time.LocalDate;

public class BusTicket {
    private TicketClass ticketClass;
    private TicketType ticketType;
    private LocalDate startDate;
    private Double price;
    private Boolean valid = true;

    public BusTicket(){
    }

    public BusTicket(TicketClass ticketClass, TicketType ticketType, LocalDate startDate, Double price){
        BusTicketValidator validator = new BusTicketValidator();
        try{
            validator.validateStartDate(startDate, ticketType);
            validator.validateTicketType(ticketType);
            validator.validatePrice(price);
        } catch(Exception ex){
            valid = false;
            System.out.println(ex.getMessage());
        }
        this.ticketClass = ticketClass;
        this.ticketType = ticketType;
        this.startDate = startDate;
        this.price = price;
    }

    public TicketClass getTicketClass(){
        return ticketClass;
    }

    public TicketType getTicketType(){
        return ticketType;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public Double getPrice(){
        return price;
    }

    public Boolean getValid(){
        return valid;
    }

    public void setTicketClass(TicketClass ticketClass){
        this.ticketClass = ticketClass;
    }

    public void setTicketType (TicketType ticketType){
        this.ticketType = ticketType;
    }

    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public String toString(){
        return "ticket class " + ticketClass + " , ticket type " + ticketType + " , start date " + startDate + " , price " + price
;    }
//    enum TicketClass{
//        CLA, STD;
//    }
//    enum TicketType{
//        DAY, WEEK, MONTH, YEAR, PRIME;
//    }
}
