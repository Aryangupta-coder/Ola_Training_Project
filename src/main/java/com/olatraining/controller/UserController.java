package com.olatraining.controller;


import com.olatraining.model.Response;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.olatraining.model.SignUpRequest;

@RestController
public class UserController {

    @PostMapping(value = "/signUp",produces ="application/json", consumes = "application/json")
    public Response signUp(@RequestBody SignUpRequest signUpRequest){
        Response signUpResponse = new Response();
        if(signUpRequest.getEmail().isEmpty()== false && signUpRequest.getId()!= 0 && signUpRequest.getPassword().isEmpty()== false
        && signUpRequest.getPhoneNo().isEmpty()== false){
            signUpResponse.setMessage("Sign up Successful");
            signUpResponse.setStatus(true);

        }else{
            signUpResponse.setMessage("Sign up Failed as all field needs to be filles");
            signUpResponse.setStatus(false);
        }
        return signUpResponse;
    }
}
