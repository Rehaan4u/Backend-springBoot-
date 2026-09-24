package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HomeController {
    @RequestMapping 
    public String printControllerMsg() {
        return "Message from Home Controller";
    }   
}
