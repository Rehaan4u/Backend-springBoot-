package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.userData;
import com.example.demo.Services.userDataService;


    @RestController 
public class HomeController {


        @Autowired 
        userDataService userService;
    
     //-------------------------------------------------------------------------//    

        @RequestMapping("/")
        public String printControllerMsg() {
            return "Message from Home Controller";
        }   

    //-------------------------------------------------------------------------//

        @RequestMapping ("/products")
        public List<userData> AllUserList()
        {
        //    List<userData> userDataList = Arrays.asList(
        //          new userData(101,"Rehaan", "Makhija"),
        //          new userData(102,"Nandini","Chaabra"),
        //          new userData(103,"Tiya","Singh")
        //     );
            return userService.AllData();
        }
    //-------------------------------------------------------------------------//

    //Whatever value you fetch from the URL is By Default String, and you can do the type conversion using the 
        //@PathVariable itself. see below we have converted the String value into INTEGER 
        @RequestMapping("/products/{prodID}")
        public userData GetUserDataUsingID(@PathVariable Integer prodID)
        {   
            return userService.targetUserData(prodID);

        }
    //-------------------------------------------------------------------------//

       @PostMapping 
        public String postUserData(userData user)
        {
            return userService.addUser(user);
        }
    //-------------------------------------------------------------------------//
    
}


