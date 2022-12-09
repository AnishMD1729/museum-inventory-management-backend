package com.group9.museuminventory.controllers;

import com.group9.museuminventory.models.Artifact;
import com.group9.museuminventory.models.RFIDTag;
import com.group9.museuminventory.repository.ArtifactRepository;
import com.group9.museuminventory.repository.RFIDTagRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@CrossOrigin
@RestController
@RequestMapping("/api/artifact")
public class ArtifactController {
    @Autowired
    private ArtifactRepository artifactRepository;

    @Autowired
    private RFIDTagRepository rfidTagRepository;

    @GetMapping("/{id}")
    public Artifact getArtifact(@PathVariable UUID id) {
        return artifactRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Iterable<Artifact> getAllArtifacts() {
        return artifactRepository.findAll();
    }

    @Transactional
    @PostMapping
    public Artifact createArtifact(@RequestBody Artifact artifact) {
        double latitude = ThreadLocalRandom.current().nextDouble(-90.0, 90.0);
        double longitude = ThreadLocalRandom.current().nextDouble(-180.0, 180.0);
        String storageCoordinates = latitude + "," + longitude;
        RFIDTag rfidTag = new RFIDTag();
        rfidTag.setStorageCoordinates(storageCoordinates);
        rfidTag.setCreatedAt(new Date());
        rfidTag.setUpdatedAt(new Date());
        artifact.setRfidTag(rfidTag);
        artifact.setCreatedAt(new Date());
        artifact.setUpdatedAt(new Date());
        rfidTag.setArtifact(artifact);

        // Save the Artifact object to the database
        return artifactRepository.save(artifact);
    }

    @PutMapping
    public Artifact updateArtifact(@RequestBody Artifact artifact) {
        return artifactRepository.save(artifact);
    }

    @DeleteMapping("/{id}")
    public void deleteArtifact(@PathVariable UUID id) {
        artifactRepository.deleteById(id);
    }
}