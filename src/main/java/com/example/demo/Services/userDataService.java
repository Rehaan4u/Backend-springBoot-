package com.example.demo.Services;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Models.userData;

@Service 
public class userDataService {
    public List<userData> returnUserList()
    {
       List<userData> userDataList = Arrays.asList(
             new userData(101,"Rehaan", "Makhija")
        );
        return userDataList;
    }
}
