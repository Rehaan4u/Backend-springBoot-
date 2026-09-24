
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.computer;

@RestController

public class hello {


    //Very important concept here, when you declare the Objects of other class like this
    //they are ByDefault declared as null and you can't access the methods of Object declared as null

    @Autowired
    //Here we have changed the type to the interface that hello class implements 
    //cause @Autowired injects Ocjects on the basisi of type and not according to the name
    computer name;

    @RequestMapping("/")
    public String printHello()
    {
        return name.compile()+"HelloWorld";
    }
}