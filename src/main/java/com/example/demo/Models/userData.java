package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class userData {

    @Id 
    public Integer id;
    public String FirstName;
    public String LastName;  

    /*
     *VERY VERY IMPORTANT
        To declare the constructor as public, if not mentiioned explicitely every method and instance variable declared 
        inside the class, will have PRIVATE property by default 
    */
    public userData(int id, String firstName, String lastName) {
        this.id= id;
        this.FirstName=firstName;
        this.LastName=lastName;
    }
}
