package org.example;

public class User {
    public long id;
    public Role role;
    public Role printRole(){
        return role;
    }

    enum Role{
        ADMIN, CLIENT
    }
}
