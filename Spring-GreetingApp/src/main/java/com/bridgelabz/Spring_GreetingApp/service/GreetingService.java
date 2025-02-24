package com.bridgelabz.Spring_GreetingApp.service;

import com.bridgelabz.Spring_GreetingApp.model.Greeting;
import com.bridgelabz.Spring_GreetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreeting(){
        return "Hello world";
    }

    @Autowired
    private GreetingRepository greetingRepository;

    public String getGreeting(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            message = "Hello " + firstName;
        } else if (lastName != null) {
            message = "Hello " + lastName;
        } else {
            message = "Hello World";
        }
        saveGreeting(message);
        return message;
    }

    public void saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        greetingRepository.save(greeting);
    }
}
