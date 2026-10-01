package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.userData;
import com.example.demo.Services.userDataService;


//Seperate class for each site such as {/users,/products, /home}
//Veru important to note, the RequestMAppign is declared for /products and any methods you declare inside the class, 
//just gets added into the /products path
@RestController 
@CrossOrigin 
 @RequestMapping("/users")
        public class UserController{

            @Autowired 
            userDataService userService;
            userData userData;

        //-------------------------------------------------------------------------//
            //like here the request path would look like /products/userid 
            // like 101,102
            @GetMapping ("/{userID}")
            public userData ProducstsWithParticularId(@PathVariable String userID)
                {   
                    
                    return userService.targetUserData(userID);
                }

        
            @GetMapping 
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

            @PostMapping 
            public String postUserData(userData user)
                {
                    return userService.addUser(user);
                }
                
        //-------------------------------------------------------------------------//    
        
            /* Patch is different from Put, Put replaces the stored object with whatever new object you pass and if some of the parameter
                are not getting changed, then by default it will fill it with NULL values
                
                Therefore, we prefer here to use, Patch instead of Put, cause we make the Patch callf rom teh frontend instead of put call
            */
            @PatchMapping("/{userID}")
            @CrossOrigin 
            public userData putUserData(@PathVariable Integer userID, @RequestBody userData partialDataChanges)
            {
                return userService.updateExistingUser(userID, partialDataChanges);
            }
 
        };

