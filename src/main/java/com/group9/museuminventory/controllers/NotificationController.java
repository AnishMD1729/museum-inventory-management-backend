package com.group9.museuminventory.controllers;

import com.group9.museuminventory.models.Person;
import com.group9.museuminventory.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public void sendEmail(@RequestBody String storageCoordinates) {
        // Fetch all admins from the database
        List<Person> admins = personRepository.findByRole("admin");

        // Loop through each admin and send an email
        for (Person admin : admins) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(admin.getEmailid());
            message.setSubject("Update from MUSE: RFID tag storage coordinates");
            message.setText("Hello, " + admin.getName() + "!" + " The storage coordinates of the RFID tag has been updated to: " + storageCoordinates);
            mailSender.send(message);
        }
    }
}

