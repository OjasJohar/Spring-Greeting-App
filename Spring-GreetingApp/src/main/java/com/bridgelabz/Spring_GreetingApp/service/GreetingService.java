package com.bridgelabz.Spring_GreetingApp.service;

import com.bridgelabz.Spring_GreetingApp.model.Greeting;
import com.bridgelabz.Spring_GreetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //UseCase: 4
    public void saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        greetingRepository.save(greeting);
    }

    //UseCase: 5
    public Optional<Greeting> findGreetingById(long id){
        return greetingRepository.findById(id);
    }

    //UseCase:6
    public List<Greeting> getAllGreeting(){
        return greetingRepository.findAll();
    }

    //UseCase: 7
    public Optional<Greeting> updatingGreeting(long id, String newMessage){
        Optional<Greeting> existingGreeting=greetingRepository.findById(id);
        if(existingGreeting.isPresent()){
            Greeting greeting=existingGreeting.get();
            greeting.setMessage(newMessage);
            greetingRepository.save(greeting);
            return Optional.of(greeting);
        }else{
            return Optional.empty();
        }
    }
}