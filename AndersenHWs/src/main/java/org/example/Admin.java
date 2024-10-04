package org.example;

public class Admin extends User{
    @Override
    public Role printRole(){
        return Role.ADMIN;
    }

    public boolean checkTicket(Ticket ticket){
        return false;
    }
}
