package com.group9.museuminventory.repository;

import com.group9.museuminventory.models.Person;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@EnableJpaRepositories(basePackages = {"com.group9.museuminventory.entities"})
public interface PersonRepository extends CrudRepository<Person, UUID> {
    Person findByEmailid(String emailId);
}