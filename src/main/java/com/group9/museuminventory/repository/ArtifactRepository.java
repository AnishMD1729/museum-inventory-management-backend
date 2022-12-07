package com.group9.museuminventory.repository;

import com.group9.museuminventory.models.Artifact;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@EnableJpaRepositories(basePackages = {"com.group9.museuminventory.entities"})
public interface ArtifactRepository extends CrudRepository<Artifact, UUID> {
    Iterable<Artifact> findByNameContainingOrCountryContaining(String name, String country);
}