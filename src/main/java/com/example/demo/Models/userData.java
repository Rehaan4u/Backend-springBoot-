package com.example.demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class userData {

    @Id 
    public Integer id;
    public String name;
    public String avatar;  
    @Column(length = 2000)
    public String brief;
    public String passwd;

    public userData()
    {
        //An empty Constructor declaration required by JPA/Hibernate for the initiallization by usign the Java's reflection stratergy
    }

    /*
     *VERY VERY IMPORTANT
        To declare the constructor as public, if not mentiioned explicitely every method and instance variable declared 
        inside the class, will have PRIVATE property by default 
    */
    public userData(Integer id, String name, String avatar, String brief, String passwd) {
        this.id= id;
        this.name=name;
        this.avatar=avatar;
        this.brief=brief;
        this.passwd=passwd;
    }
}
