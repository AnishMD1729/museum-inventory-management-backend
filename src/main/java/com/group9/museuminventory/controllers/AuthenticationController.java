package com.group9.museuminventory.controllers;

import com.group9.museuminventory.models.Person;
import com.group9.museuminventory.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authenticate")
public class AuthenticationController {

    private PersonRepository personRepository;


    @GetMapping("")
    public String authenticate(@RequestParam String email, @RequestParam String password) {
        Person person = personRepository.findByEmailid(email);
        if (person == null) {
            return "Email not found. Please enter the correct email ID";
        } else if (!person.getPassword().equals(password)) {
            return "Incorrect password.";
        } else {
            return "Authentication successful.";
        }
    }
}

