package org.example;

public abstract class Ticket {
    public String id;
    public String phone;
    public String email;

    public String print(){
        return "print content in console";
    }

    public void shared(String phone){
        System.out.println("shared by phone");
    }
    public abstract void shared(String phone, String email);
}
