package com.simba.controller;

import com.simba.domain.WelcomeRequest;
import com.simba.domain.WelcomeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class WelcomeController {
    Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    @RequestMapping("/welcome")
    public WelcomeResponse welcome(WelcomeRequest welcomeRequest){
        logger.info("Welcome " + welcomeRequest.getName());
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
