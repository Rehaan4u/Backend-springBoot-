package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.Models.userData;
import com.example.demo.Repository.userDataRepo;

@Service 
public class userDataService {

    //VERY important thing, we have not created hte class fro the Repository interface But still AutoWired works, 
        //cause here we are injecting the Dynamic bean created by the Spring Data JPA and managed by the @EntityManager
    @Autowired 
    public userDataRepo userDataRepo;
    public userData userData;

    @Value("${app.reqPasswd}")
    private String expectedPasswd;
    // private String officialPasswd= "3690";
    // private String reqPasswd="2004";

    //Declared the Variable, basically an array for the userData Objects

        
        // protected  final List<userData> AllUsers= new ArrayList<>();

        // userDataService()
        // {
        //     initialSomeValues();
        // }

        // public void initialSomeValues()
        // {
        //     AllUsers.add(new userData(102,"Nandini","Chaabra"));
        //     AllUsers.add(new userData(103,"Tiya","Singh"));
        // }
//--------------------------------------------------------------------------------------------------------//

        public List<userData> AllData()
        {
            // return AllUsers;
            return userDataRepo.findAll();
        }


//--------------------------------------------------------------------------------------------------------//

        public Optional<userData> targetUserData(String userID)
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

                if(userDataRepo.existsById(Integer.parseInt(userID)))
                {
                    return userDataRepo.findById(Integer.parseInt(userID));
                }
                else return Optional.empty();
                
        }
//-------------------------------------------------------------------------------------//

    public Optional<userData> addUser(userData userInput, String passwd)
    {
    
        // if(userInput!=null)
        // {
        //     AllUsers.add(userInput);
        //     return "User Added Sucessfully";
        // }
        // else return "Error in adding User";
        if(passwd!=null && passwd.equals(expectedPasswd))
        {
            //Optional.of is ued to wrap the reponse into an Optional value
            //Very important point to note here is that, save() send back the object,strong or whatever you pass as response
            return Optional.of(userDataRepo.save(userInput));
        }
        //If password doen not match then sending the empty Optional<Void>
        else return Optional.empty();
    }
//--------------------------------------------------------------------------------------------------------//

    public userData updateExistingUser(Integer id, userData newUserData)
    {
        return this.userDataRepo.save(newUserData);
    }

//--------------------------------------------------------------------------------------------------------//
    public Optional<String> deleteExistingUser(String userId, String passwd)
    {
        if(passwd.equals(expectedPasswd))
        {
            //Basically First we find whether the user exist with this id,and if yes
            if(userDataRepo.existsById(Integer.parseInt(userId)))
             {
            //then we delete the user Entry and return the userID that was deleted
            userDataRepo.deleteById(Integer.parseInt(userId));
            return Optional.of(userId);
             }
             else return Optional.empty();
        //if no user exist we return the Empty response
          }
        
        else return Optional.empty();
    }

}
