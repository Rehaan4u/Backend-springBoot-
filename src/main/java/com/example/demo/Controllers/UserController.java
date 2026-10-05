package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
        
            /* Patch is different from Put, Put replaces the stored object with whatever new object you pass and if some of the parameter
                are not getting changed, then by default it will fill it with NULL values
                
                Therefore, we prefer here to use, Patch instead of Put, cause we make the Patch callf rom teh frontend instead of put call
            */
            @PatchMapping("/{userID}")
            @CrossOrigin 
            //Also the @RequestBody, fetches whatever data has been sent by the frontend in the patch call body
            public userData putUserData(@PathVariable Integer userID, @RequestBody userData partialDataChanges)
            {
                return userService.updateExistingUser(userID, partialDataChanges);
            }

        //-------------------------------------------------------------------------//   
            
            @CrossOrigin
            @PostMapping("/adduser")
            public ResponseEntity<userData> addingUser(@RequestBody userData newUser, @RequestHeader("Admin-Passwd") String passwd)
            {
               
                return userService.addUser(newUser, passwd) //You receive the Optional<userData> till here
                            .map((ResponseIsThere)-> ResponseEntity.status(HttpStatus.CREATED).body(ResponseIsThere))//If there is body then you status(Lambda function runs) and it transforms it into a 
                            //ResponseEntity<userData>, otherwise it will not run and pass to the the below method
                            .orElseGet(()-> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
            }

            @CrossOrigin 
            @DeleteMapping("/deleteUser")
            public ResponseEntity<String> deleteExistingUser(@RequestHeader("Which-User") String userID)
            {
                return userService.deleteExistingUser(userID)
                .map((Response) -> ResponseEntity.status(HttpStatus.ACCEPTED).body(Response))
                .orElseGet(()->ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build());
            }
 
        };

