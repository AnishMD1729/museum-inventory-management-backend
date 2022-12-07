package com.group9.museuminventory.controllers;

import com.group9.museuminventory.models.Artifact;
import com.group9.museuminventory.repository.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    private ArtifactRepository artifactRepository;

    @GetMapping
    public Iterable<Artifact> searchArtifacts(@RequestParam String query) {
        return artifactRepository.findByNameContainingOrCountryContaining(query, query);
    }
}