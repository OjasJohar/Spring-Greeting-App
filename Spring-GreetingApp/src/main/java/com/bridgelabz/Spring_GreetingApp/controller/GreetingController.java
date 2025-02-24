package com.bridgelabz.Spring_GreetingApp.controller;

import com.bridgelabz.Spring_GreetingApp.model.Greeting;
import com.bridgelabz.Spring_GreetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public String getGreeting(){
        return "GET : " + greetingService.getGreeting();
    }

    @PostMapping("/greeting")
    public String postGreeting(){
        return "POST : " + greetingService.getGreeting();
    }

    @PutMapping("/greeting")
    public String putGreeting(){
        return "PUT : " + greetingService.getGreeting();
    }

    @DeleteMapping("/greeting")
    public String deleteGreeting(){
        return "DELETE : " + greetingService.getGreeting();
    }

    //UseCase: 3
    @GetMapping("/greeting/params")
    public String getGreetingParams(@RequestParam(value = "firstName",required = false) String firstName,
                                    @RequestParam(value = "lastName",required = false) String lastName){
        return greetingService.getGreeting(firstName,lastName);
    }

    //UseCase: 5
    @GetMapping("/greeting/{id}")
    public String getGreetingById(@PathVariable long id) {
        Optional<Greeting> greeting = greetingService.findGreetingById(id);
        if (greeting.isPresent()) {
            return greeting.get().getMessage();
        } else {
            return "Greeting not found";
        }
    }
}