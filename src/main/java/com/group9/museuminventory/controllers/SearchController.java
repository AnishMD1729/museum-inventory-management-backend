package com.group9.museuminventory.controllers;

import com.group9.museuminventory.models.Artifact;
import com.group9.museuminventory.repository.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/search")
public class SearchController {
    @Autowired
    private ArtifactRepository artifactRepository;

    @GetMapping
    public Iterable<Artifact> searchArtifacts(@RequestParam String query) {
        return artifactRepository.findByNameContainingOrCountryContaining(query, query);
    }
}