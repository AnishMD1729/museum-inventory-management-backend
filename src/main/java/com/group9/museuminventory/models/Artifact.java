package com.group9.museuminventory.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Artifact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    private String country;
    private String imageURL;
    private Date createdAt;
    private Date updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rfid_tag_id", referencedColumnName = "id")
    private RFIDTag rfidTag;

    public Artifact() {

    }

    public Artifact(UUID id, String name, String description, String country, RFIDTag rfidTag, String imageURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
        this.imageURL = imageURL;
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.rfidTag = rfidTag;
    }
}
