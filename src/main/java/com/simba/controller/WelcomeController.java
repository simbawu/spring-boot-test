package com.simba.controller;

import com.simba.domain.WelcomeRequest;
import com.simba.domain.WelcomeResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class WelcomeController {
    @RequestMapping("/welcome")
    public WelcomeResponse welcome(WelcomeRequest welcomeRequest){
        WelcomeResponse response = new WelcomeResponse();
        response.setWebcomeWords("Welcome "  + welcomeRequest.getName() + " to Spring Boot World! ");
        response.setTime(Instant.now().toString());
        return response;
    }
    @RequestMapping("/welcomeMe")
    public WelcomeResponse welcome(String name){
        WelcomeResponse response = new WelcomeResponse();
        response.setWebcomeWords("Welcome "  + name + " to Spring Boot World! ");
        response.setTime(Instant.now().toString());
        return response;
    }

}
