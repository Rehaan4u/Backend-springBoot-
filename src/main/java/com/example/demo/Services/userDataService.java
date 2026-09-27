package com.example.demo.Services;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.userData;

@Service 
@RestController 
public class userDataService {

        private userData[] AllUsers= new userData[]
        {
            new userData(101,"Rehaan", "Makhija"),
            new userData(102,"Nandini","Chaabra"),
            new userData(103,"Tiya","Singh")
        };

    @RequestMapping ("/products")
    public userData[] AllUserList()
    {
    //    List<userData> userDataList = Arrays.asList(
    //          new userData(101,"Rehaan", "Makhija"),
    //          new userData(102,"Nandini","Chaabra"),
    //          new userData(103,"Tiya","Singh")
    //     );
        return AllUsers;
    }

    @RequestMapping("/products/{prodID}")
    public userData targetUserData(@PathVariable String prodID)
    {
        userData[] listOfUsers = AllUsers;
        int tgtID=Integer.parseInt(prodID);
        int mid=-1;
        int s=0,e=listOfUsers.length;
        userData user=new userData(-1,"No User Avaiblable ", "Check your ID again");

        while(s<=e)
        {
            mid=s+(e-s)/2;
            if(listOfUsers[mid].id==tgtID)
            {
                user=listOfUsers[mid];
                break;
            }
            else if(listOfUsers[mid].id>tgtID)
            {   
                e=mid-1;
            }
            else s=mid+1;

        }
        return user;
    }

}
