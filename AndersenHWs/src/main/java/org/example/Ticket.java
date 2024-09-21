package org.example;

public abstract class Ticket {
    public String id;
    public String phone;
    public String email;

    public String print(){
        return "print content in console";
    }

    public Ticket shared(String phone){
        return null;
    }
    public abstract Ticket shared(String phone, String email);
}
