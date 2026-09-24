package com.example.demo;

import org.springframework.stereotype.Component;

import com.example.demo.interfaces.computer;

@Component 
public class userName implements computer {

    public String compile() {
        return "Rehaan implements the computer interface";
    }
}
