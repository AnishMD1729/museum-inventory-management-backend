package com.group9.museuminventory.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String emailid;
    private String role;
    private String password;

    public Person() {

    }
    public Person(UUID id, String name, String emailid, String role, String password) {
        this.id = id;
        this.name = name;
        this.emailid = emailid;
        this.role = role;
        this.password = password;
    }
}