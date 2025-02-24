package com.bridgelabz.Spring_GreetingApp.repository;

import com.bridgelabz.Spring_GreetingApp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting,Long> {
}