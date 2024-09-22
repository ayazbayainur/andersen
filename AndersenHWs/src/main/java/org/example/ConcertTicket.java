package org.example;

import java.util.Objects;

public class ConcertTicket extends Ticket{
    private Double price;
    private String concertHall;
    private Integer eventCode;
    private long eventTime;  // Unix timestap
    private Boolean isPromo;
    private StadiumSector stadiumSector;
    private Double maxBackpackWeight;
    private long creationTime =  System.currentTimeMillis() / 1000L; // Unix timestap

    public ConcertTicket(){

    }
    public ConcertTicket(String id, String concertHall, Integer eventCode, long eventTime, Boolean isPromo, StadiumSector stadiumSector, Double maxBackpackWeight){
        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.eventTime = eventTime;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxBackpackWeight = maxBackpackWeight;
    }

    public ConcertTicket(String id, String concertHall, Integer eventCode, long eventTime, Boolean isPromo, StadiumSector stadiumSector, Double maxBackpackWeight, String phone){
        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.eventTime = eventTime;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxBackpackWeight = maxBackpackWeight;
        this.phone = phone;
    }

    public ConcertTicket(String id, String concertHall, Integer eventCode, long eventTime, Boolean isPromo, StadiumSector stadiumSector, Double maxBackpackWeight, String phone, String email){
        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.eventTime = eventTime;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxBackpackWeight = maxBackpackWeight;
        this.phone = phone;
        this.email = email;
    }

    public ConcertTicket(String concertHall, Integer eventCode, long eventTime){
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.eventTime = eventTime;
    }

    public String getId(){
        return id;
    }

    public String getConcertHall(){
        return concertHall;
    }

    public Integer getEventCode(){
        return eventCode;
    }

    public long getEventTime(){
        return eventTime;
    }

    public Boolean getIsPromo(){
        return isPromo;
    }

    public StadiumSector getStadiumSector(){
        return stadiumSector;
    }

    public Double getMaxBackpackWeight(){
        return maxBackpackWeight;
    }

    public void setStadiumSector(StadiumSector stadiumSector){
        this.stadiumSector = stadiumSector;
    }

    public void setEventTime(long eventTime){
        this.eventTime = eventTime;
    }

    @Override
    public String print(){
        return getClass().getName() + ", " + Integer.toHexString(hashCode());
    }

    @Override
    public void shared(String phone){
        System.out.println("Concert ticket shared by phone");
    }

    public void shared(String phone, String email){
        System.out.println("Concert ticket shared by phone and email");
    }

    @Override
    public String toString(){
        return "id: " + id + ", concertHall: " + concertHall + ", eventCode: " + eventCode + ", eventTime: " + eventTime + ", isPromo: " + isPromo
                + ", stadumSector: " + stadiumSector + ", maxBackpackWeight: " + maxBackpackWeight + ", creationTime: " + creationTime + ", price: " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConcertTicket concertTicket = (ConcertTicket) o;
        return Objects.equals(id, concertTicket.getId()) &&
                Objects.equals(creationTime, concertTicket.creationTime) &&
                Objects.equals(eventCode, concertTicket.eventCode);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, creationTime, eventCode);
    }

    enum StadiumSector{
        A, B, C;
    }
}
