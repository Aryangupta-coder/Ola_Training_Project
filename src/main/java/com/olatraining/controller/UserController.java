package com.olatraining.controller;


import com.olatraining.model.LoginRequest;
import com.olatraining.model.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.olatraining.model.SignUpRequest;

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
