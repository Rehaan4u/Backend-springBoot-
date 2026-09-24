
package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {


    //Very important concept here, when you declare the Objects of other class like this
    //they are ByDefault declared as null and you can't access the methods of Object declared as null
    userName name;

    @RequestMapping("/")
    public String printHello()
    {
        return name.printUserName()+"HelloWorld";
    }
}