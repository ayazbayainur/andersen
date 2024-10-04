package org.example;

public class Client extends User{
    @Override
    public Role printRole(){
        return Role.CLIENT;
    }

    public Ticket getTicket(long id){
        return null;
    }
}
