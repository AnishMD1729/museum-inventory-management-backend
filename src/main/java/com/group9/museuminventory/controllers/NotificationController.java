package com.group9.museuminventory.controllers;

import com.group9.museuminventory.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    @Autowired
    private JavaMailSender mailSender;

    @PostMapping
    public void sendEmail(@RequestBody Person person, @RequestBody String storageCoordinates) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(person.getEmailid());
        message.setSubject("Update from MUSE: RFID tag storage coordinates");
        message.setText("Hello, " + person.getName() + "!" + "The storage coordinates of the RFID tag has been updated to: " + storageCoordinates);
        mailSender.send(message);
    }
}

