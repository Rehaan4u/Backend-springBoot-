package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class AboutController {
    @RequestMapping("/about")
    public String printAboutControllerMessage() 
    {
        return "Message from the About Controller";
    }
}
