package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.userData;
import com.example.demo.Repository.userDataRepo;

@Service 
public class userDataService {

    //VERY important thing, we have not created hte class fro the Repository interface But still AutoWired works, 
        //cause here we are injecting the Dynamic bean created by the Spring Data JPA and managed by the @EntityManager
    @Autowired 
    public userDataRepo userDataRepo;

    //Declared the Variable, basically an array for the userData Objects

        
        protected  final List<userData> AllUsers= new ArrayList<>();

        userDataService()
        {
            initialSomeValues();
        }

        public void initialSomeValues()
        {
            AllUsers.add(new userData(102,"Nandini","Chaabra"));
            AllUsers.add(new userData(103,"Tiya","Singh"));
        }
//--------------------------------------------------------------------------------------------------------//

        public List<userData> AllData()
        {
            // return AllUsers;
            return userDataRepo.findAll();
        }


//--------------------------------------------------------------------------------------------------------//

        public userData targetUserData(String userID)
        {
            // List<userData> listOfUsers = AllUsers;
            // int tgtID=Integer.parseInt(userID);
            // int mid=-1;
            // int s=0,e=listOfUsers.size()-1;
            // userData user=new userData
            // ( -1,
            // "No User Avaiblable ", 
            //  "Check your ID again"
            // );

            //     while(s<=e)
            //     {
            //         mid=s+(e-s)/2;
            //         userData tempUser= listOfUsers.get(mid);
            //         if(tempUser.id==tgtID)
            //         {
            //             user=tempUser;
            //             break;
            //         }
            //         else if(tempUser.id>tgtID)
            //         {   
            //             e=mid-1;
            //         }
            //         else s=mid+1;

            //     }
            //     return user;

            return userDataRepo.findById(Integer.parseInt(userID)).orElse(new userData(-1, "User NOT Found", "Check the ID"));
                
        }


//-------------------------------------------------------------------------------------//

    public String addUser(userData userInput)
    {
        // if(userInput!=null)
        // {
        //     AllUsers.add(userInput);
        //     return "User Added Sucessfully";
        // }
        // else return "Error in adding User";
        userData userData = userDataRepo.save(userInput);
        if(userData!= null){
            return "User Added Succesfully";
        }
        else return "Error in adding the user";
        
    }
}
