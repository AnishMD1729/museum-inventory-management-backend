package com.group9.museuminventory.controllers;

import com.group9.museuminventory.models.Artifact;
import com.group9.museuminventory.repository.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/artifact")
public class ArtifactController {
    private ArtifactRepository artifactRepository;

    @GetMapping("/{id}")
    public Artifact getArtifact(@PathVariable UUID id) {
        return artifactRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Iterable<Artifact> getAllArtifacts() {
        return artifactRepository.findAll();
    }

    @PostMapping
    public Artifact createArtifact(@RequestBody Artifact artifact) {
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