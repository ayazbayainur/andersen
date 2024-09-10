package org.example;

public class Ticket {
    public static Double price;
    private String id;
    private String concertHall;
    private Integer eventCode;
    private long eventTime;  // Unix timestap
    private Boolean isPromo;
    private StadiumSector stadiumSector;
    private Double maxBackpackWeight;
    private long creationTime =  System.currentTimeMillis() / 1000L; // Unix timestap

    public Ticket(){

    }

    public Ticket(String id, String concertHall, Integer eventCode, long eventTime, Boolean isPromo, StadiumSector stadiumSector, Double maxBackpackWeight){
        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.eventTime = eventTime;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxBackpackWeight = maxBackpackWeight;
    }

    public Ticket(String concertHall, Integer eventCode, long eventTime){
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

    public void setId(String id){
        if(String.valueOf(id).length() <= 4){
            this.id = id;
        }
    }

    public void setConcertHall(String concertHall){
        if(concertHall.length() <= 10) {
            this.concertHall = concertHall;
        }
    }

    public void setEventCode(Integer eventCode){
        if(String.valueOf(eventCode).length() == 3){
            this.eventCode = eventCode;
        }
    }

    public void setIsPromo(Boolean isPromo){
        this.isPromo = isPromo;
    }

    public void setStadiumSector(StadiumSector stadiumSector){
        this.stadiumSector = stadiumSector;
    }

    public void setMaxBackpackWeight(Double maxBackpackWeight){
        this.maxBackpackWeight = maxBackpackWeight;
    }

    public String toString(){
        return "id: " + id + ", concertHall: " + concertHall + ", eventCode: " + eventCode + ", eventTime: " + eventTime + ", isPromo: " + isPromo
                + ", stadumSector: " + stadiumSector + ", maxBackpackWeight: " + maxBackpackWeight + ", creationTime: " + creationTime + ", price: " + price;
    }

    enum StadiumSector{
        A, B, C;
    }
}
