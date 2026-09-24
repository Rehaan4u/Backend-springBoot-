package com.example.demo;
import org.springframework.stereotype.Component;

import com.example.demo.interfaces.computer;

@Component 
public class Username1 implements computer{

    public String compile() {
        return "/n Hello from user 2";
    }
    
}