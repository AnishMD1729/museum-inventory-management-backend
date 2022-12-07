package com.group9.museuminventory.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
public class RFIDTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String storageCoordinates;
    private Date createdAt;
    private Date updatedAt;

    @OneToOne(mappedBy = "rfidTag", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Artifact artifact;

    public RFIDTag() {

    }

    public RFIDTag(UUID id, String storageCoordinates) {
        this.id = id;
        this.storageCoordinates = storageCoordinates;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
}