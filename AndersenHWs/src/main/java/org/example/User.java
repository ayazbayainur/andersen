package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
public class User {
    public String id;
    public String name;
    public LocalDate creationDate = LocalDate.now();
    public Role role;
    public String phone;
    public String email;

    public Role printRole(){
        return role;
    }

    public enum Role{
        ADMIN, CLIENT
    }
}
