package com.olatraining.controller;

import com.olatraining.model.LoginRequest;
import com.olatraining.model.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public Response login(@RequestBody LoginRequest loginRequest){
        Response loginResponse = new Response();
        if(loginRequest.getEmail().isEmpty()==true || loginRequest.getPassword().isEmpty()==true){
            return null;
        }
        if(loginRequest.getEmail().equals("abc") && loginRequest.getPassword().equals("123")){
            System.out.println("successful");
            loginResponse.setStatus(true);
            loginResponse.setMessage("login successful");
        }else{
            System.out.println("unsuccessful");
            loginResponse.setStatus(false);
            loginResponse.setMessage("login unsuccessful");
        }
        return loginResponse;
    }

}
