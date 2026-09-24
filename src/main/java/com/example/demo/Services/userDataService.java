package com.example.demo.Services;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.userData;

@Service 
@RestController 
public class userDataService {

    @RequestMapping ("/products")
    public List<userData> returnUserList()
    {
       List<userData> userDataList = Arrays.asList(
             new userData(101,"Rehaan", "Makhija")
        );
        return userDataList;
    }
}
