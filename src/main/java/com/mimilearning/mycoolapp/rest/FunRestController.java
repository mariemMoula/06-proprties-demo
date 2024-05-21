package com.mimilearning.mycoolapp.rest;

import io.micrometer.observation.transport.Propagator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public  String sayHello(){
        return "Hello !";
    }
    //expose a new endpoint for "x"
    @GetMapping("/x")
    public  String sayX(){
        return "Hello from X!";
    }
    //injection properties from the application.resources file
    @Value("${coach.name}")
    private String property1 ;
    @Value("${team.name}")
    private String property2 ;

    //expoe new endpoint to test the injection
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return property2;
    }
    @GetMapping("/coachinfo")
    public String getCoachInfo(){
        return property1;
    }
}
