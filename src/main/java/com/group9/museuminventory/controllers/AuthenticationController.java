package com.group9.museuminventory.controllers;

import com.group9.museuminventory.models.Person;
import com.group9.museuminventory.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/authenticate")
public class AuthenticationController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public String loginFlow(@RequestParam String email, @RequestParam String password) {
        Person person = personRepository.findByEmailid(email);
        if (person == null) {
            return "Email not found. Please enter the correct email ID";
        } else if (!person.getPassword().equals(password)) {
            return "Incorrect password.";
        } else {
            if (person.getRole().equalsIgnoreCase("admin")) {
                return "Authentication successful. You are logged in as an admin.";
            } else if (person.getRole().equalsIgnoreCase("staff")) {
                return "Authentication successful. You are logged in as a staff member.";
            } else {
                return "Authentication successful.";
            }
        }
    }
}

